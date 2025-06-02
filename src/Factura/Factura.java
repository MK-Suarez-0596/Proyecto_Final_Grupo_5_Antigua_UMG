package Factura;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import Conexion.Conexion;
import java.util.Random;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

/**
 * @author MK
 */

public class Factura extends JInternalFrame {

    private JTable tblProductos;
    private DefaultTableModel modeloProductos;
    private JTextArea txtDetalleFactura;
    private JLabel lblHoraFecha;
    private JLabel lblCompraId;
    private JButton btnCalcularTotal, btnGuardarRecibo, btnResetear;
    private JComboBox<ClienteItem> cmbClientes;

    private int compraId;
    private int clienteSeleccionado = -1;

    public void generarNuevoCompraId() {
        Random rand = new Random();
        this.compraId = rand.nextInt(90000) + 10000;
    }

    public int getCompraId() {
        return compraId;
    }
    
    public Factura() {
        super("Factura", true, false, false, false);
        setSize(1030, 750);
        quitarBarraTitulo();
        initComponents();
        generarNuevoCompraId();
    }

    private void quitarBarraTitulo() {
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        this.setBorder(null);
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        generarNuevoCompraId();

        JPanel panelIzq = new JPanel(new BorderLayout());

        JPanel panelClientes = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelClientes.add(new JLabel("Cliente:"));

        cmbClientes = new JComboBox<>();
        cargarClientesDesdeDB();
        cmbClientes.addActionListener(e -> {
            ClienteItem seleccionado = (ClienteItem) cmbClientes.getSelectedItem();
            if (seleccionado != null) {
                clienteSeleccionado = seleccionado.getId();
            } else {
                clienteSeleccionado = -1;
            }
        });
        panelClientes.add(cmbClientes);
        panelIzq.add(panelClientes, BorderLayout.NORTH);

        modeloProductos = new DefaultTableModel(new Object[]{"Comprar", "Producto", "Precio", "Cantidad"}, 0) {
            @Override
            public Class<?> getColumnClass(int col) {
                if (col == 0) return Boolean.class;
                if (col == 3) return Integer.class;
                return String.class;
            }
            @Override
            public boolean isCellEditable(int row, int col) {
                return col == 0 || col == 3;
            }
        };

        tblProductos = new JTable(modeloProductos);
        JScrollPane scrollProductos = new JScrollPane(tblProductos);
        panelIzq.add(scrollProductos, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        btnCalcularTotal = new JButton("Calcular Total");
        btnGuardarRecibo = new JButton("Guardar Recibo");
        btnResetear = new JButton("Resetear");
        panelBotones.add(btnCalcularTotal);
        panelBotones.add(btnGuardarRecibo);
        panelBotones.add(btnResetear);
        panelIzq.add(panelBotones, BorderLayout.SOUTH);

        JPanel panelDer = new JPanel(new BorderLayout());
        JPanel panelEncabezado = new JPanel(new GridLayout(3, 1));
        panelEncabezado.add(new JLabel("-------------------------- Empresa --------------------------", SwingConstants.CENTER));
        lblHoraFecha = new JLabel();
        lblCompraId = new JLabel("Compra ID: " + compraId);
        panelEncabezado.add(lblHoraFecha);
        panelEncabezado.add(lblCompraId);
        panelDer.add(panelEncabezado, BorderLayout.NORTH);

        txtDetalleFactura = new JTextArea();
        txtDetalleFactura.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        txtDetalleFactura.setEditable(false);
        panelDer.add(new JScrollPane(txtDetalleFactura), BorderLayout.CENTER);

        JPanel panelTotales = new JPanel(new GridLayout(5, 1));
        panelTotales.add(new JLabel("-------------------------------------------------------------", SwingConstants.CENTER));
        panelTotales.add(new JLabel("Subtotal (sin IVA): Q0.00"));
        panelTotales.add(new JLabel("IVA (12%): Q0.00"));
        panelTotales.add(new JLabel("Total: Q0.00"));
        panelTotales.add(new JLabel("------------------- Gracias por su compra -------------------", SwingConstants.CENTER));
        panelDer.add(panelTotales, BorderLayout.SOUTH);

        add(panelIzq, BorderLayout.WEST);
        add(panelDer, BorderLayout.CENTER);

        actualizarHoraFecha();
        cargarDatosProductosDesdeDB();

        btnCalcularTotal.addActionListener(e -> calcularMostrarTotal(panelTotales));
        btnGuardarRecibo.addActionListener(e -> {
            try {
                guardarPdf(panelTotales);
                JOptionPane.showMessageDialog(this, "Recibo guardado con éxito.");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error guardando PDF.");
            }
        });
        btnResetear.addActionListener(e -> {
            resetear();
            generarNuevoCompraId();
            panelTotales.removeAll();
            panelTotales.add(new JLabel("-------------------------------------------------------------", SwingConstants.CENTER));
            panelTotales.add(new JLabel("Subtotal (sin IVA): Q0.00"));
            panelTotales.add(new JLabel("IVA (12%): Q0.00"));
            panelTotales.add(new JLabel("Total: Q0.00"));
            panelTotales.add(new JLabel("------------------- Gracias por su compra -------------------", SwingConstants.CENTER));
            panelTotales.revalidate();
            panelTotales.repaint();
        });
    }

    private void cargarClientesDesdeDB() {
        Conexion conexion = new Conexion();
        try (
            Connection con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT id, nombre FROM cliente ORDER BY nombre ASC");
            ResultSet rs = ps.executeQuery()
        ) {
            cmbClientes.removeAllItems();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                cmbClientes.addItem(new ClienteItem(id, nombre));
            }
            if (cmbClientes.getItemCount() > 0) {
                cmbClientes.setSelectedIndex(0);
                clienteSeleccionado = ((ClienteItem) cmbClientes.getSelectedItem()).getId();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error cargando clientes: " + ex.getMessage());
        }
    }

    private void cargarDatosProductosDesdeDB() {
        Conexion conexion = new Conexion();
        try (
            Connection con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT producto, precio FROM producto WHERE stock > 0");
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                modeloProductos.addRow(new Object[]{
                    false,
                    rs.getString("producto"),
                    rs.getString("precio"),
                    0
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error cargando productos: " + ex.getMessage());
        }
    }

    private void calcularMostrarTotal(JPanel panelTotales) {
        StringBuilder detalle = new StringBuilder();
        detalle.append(String.format("%-5s %-20s %-10s %-10s%n", "Item:", "Producto", "Cantidad", "Precio(Q)"));
        BigDecimal subtotal = BigDecimal.ZERO;
        int itemNum = 1;

        for (int i = 0; i < modeloProductos.getRowCount(); i++) {
            boolean comprar = (boolean) modeloProductos.getValueAt(i, 0);
            if (comprar) {
                String producto = (String) modeloProductos.getValueAt(i, 1);
                int cantidad = (Integer) modeloProductos.getValueAt(i, 3);
                if (cantidad <= 0) continue;
                BigDecimal precio = new BigDecimal((String) modeloProductos.getValueAt(i, 2));
                BigDecimal totalItem = precio.multiply(BigDecimal.valueOf(cantidad));
                subtotal = subtotal.add(totalItem);
                detalle.append(String.format("%-5d %-20s %-10d %-10.2f%n", itemNum++, producto, cantidad, totalItem));
            }
        }

        if (itemNum == 1) {
            txtDetalleFactura.setText("No hay productos seleccionados.");
            return;
        }

        BigDecimal iva = subtotal.multiply(BigDecimal.valueOf(0.12));
        BigDecimal total = subtotal.add(iva);
        txtDetalleFactura.setText(detalle.toString());

        panelTotales.removeAll();
        panelTotales.add(new JLabel("-----------------------------------------------------------", SwingConstants.CENTER));
        panelTotales.add(new JLabel(String.format("Subtotal (sin IVA): Q%.2f", subtotal)));
        panelTotales.add(new JLabel(String.format("IVA (12%%): Q%.2f", iva)));
        panelTotales.add(new JLabel(String.format("Total: Q%.2f", total)));
        panelTotales.add(new JLabel("------------------- Gracias por su compra -------------------", SwingConstants.CENTER));
        panelTotales.revalidate();
        panelTotales.repaint();
    }

    private void resetear() {
        for (int i = 0; i < modeloProductos.getRowCount(); i++) {
            modeloProductos.setValueAt(false, i, 0);
            modeloProductos.setValueAt(0, i, 3);
        }
        txtDetalleFactura.setText("");
    }

    private void guardarPdf(JPanel panelTotales) throws IOException {
        PDDocument doc = new PDDocument();
        File archivoPDF = null;

        try {
            PDPage page = new PDPage();
            doc.addPage(page);

            File fuenteArchivo = new File("src/Otros_recursos/Roboto-Medium.ttf");
            PDType0Font font = PDType0Font.load(doc, fuenteArchivo);

            PDPageContentStream contenido = new PDPageContentStream(doc, page);
            contenido.beginText();
            contenido.setFont(font, 12);

            float margin = 50;
            float yStart = 700;
            float leading = 15;
            contenido.newLineAtOffset(margin, yStart);

            contenido.showText("-------------------------- Empresa --------------------------");
            contenido.newLineAtOffset(0, -leading);

            SimpleDateFormat sdfHora = new SimpleDateFormat("hh:mm:ss a");
            SimpleDateFormat sdfFecha = new SimpleDateFormat("EEEE, dd/MM/yyyy");
            Date ahora = new Date();
            
            contenido.showText("Hora: " + sdfHora.format(ahora));
            contenido.newLineAtOffset(0, -leading);
            
            contenido.showText("Fecha: " + sdfFecha.format(ahora));
            contenido.newLineAtOffset(0, -leading);
            
            contenido.showText("Compra ID: " + compraId);
            contenido.newLineAtOffset(0, -leading);

            ClienteItem cliente = (ClienteItem) cmbClientes.getSelectedItem();
            contenido.showText("Cliente: " + (cliente != null ? cliente.getNombre() : "No seleccionado"));
            contenido.newLineAtOffset(0, -leading);

            contenido.showText("-----------------------------------------------------------");
            contenido.newLineAtOffset(0, -leading);

            String texto = txtDetalleFactura.getText();
            if (texto.isEmpty()) {
                contenido.showText("No hay detalles para imprimir.");
            } else {
                String[] lineas = texto.split("\n");
                for (String linea : lineas) {
                    contenido.showText(linea);
                    contenido.newLineAtOffset(0, -leading);
                }
            }

            contenido.newLineAtOffset(0, -leading);
            contenido.showText("-----------------------------------------------------------");
            contenido.newLineAtOffset(0, -leading);

            BigDecimal subtotal = BigDecimal.ZERO;
            BigDecimal iva = BigDecimal.ZERO;
            BigDecimal total = BigDecimal.ZERO;

            for (Component comp : panelTotales.getComponents()) {
                if (comp instanceof JLabel) {
                    String text = ((JLabel) comp).getText();
                    if (text.startsWith("Subtotal")) {
                        subtotal = new BigDecimal(text.replaceAll("[^0-9.]", ""));
                    } else if (text.startsWith("IVA")) {
                        iva = new BigDecimal(text.replaceAll("[^0-9.]", ""));
                    } else if (text.startsWith("Total")) {
                        total = new BigDecimal(text.replaceAll("[^0-9.]", ""));
                    }
                }
            }

            contenido.showText(String.format("Subtotal (sin IVA): Q%.2f", subtotal));
            contenido.newLineAtOffset(0, -leading);
            contenido.showText(String.format("IVA (12%%): Q%.2f", iva));
            contenido.newLineAtOffset(0, -leading);
            contenido.showText(String.format("Total: Q%.2f", total));
            contenido.newLineAtOffset(0, -leading);

            contenido.showText("------------------ Gracias por su compra ------------------");
            contenido.endText();
            contenido.close();

            File carpeta = new File("src/Recibos");
            if (!carpeta.exists()) carpeta.mkdirs();

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            archivoPDF = new File(carpeta, "factura_" + timestamp + ".pdf");
            doc.save(archivoPDF);
        } finally {
            doc.close();
        }

        if (archivoPDF != null && archivoPDF.exists()) {
            Desktop.getDesktop().open(archivoPDF);
        }
    }

    private void actualizarHoraFecha() {
        Date ahora = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        lblHoraFecha.setText("Fecha y hora: " + sdf.format(ahora));
    }

    private static class ClienteItem {
        private int id;
        private String nombre;

        public ClienteItem(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }
}
