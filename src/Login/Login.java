/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Login;

import Modulos.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import Conexion.Conexion;
import javax.swing.JOptionPane;
import java.awt.Color;

/**
 * @author MK
 */
public class Login extends javax.swing.JFrame {

    int xmouse, ymouse;
    public Login() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        Empresa = new javax.swing.JLabel();
        Logo_Name = new javax.swing.JLabel();
        Semi_Background = new javax.swing.JLabel();
        bar = new javax.swing.JPanel();
        exit_cube = new javax.swing.JPanel();
        exit_txt = new javax.swing.JLabel();
        Iniicio_Sesion = new javax.swing.JLabel();
        User_Field = new javax.swing.JLabel();
        User_txt = new javax.swing.JTextField();
        Separator_User = new javax.swing.JSeparator();
        Pass_Field = new javax.swing.JLabel();
        Password_txt = new javax.swing.JPasswordField();
        Separator_Password = new javax.swing.JSeparator();
        loginbtn = new javax.swing.JPanel();
        loginbtntxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1080, 720));

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setPreferredSize(new java.awt.Dimension(1080, 720));

        Logo.setBackground(new java.awt.Color(255, 255, 255));
        Logo.setForeground(new java.awt.Color(255, 255, 255));
        Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo_2.png"))); // NOI18N
        Logo.setMaximumSize(new java.awt.Dimension(270, 270));
        Logo.setMinimumSize(new java.awt.Dimension(270, 270));
        Logo.setPreferredSize(new java.awt.Dimension(270, 270));

        Empresa.setBackground(new java.awt.Color(255, 255, 255));
        Empresa.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        Empresa.setForeground(new java.awt.Color(255, 255, 255));
        Empresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Empresa.setText("Empresa");

        Logo_Name.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        Logo_Name.setForeground(new java.awt.Color(0, 0, 0));
        Logo_Name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mini_logo.png"))); // NOI18N
        Logo_Name.setText("LOGO");

        Semi_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon.jpg"))); // NOI18N

        bar.setBackground(new java.awt.Color(255, 255, 255));
        bar.setOpaque(false);
        bar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barMouseDragged(evt);
            }
        });
        bar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barMousePressed(evt);
            }
        });

        exit_cube.setBackground(new java.awt.Color(255, 255, 255));
        exit_cube.setMinimumSize(new java.awt.Dimension(50, 50));
        exit_cube.setPreferredSize(new java.awt.Dimension(50, 50));

        exit_txt.setFont(new java.awt.Font("Roboto Light", 0, 48)); // NOI18N
        exit_txt.setForeground(new java.awt.Color(0, 0, 0));
        exit_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit_txt.setText("x");
        exit_txt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_txtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit_txtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit_txtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exit_cubeLayout = new javax.swing.GroupLayout(exit_cube);
        exit_cube.setLayout(exit_cubeLayout);
        exit_cubeLayout.setHorizontalGroup(
            exit_cubeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exit_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        exit_cubeLayout.setVerticalGroup(
            exit_cubeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exit_cubeLayout.createSequentialGroup()
                .addComponent(exit_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout barLayout = new javax.swing.GroupLayout(bar);
        bar.setLayout(barLayout);
        barLayout.setHorizontalGroup(
            barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barLayout.createSequentialGroup()
                .addComponent(exit_cube, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1030, Short.MAX_VALUE))
        );
        barLayout.setVerticalGroup(
            barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barLayout.createSequentialGroup()
                .addComponent(exit_cube, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Iniicio_Sesion.setFont(new java.awt.Font("Roboto Black", 0, 48)); // NOI18N
        Iniicio_Sesion.setForeground(new java.awt.Color(0, 0, 0));
        Iniicio_Sesion.setText("INICIAR SESION");

        User_Field.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        User_Field.setForeground(new java.awt.Color(0, 0, 0));
        User_Field.setText("USUARIO");

        User_txt.setBackground(new java.awt.Color(255, 255, 255));
        User_txt.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        User_txt.setForeground(new java.awt.Color(204, 204, 204));
        User_txt.setText("Ingrese su Usuario");
        User_txt.setBorder(null);
        User_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                User_txtMousePressed(evt);
            }
        });

        Separator_User.setForeground(new java.awt.Color(0, 0, 0));

        Pass_Field.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Pass_Field.setForeground(new java.awt.Color(0, 0, 0));
        Pass_Field.setText("CONTRASEÑA");

        Password_txt.setBackground(new java.awt.Color(255, 255, 255));
        Password_txt.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        Password_txt.setForeground(new java.awt.Color(204, 204, 204));
        Password_txt.setText("**********");
        Password_txt.setBorder(null);
        Password_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Password_txtMousePressed(evt);
            }
        });

        Separator_Password.setForeground(new java.awt.Color(0, 0, 0));

        loginbtn.setBackground(new java.awt.Color(97, 167, 165));
        loginbtn.setForeground(new java.awt.Color(255, 255, 255));
        loginbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginbtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginbtnMouseExited(evt);
            }
        });

        loginbtntxt.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        loginbtntxt.setForeground(new java.awt.Color(255, 255, 255));
        loginbtntxt.setText("ENTRAR");

        javax.swing.GroupLayout loginbtnLayout = new javax.swing.GroupLayout(loginbtn);
        loginbtn.setLayout(loginbtnLayout);
        loginbtnLayout.setHorizontalGroup(
            loginbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginbtnLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(loginbtntxt)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        loginbtnLayout.setVerticalGroup(
            loginbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginbtnLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(loginbtntxt)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(Logo_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Iniicio_Sesion)
                    .addComponent(User_Field)
                    .addComponent(Separator_User, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pass_Field))
                .addGap(185, 185, 185)
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(Password_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(272, 272, 272)
                .addComponent(Empresa))
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(loginbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(Separator_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(User_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(580, 580, 580)
                .addComponent(Semi_Background))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(Logo_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Iniicio_Sesion)
                        .addGap(53, 53, 53)
                        .addComponent(User_Field)
                        .addGap(41, 41, 41)
                        .addComponent(Separator_User, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(Pass_Field))
                    .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Password_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Empresa)))
                .addGap(101, 101, 101)
                .addComponent(loginbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(500, 500, 500)
                .addComponent(Separator_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(User_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(Semi_Background)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void barMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barMousePressed
    xmouse= evt.getX();
    ymouse= evt.getY();
    }//GEN-LAST:event_barMousePressed

    private void barMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xmouse,y - ymouse);
    }//GEN-LAST:event_barMouseDragged

    private void exit_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_txtMouseClicked
    System.exit(0);
    }//GEN-LAST:event_exit_txtMouseClicked

    private void exit_txtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_txtMouseEntered
    exit_cube.setBackground(Color.red);
    exit_txt.setForeground(Color.white);
    }//GEN-LAST:event_exit_txtMouseEntered

    private void exit_txtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_txtMouseExited
    exit_cube.setBackground(Color.white);
    exit_txt.setForeground(Color.black);
    }//GEN-LAST:event_exit_txtMouseExited

    private void loginbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginbtnMouseEntered
    loginbtn.setBackground(new Color(16,33,40));
    loginbtntxt.setForeground(Color.WHITE);    
    }//GEN-LAST:event_loginbtnMouseEntered

    private void loginbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginbtnMouseExited
    loginbtn.setBackground(new Color(97,167,165));
    loginbtntxt.setForeground(Color.WHITE);    
    }//GEN-LAST:event_loginbtnMouseExited

    private void loginbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginbtnMouseClicked
    String usuario = User_txt.getText();
    String contrasena = new String(Password_txt.getPassword());

    try {
        // Cargar datos del archivo de configuracion y conectar
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();

        // Consulta SQL simple
        String sql = "SELECT * FROM usuario WHERE usuario = ? AND password = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, usuario);
        stmt.setString(2, contrasena);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // Credenciales válidas, abrir el dashboard
            Modulos.Dashboard dashboard = new Modulos.Dashboard();
            dashboard.setVisible(true);
            this.dispose(); // Cierra la ventana de login
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
        }

        // Cerrar conexión
        rs.close();
        stmt.close();
        conn.close();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos:\n" + e.getMessage());
    }

    }//GEN-LAST:event_loginbtnMouseClicked

    private void User_txtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_User_txtMousePressed
    if (User_txt.getText().equals("Ingrese su Usuario")){
        User_txt.setText("");
        User_txt.setForeground(Color.BLACK);
    }
    if(String.valueOf(Password_txt.getPassword()).isEmpty()){
        Password_txt.setText("**********");
        Password_txt.setForeground(new Color(204,204,204));
    }
    }//GEN-LAST:event_User_txtMousePressed

    private void Password_txtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Password_txtMousePressed
    if(String.valueOf(Password_txt.getPassword()).equals("**********")){
        Password_txt.setText("");
        Password_txt.setForeground(Color.BLACK);
    }
    if(User_txt.getText().isEmpty()){
        User_txt.setText("Ingrese su Usuario");
        User_txt.setForeground(new Color(204,204,204));
    }
    }//GEN-LAST:event_Password_txtMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JLabel Empresa;
    private javax.swing.JLabel Iniicio_Sesion;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel Logo_Name;
    private javax.swing.JLabel Pass_Field;
    private javax.swing.JPasswordField Password_txt;
    private javax.swing.JLabel Semi_Background;
    private javax.swing.JSeparator Separator_Password;
    private javax.swing.JSeparator Separator_User;
    private javax.swing.JLabel User_Field;
    private javax.swing.JTextField User_txt;
    private javax.swing.JPanel bar;
    private javax.swing.JPanel exit_cube;
    private javax.swing.JLabel exit_txt;
    private javax.swing.JPanel loginbtn;
    private javax.swing.JLabel loginbtntxt;
    // End of variables declaration//GEN-END:variables
}
