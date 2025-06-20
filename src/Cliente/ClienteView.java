/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Cliente;

import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MK
 */
public class ClienteView extends javax.swing.JInternalFrame {

    /**
     * Creates new form ClienteView2
     */
    private JPanel[] paneles;
    private ClienteController controller = new ClienteController();
    private DefaultTableModel modeloTabla;
    public ClienteView() {
        initComponents();
        tblClient.setFocusable(false);
        scroll_tbl.setBorder(null);
        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Telefono", "Direccion", "Email"}, 0);
        tblClient.setModel(modeloTabla);
        

        scroll_tbl.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        limpiarCampos();
        cargarClientes();

        
// <editor-fold defaultstate="collapsed" desc="Configuraciones de Botones">
    paneles = new JPanel[] { btn_add, btn_search, btn_update, btn_delete, btn_clear, btn_showall }; 
    Color colorNormal = new Color(71,13,188);  
    Color colorHover = new Color(115,67,210);

        for (JPanel panel : paneles) {
            panel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                    panel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                    panel.setBackground(colorHover);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                    panel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                    panel.setBackground(colorNormal);
            }
            });

        }// </editor-fold>
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        id = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        telefono = new javax.swing.JLabel();
        direccion = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_telef = new javax.swing.JTextField();
        txt_direct = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        scroll_tbl = new javax.swing.JScrollPane();
        tblClient = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        btn_add = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_update = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_search = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn_delete = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btn_clear = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btn_showall = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setForeground(new java.awt.Color(204, 204, 204));
        background.setMaximumSize(new java.awt.Dimension(1026, 714));
        background.setMinimumSize(new java.awt.Dimension(1026, 714));

        id.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        id.setForeground(new java.awt.Color(0, 0, 0));
        id.setText("ID:");

        name.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        name.setForeground(new java.awt.Color(0, 0, 0));
        name.setText("Nombre:");

        telefono.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        telefono.setForeground(new java.awt.Color(0, 0, 0));
        telefono.setText("Telefono:");

        direccion.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        direccion.setForeground(new java.awt.Color(0, 0, 0));
        direccion.setText("Direccion:");

        email.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        email.setForeground(new java.awt.Color(0, 0, 0));
        email.setText("Email:");

        txt_id.setBackground(new java.awt.Color(255, 255, 255));
        txt_id.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        txt_id.setForeground(new java.awt.Color(204, 204, 204));
        txt_id.setBorder(null);
        txt_id.setPreferredSize(new java.awt.Dimension(300, 25));
        txt_id.setSelectionColor(new java.awt.Color(255, 255, 255));

        txt_name.setBackground(new java.awt.Color(255, 255, 255));
        txt_name.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        txt_name.setForeground(new java.awt.Color(204, 204, 204));
        txt_name.setBorder(null);
        txt_name.setPreferredSize(new java.awt.Dimension(300, 25));
        txt_name.setSelectionColor(new java.awt.Color(255, 255, 255));

        txt_telef.setBackground(new java.awt.Color(255, 255, 255));
        txt_telef.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        txt_telef.setForeground(new java.awt.Color(204, 204, 204));
        txt_telef.setBorder(null);
        txt_telef.setPreferredSize(new java.awt.Dimension(300, 25));
        txt_telef.setSelectionColor(new java.awt.Color(255, 255, 255));

        txt_direct.setBackground(new java.awt.Color(255, 255, 255));
        txt_direct.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        txt_direct.setForeground(new java.awt.Color(204, 204, 204));
        txt_direct.setBorder(null);
        txt_direct.setPreferredSize(new java.awt.Dimension(300, 25));
        txt_direct.setSelectionColor(new java.awt.Color(255, 255, 255));

        txt_email.setBackground(new java.awt.Color(255, 255, 255));
        txt_email.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        txt_email.setForeground(new java.awt.Color(204, 204, 204));
        txt_email.setBorder(null);
        txt_email.setPreferredSize(new java.awt.Dimension(300, 25));
        txt_email.setSelectionColor(new java.awt.Color(255, 255, 255));

        scroll_tbl.setBackground(new java.awt.Color(255, 255, 255));
        scroll_tbl.setBorder(null);
        scroll_tbl.setForeground(new java.awt.Color(0, 0, 0));
        scroll_tbl.setFocusable(false);
        scroll_tbl.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N

        tblClient.setBackground(new java.awt.Color(255, 255, 255));
        tblClient.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        tblClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Telefono", "Direccion", "Email"
            }
        ));
        tblClient.setColumnSelectionAllowed(true);
        scroll_tbl.setViewportView(tblClient);
        tblClient.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));

        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));

        jSeparator5.setForeground(new java.awt.Color(204, 204, 204));

        jSeparator6.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btn_add.setBackground(new java.awt.Color(71, 13, 188));
        btn_add.setMaximumSize(new java.awt.Dimension(140, 40));
        btn_add.setMinimumSize(new java.awt.Dimension(140, 40));
        btn_add.setPreferredSize(new java.awt.Dimension(140, 40));
        btn_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Agregar");

        javax.swing.GroupLayout btn_addLayout = new javax.swing.GroupLayout(btn_add);
        btn_add.setLayout(btn_addLayout);
        btn_addLayout.setHorizontalGroup(
            btn_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_addLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1))
        );
        btn_addLayout.setVerticalGroup(
            btn_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_addLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1))
        );

        btn_update.setBackground(new java.awt.Color(71, 13, 188));
        btn_update.setMaximumSize(new java.awt.Dimension(140, 40));
        btn_update.setMinimumSize(new java.awt.Dimension(140, 40));
        btn_update.setPreferredSize(new java.awt.Dimension(140, 40));
        btn_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_updateMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Actualizar");

        javax.swing.GroupLayout btn_updateLayout = new javax.swing.GroupLayout(btn_update);
        btn_update.setLayout(btn_updateLayout);
        btn_updateLayout.setHorizontalGroup(
            btn_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_updateLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel3))
        );
        btn_updateLayout.setVerticalGroup(
            btn_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_updateLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel3))
        );

        btn_search.setBackground(new java.awt.Color(71, 13, 188));
        btn_search.setMaximumSize(new java.awt.Dimension(140, 40));
        btn_search.setMinimumSize(new java.awt.Dimension(140, 40));
        btn_search.setPreferredSize(new java.awt.Dimension(140, 40));
        btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_searchMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar");

        javax.swing.GroupLayout btn_searchLayout = new javax.swing.GroupLayout(btn_search);
        btn_search.setLayout(btn_searchLayout);
        btn_searchLayout.setHorizontalGroup(
            btn_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_searchLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel2))
        );
        btn_searchLayout.setVerticalGroup(
            btn_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_searchLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2))
        );

        btn_delete.setBackground(new java.awt.Color(71, 13, 188));
        btn_delete.setMaximumSize(new java.awt.Dimension(140, 40));
        btn_delete.setMinimumSize(new java.awt.Dimension(140, 40));
        btn_delete.setPreferredSize(new java.awt.Dimension(140, 40));
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Eliminar");

        javax.swing.GroupLayout btn_deleteLayout = new javax.swing.GroupLayout(btn_delete);
        btn_delete.setLayout(btn_deleteLayout);
        btn_deleteLayout.setHorizontalGroup(
            btn_deleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_deleteLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel4))
        );
        btn_deleteLayout.setVerticalGroup(
            btn_deleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_deleteLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel4))
        );

        btn_clear.setBackground(new java.awt.Color(71, 13, 188));
        btn_clear.setMaximumSize(new java.awt.Dimension(140, 40));
        btn_clear.setMinimumSize(new java.awt.Dimension(140, 40));
        btn_clear.setPreferredSize(new java.awt.Dimension(140, 40));
        btn_clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_clearMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Limpiar");

        javax.swing.GroupLayout btn_clearLayout = new javax.swing.GroupLayout(btn_clear);
        btn_clear.setLayout(btn_clearLayout);
        btn_clearLayout.setHorizontalGroup(
            btn_clearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_clearLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel6))
        );
        btn_clearLayout.setVerticalGroup(
            btn_clearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_clearLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel6))
        );

        btn_showall.setBackground(new java.awt.Color(71, 13, 188));
        btn_showall.setMaximumSize(new java.awt.Dimension(140, 40));
        btn_showall.setMinimumSize(new java.awt.Dimension(140, 40));
        btn_showall.setPreferredSize(new java.awt.Dimension(140, 40));
        btn_showall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_showallMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Mostrar todos");

        javax.swing.GroupLayout btn_showallLayout = new javax.swing.GroupLayout(btn_showall);
        btn_showall.setLayout(btn_showallLayout);
        btn_showallLayout.setHorizontalGroup(
            btn_showallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_showallLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel7))
        );
        btn_showallLayout.setVerticalGroup(
            btn_showallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_showallLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel7))
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id)
                    .addComponent(name)
                    .addComponent(telefono)
                    .addComponent(direccion)
                    .addComponent(email))
                .addGap(20, 20, 20)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_telef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_direct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btn_showall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scroll_tbl, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(id)
                        .addGap(23, 23, 23)
                        .addComponent(name)
                        .addGap(23, 23, 23)
                        .addComponent(telefono)
                        .addGap(23, 23, 23)
                        .addComponent(direccion)
                        .addGap(23, 23, 23)
                        .addComponent(email))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(txt_telef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(txt_direct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btn_showall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(scroll_tbl, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseClicked
    ClienteModel nuevo = new ClienteModel(0,
        txt_name.getText(),
        txt_telef.getText(),
        txt_direct.getText(),
        txt_email.getText()
    );

    if (controller.add(nuevo)) {
        JOptionPane.showMessageDialog(this, "Cliente agregado exitosamente");
        cargarClientes(); // Refrescar tabla
    } else {
        JOptionPane.showMessageDialog(this, "Error al agregar cliente");
    }
    }//GEN-LAST:event_btn_addMouseClicked

    private void btn_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseClicked
        // TODO add your handling code here:
    try {
        int id = Integer.parseInt(txt_id.getText());
        searchbyid(id);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID inválido");
    }

    }//GEN-LAST:event_btn_searchMouseClicked

    private void btn_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_updateMouseClicked
    int fila = tblClient.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Selecciona un cliente para editar");
        return;
    }

    ClienteModel actualizado = new ClienteModel(
        Integer.parseInt(tblClient.getValueAt(fila, 0).toString()),
        txt_name.getText(),
        txt_telef.getText(),
        txt_direct.getText(),
        txt_email.getText()
    );

    if (controller.edit(actualizado)) {
        JOptionPane.showMessageDialog(this, "Cliente actualizado");
        cargarClientes(); // Refrescar tabla
    } else {
        JOptionPane.showMessageDialog(this, "Error al actualizar cliente");
    }
    }//GEN-LAST:event_btn_updateMouseClicked

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
    int fila = tblClient.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Selecciona un cliente para eliminar");
        return;
    }

    int id = Integer.parseInt(tblClient.getValueAt(fila, 0).toString());

    int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar cliente con ID: " + id + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        if (ClienteController.errease(id)) {
            JOptionPane.showMessageDialog(this, "Cliente eliminado");
            cargarClientes();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar cliente");
        }
    }
    }//GEN-LAST:event_btn_deleteMouseClicked

    private void btn_clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearMouseClicked
        // TODO add your handling code here:
       limpiarCampos();
    }//GEN-LAST:event_btn_clearMouseClicked

    private void btn_showallMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_showallMouseClicked
        // TODO add your handling code here
        cargarClientes();  
    }//GEN-LAST:event_btn_showallMouseClicked

    private void cargarClientes() {
    modeloTabla.setRowCount(0); // Limpiar tabla
    List<ClienteModel> lista = ClienteController.getAll();
    for (ClienteModel c : lista) {
        modeloTabla.addRow(new Object[]{
            c.getId(),
            c.getNombre(),
            c.getTelefono(),
            c.getDireccion(),
            c.getEmail()
        });
    }
    }

private void searchbyid(int id) {
    modeloTabla.setRowCount(0); // Limpiar tabla
    ClienteModel cliente = ClienteController.search(id);
    if (cliente != null) {
        modeloTabla.addRow(new Object[]{
            cliente.getId(),
            cliente.getNombre(),
            cliente.getTelefono(),
            cliente.getDireccion(),
            cliente.getEmail()
        });
    } else {
        JOptionPane.showMessageDialog(this, "Cliente no encontrado con ID: " + id);
    }
}

private void limpiarCampos() {
    txt_id.setText("");
    txt_name.setText("");
    txt_telef.setText("");
    txt_direct.setText("");
    txt_email.setText("");
}


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel btn_add;
    private javax.swing.JPanel btn_clear;
    private javax.swing.JPanel btn_delete;
    private javax.swing.JPanel btn_search;
    private javax.swing.JPanel btn_showall;
    private javax.swing.JPanel btn_update;
    private javax.swing.JLabel direccion;
    private javax.swing.JLabel email;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel name;
    private javax.swing.JScrollPane scroll_tbl;
    private javax.swing.JTable tblClient;
    private javax.swing.JLabel telefono;
    private javax.swing.JTextField txt_direct;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_telef;
    // End of variables declaration//GEN-END:variables
}
