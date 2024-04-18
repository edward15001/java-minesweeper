package GUI;

import buscaminasjunio.Clase_Entre_Ventanas;
import buscaminasjunio.Jugador;

/**
 *
 * @author edwar
 */
public class FJugador2 extends javax.swing.JFrame {

    private static Clase_Entre_Ventanas data = new Clase_Entre_Ventanas();

    public FJugador2() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titulo6 = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JTextField();
        claveUsuario = new javax.swing.JTextField();
        nombre = new javax.swing.JLabel();
        clave = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/TITULO-JUGADOR.png"))); // NOI18N
        jPanel1.add(titulo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        nombreUsuario.setBackground(new java.awt.Color(23, 90, 41));
        nombreUsuario.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        nombreUsuario.setBorder(null);
        jPanel1.add(nombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 170, 30));

        claveUsuario.setBackground(new java.awt.Color(23, 90, 41));
        claveUsuario.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        claveUsuario.setForeground(new java.awt.Color(255, 255, 255));
        claveUsuario.setBorder(null);
        jPanel1.add(claveUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 170, 30));

        nombre.setBackground(new java.awt.Color(51, 246, 64));
        nombre.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setText("Usuario:");
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, -1, -1));

        clave.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        clave.setForeground(new java.awt.Color(255, 255, 255));
        clave.setText("Contraseña:");
        jPanel1.add(clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, -1, -1));

        login.setBackground(new java.awt.Color(111, 204, 102));
        login.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        login.setForeground(new java.awt.Color(0, 0, 0));
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
        jPanel1.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, 180, 40));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/fondoJugador2.jpg"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        Jugador aux = new Jugador(nombreUsuario.getText(), claveUsuario.getText());
        data.setJugadorAux(aux);  //Pasa los datos a la clase común para los jframes.
        this.dispose(); //Cierra la ventana.
    }//GEN-LAST:event_loginActionPerformed

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
            java.util.logging.Logger.getLogger(FJugador2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FJugador2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FJugador2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FJugador2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FJugador2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clave;
    private javax.swing.JTextField claveUsuario;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login;
    private javax.swing.JLabel nombre;
    private javax.swing.JTextField nombreUsuario;
    private javax.swing.JLabel titulo6;
    // End of variables declaration//GEN-END:variables
}
