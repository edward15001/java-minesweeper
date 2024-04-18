package GUI;

import buscaminasjunio.Clase_Entre_Ventanas;

/**
 *
 * @author edwar
 */
public class FMenuInicial extends javax.swing.JFrame {
    
    private static Clase_Entre_Ventanas data = new Clase_Entre_Ventanas();
    private FAdmin admin = new FAdmin();
    private FUser login = new FUser();
    

    public FMenuInicial() {
        initComponents();
        data.getUsers().cargarListado(data.getFicheroUsuarios());       // Carga de ususarios
        data.getAlmacenPartidas().cargarFichero(data.getFicheroPartidas()); // Carga de partidas
        data.organizarPartidas();
    }
    
    public void cierre(){
        data.getUsers().guardarListado(data.getFicheroUsuarios());
        data.getAlmacenPartidas().guardarFichero(data.getFicheroPartidas()); // Guarda lista de partidas
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        user = new javax.swing.JButton();
        boss = new javax.swing.JButton();
        titulo1 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(700, 800));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user.setBackground(new java.awt.Color(111, 204, 102));
        user.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        user.setForeground(new java.awt.Color(0, 0, 0));
        user.setText("USUARIO");
        user.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        user.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        jPanel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, 180, 40));

        boss.setBackground(new java.awt.Color(111, 204, 102));
        boss.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        boss.setForeground(new java.awt.Color(0, 0, 0));
        boss.setText("ADMINISTRADOR");
        boss.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        boss.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bossActionPerformed(evt);
            }
        });
        jPanel1.add(boss, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 180, 40));

        titulo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/TITULO-BUSCAMINAS.png"))); // NOI18N
        jPanel1.add(titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/fondoBatalla.jpg"))); // NOI18N
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


    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(DISPOSE_ON_CLOSE);    }//GEN-LAST:event_userActionPerformed

    private void bossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bossActionPerformed
        admin.setVisible(true);
        admin.setLocationRelativeTo(null);
        admin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_bossActionPerformed

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
            java.util.logging.Logger.getLogger(FMenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FMenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FMenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FMenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FMenuInicial menu = new FMenuInicial();
                menu.setVisible(true);
                menu.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boss;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel titulo1;
    private javax.swing.JButton user;
    // End of variables declaration//GEN-END:variables
}
