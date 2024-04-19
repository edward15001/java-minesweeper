package GUI;

import buscaminasjunio.Clase_Entre_Ventanas;
import javax.swing.JOptionPane;

/**
 *
 * @author edwar
 */
public class FAdmin extends javax.swing.JFrame {

    String user = new String();
    String passw = new String();
    Clase_Entre_Ventanas data = new Clase_Entre_Ventanas();
    private static FFuncAdmin ventanaAvanzada = new FFuncAdmin();
    private static FMenuInicial menu = new FMenuInicial();


    private void comprobar() {  //Comprueba que los datos introducidos corresponden con los del administrador.
        if (user.equals(data.getAdmin().getNombre()) && passw.equals(data.getAdmin().getContrasenia())) {
            //Si las credenciales introducidas son correctas.
            ventanaAvanzada.setVisible(true);
            ventanaAvanzada.setLocationRelativeTo(null);
            ventanaAvanzada.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.dispose();
        } else {
            mensaje.setText("Datos erroneos");
        }
    }

    public FAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        claveAdmin = new javax.swing.JTextField();
        nombreAdmin = new javax.swing.JTextField();
        admin = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        titulo2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mensaje = new javax.swing.JTextArea();
        volver = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 800));
        setResizable(false);

        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        claveAdmin.setBackground(new java.awt.Color(23, 90, 41));
        claveAdmin.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        claveAdmin.setForeground(new java.awt.Color(255, 255, 255));
        claveAdmin.setBorder(null);
        panelPrincipal.add(claveAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 170, 30));

        nombreAdmin.setBackground(new java.awt.Color(23, 90, 41));
        nombreAdmin.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        nombreAdmin.setForeground(new java.awt.Color(255, 255, 255));
        nombreAdmin.setBorder(null);
        panelPrincipal.add(nombreAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 170, 30));

        admin.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        admin.setForeground(new java.awt.Color(0, 0, 0));
        admin.setText("Admin:");
        panelPrincipal.add(admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        password.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        password.setForeground(new java.awt.Color(0, 0, 0));
        password.setText("Contraseña:");
        panelPrincipal.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        login.setBackground(new java.awt.Color(111, 204, 102));
        login.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        login.setForeground(new java.awt.Color(51, 51, 51));
        login.setText("LOGIN");
        login.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        login.setMaximumSize(new java.awt.Dimension(63, 33));
        login.setMinimumSize(new java.awt.Dimension(63, 33));
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        panelPrincipal.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 120, 40));

        titulo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/TITULO-ADMINISTRADOR.png"))); // NOI18N
        panelPrincipal.add(titulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-110, 0, 600, -1));

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        mensaje.setBackground(new java.awt.Color(111, 204, 102));
        mensaje.setColumns(20);
        mensaje.setForeground(new java.awt.Color(111, 204, 102));
        mensaje.setRows(5);
        jScrollPane1.setViewportView(mensaje);

        panelPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, -1, -1));

        volver.setBackground(new java.awt.Color(111, 204, 102));
        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons.return/icons8-volver-48.png"))); // NOI18N
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        panelPrincipal.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 70, 70));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/fondoBatalla.jpg"))); // NOI18N
        panelPrincipal.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        user = nombreAdmin.getText();
        passw = claveAdmin.getText();
        comprobar();    }//GEN-LAST:event_loginActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_volverActionPerformed

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
            java.util.logging.Logger.getLogger(FAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin;
    private javax.swing.JTextField claveAdmin;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton login;
    private javax.swing.JTextArea mensaje;
    private javax.swing.JTextField nombreAdmin;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel password;
    private javax.swing.JLabel titulo2;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
