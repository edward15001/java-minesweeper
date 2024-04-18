package GUI;

import java.awt.event.WindowAdapter;

/**
 *
 * @author edwar
 */
public class FAltaBaja extends javax.swing.JFrame {

    private String name, passw;
    
    public FAltaBaja() {
        initComponents();
    }

    public String getName() {
        return name;
    }

    public String getPassw() {
        return passw;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        alta = new javax.swing.JButton();
        nombre = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JTextField();
        claveUsuario = new javax.swing.JTextField();
        clave = new javax.swing.JLabel();
        titulo6 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        alta.setBackground(new java.awt.Color(111, 204, 102));
        alta.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        alta.setForeground(new java.awt.Color(0, 0, 0));
        alta.setText("ALTA");
        alta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        alta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaActionPerformed(evt);
            }
        });
        jPanel1.add(alta, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, 180, 40));

        nombre.setBackground(new java.awt.Color(51, 246, 64));
        nombre.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setText("Usuario:");
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, -1, -1));

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

        clave.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        clave.setForeground(new java.awt.Color(255, 255, 255));
        clave.setText("Contraseña:");
        jPanel1.add(clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, -1, -1));

        titulo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/TITULO-ALTA_BAJA.png"))); // NOI18N
        jPanel1.add(titulo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

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

    private void altaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaActionPerformed
        name = nombreUsuario.getText();  //Guarda el nombre del usuario.
        passw = claveUsuario.getText();  //Guarda la contraseña.
        this.dispose();  //Cierra la ventana.
    }//GEN-LAST:event_altaActionPerformed

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
            java.util.logging.Logger.getLogger(FAltaBaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FAltaBaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FAltaBaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FAltaBaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FAltaBaja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alta;
    private javax.swing.JLabel clave;
    private javax.swing.JTextField claveUsuario;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nombre;
    private javax.swing.JTextField nombreUsuario;
    private javax.swing.JLabel titulo6;
    // End of variables declaration//GEN-END:variables
}
