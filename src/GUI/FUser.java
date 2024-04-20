package GUI;

import buscaminasjunio.Clase_Entre_Ventanas;
import buscaminasjunio.Jugador;
import buscaminasjunio.Usuario;

/**
 *
 * @author edwar
 */
public class FUser extends javax.swing.JFrame {

    private static Clase_Entre_Ventanas data = new Clase_Entre_Ventanas();
    private static FMenuInicial menu = new FMenuInicial();

    public FUser() {
        initComponents();
        this.setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        nombreUsuario = new javax.swing.JTextField();
        claveUsuario = new javax.swing.JTextField();
        user = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        titulo3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mensaje = new javax.swing.JTextArea();
        volver = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreUsuario.setBackground(new java.awt.Color(23, 90, 41));
        nombreUsuario.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        nombreUsuario.setBorder(null);
        panelPrincipal.add(nombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 170, 30));

        claveUsuario.setBackground(new java.awt.Color(23, 90, 41));
        claveUsuario.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        claveUsuario.setForeground(new java.awt.Color(255, 255, 255));
        claveUsuario.setBorder(null);
        panelPrincipal.add(claveUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 170, 30));

        user.setBackground(new java.awt.Color(23, 90, 41));
        user.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setText("Contraseña:");
        user.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        user.setOpaque(true);
        panelPrincipal.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        nombre.setBackground(new java.awt.Color(23, 90, 41));
        nombre.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setText("Usuario:");
        nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        nombre.setOpaque(true);
        panelPrincipal.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        login.setBackground(new java.awt.Color(111, 204, 102));
        login.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        login.setForeground(new java.awt.Color(51, 51, 51));
        login.setText("LOGIN");
        login.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login.setMaximumSize(new java.awt.Dimension(63, 33));
        login.setMinimumSize(new java.awt.Dimension(63, 33));
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        panelPrincipal.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 180, 40));

        titulo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/TITULO-USUARIO.png"))); // NOI18N
        panelPrincipal.add(titulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 290, -1));

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        mensaje.setBackground(new java.awt.Color(111, 204, 102));
        mensaje.setColumns(20);
        mensaje.setForeground(new java.awt.Color(111, 204, 102));
        mensaje.setRows(5);
        jScrollPane1.setViewportView(mensaje);

        panelPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 320, 160));

        volver.setBackground(new java.awt.Color(111, 204, 102));
        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons.return/icons8-volver-48.png"))); // NOI18N
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        panelPrincipal.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 70, 70));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/fondoBatallaMod.jpg"))); // NOI18N
        panelPrincipal.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        Usuario jugador = new Jugador(nombreUsuario.getText(), claveUsuario.getText());
        if (data.getUsers().autenticar(jugador)) {  //Si el usuario esta registrado.
            for (Usuario u : data.getUsers().getUsuariosTotal()) {
                Jugador j = (Jugador) u;
                if (j.equals(jugador)) {  //Si el jugador introducido es encontrado en la lista.
                    data.setJ1(j);  //Prepara al jugador actual para ser el primero en caso de querer jugar.
                }
            }
            FFuncUser ventanaJugador = new FFuncUser();
            ventanaJugador.setVisible(true);
            ventanaJugador.setLocationRelativeTo(null);
            ventanaJugador.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.dispose();
        } else {
            mensaje.setText("Datos erroneos");
        }    }//GEN-LAST:event_loginActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void nombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void claveUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {

    }

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
            java.util.logging.Logger.getLogger(FUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField claveUsuario;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton login;
    private javax.swing.JTextArea mensaje;
    private javax.swing.JLabel nombre;
    private javax.swing.JTextField nombreUsuario;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel titulo3;
    private javax.swing.JLabel user;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
