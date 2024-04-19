package GUI;

import buscaminasjunio.Clase_Entre_Ventanas;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author edwar
 */
public class FFuncAdmin extends javax.swing.JFrame {
    
    public static Clase_Entre_Ventanas data = new Clase_Entre_Ventanas();
    private static FMenuInicial menu = new FMenuInicial();
    
    public FFuncAdmin() {
        initComponents();
        mensaje.setEditable(false);
    }
    
    public void darAlta() {
        data.getUsers().alta(data.getJugadorAux());
        data.getUsers().guardarListado(data.getFicheroUsuarios());
    }
    
    public void darBaja() {
        data.getUsers().baja(data.getJugadorAux());
        data.getUsers().guardarListado(data.getFicheroUsuarios());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titulo5 = new javax.swing.JLabel();
        alta = new javax.swing.JButton();
        baja = new javax.swing.JButton();
        infoPartidas = new javax.swing.JButton();
        cargaFichero = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mensaje = new javax.swing.JTextArea();
        volver = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/TITULO-ADMINISTRADOR.png"))); // NOI18N
        jPanel1.add(titulo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

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
        jPanel1.add(alta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 180, 40));

        baja.setBackground(new java.awt.Color(111, 204, 102));
        baja.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        baja.setForeground(new java.awt.Color(0, 0, 0));
        baja.setText("BAJA");
        baja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        baja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaActionPerformed(evt);
            }
        });
        jPanel1.add(baja, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 180, 40));

        infoPartidas.setBackground(new java.awt.Color(111, 204, 102));
        infoPartidas.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        infoPartidas.setForeground(new java.awt.Color(0, 0, 0));
        infoPartidas.setText("PARTIDAS");
        infoPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        infoPartidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        infoPartidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoPartidasActionPerformed(evt);
            }
        });
        jPanel1.add(infoPartidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 180, 40));

        cargaFichero.setBackground(new java.awt.Color(111, 204, 102));
        cargaFichero.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        cargaFichero.setForeground(new java.awt.Color(0, 0, 0));
        cargaFichero.setText("CARGA FICHERO");
        cargaFichero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        cargaFichero.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cargaFichero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargaFicheroActionPerformed(evt);
            }
        });
        jPanel1.add(cargaFichero, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 180, 40));

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        mensaje.setBackground(new java.awt.Color(111, 204, 102));
        mensaje.setColumns(20);
        mensaje.setForeground(new java.awt.Color(111, 204, 102));
        mensaje.setRows(5);
        jScrollPane1.setViewportView(mensaje);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, -1, -1));

        volver.setBackground(new java.awt.Color(111, 204, 102));
        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons.return/icons8-volver-48.png"))); // NOI18N
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 720, 70, 70));

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
        FJugador2 ventanaAlta = new FJugador2();
        ventanaAlta.setVisible(true);
        ventanaAlta.setLocationRelativeTo(null);
        ventanaAlta.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ventanaAlta.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                if (data.existeUsuario(data.getJugadorAux().getUsuario())) {  //Si el usuario introducido ya existe.
                    mensaje.setText("El usuario ya existe en el sistema");
                } else {
                    darAlta();
                    if (data.getUsers().getUsuariosTotal().contains(data.getJugadorAux())) {  //Si el usuario existe en la lista.
                        mensaje.setText("Usuario introducido correctamente");
                    } else {
                        mensaje.setText("Ha ocurrido un error");
                    }
                }
            }
        });
    }//GEN-LAST:event_altaActionPerformed

    private void bajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajaActionPerformed
        FJugador2 ventanaAlta = new FJugador2();
        ventanaAlta.setVisible(true);
        ventanaAlta.setLocationRelativeTo(null);
        ventanaAlta.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ventanaAlta.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                darBaja();
                if (data.getUsers().getUsuariosTotal().contains(data.getJugadorAux()) == false) {  //Si el usuario ya no existe en la lista.
                    JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Datos incorrectos, vuelva a intentarlo");
                }
            }
        });    }//GEN-LAST:event_bajaActionPerformed

    private void infoPartidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoPartidasActionPerformed
        FCaraACara info = new FCaraACara();
        info.setVisible(true);
        info.setLocationRelativeTo(null);
        info.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_infoPartidasActionPerformed

    private void cargaFicheroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargaFicheroActionPerformed
        data.getUsers().cargarListadoNuevosUsuarios(data.getFicheroNuevosUsuarios());  //Carga un listado de usuarios de un fichero.txt
        JOptionPane.showMessageDialog(null, "Jugadores cargados");
    }//GEN-LAST:event_cargaFicheroActionPerformed

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
            java.util.logging.Logger.getLogger(FFuncAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FFuncAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FFuncAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FFuncAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FFuncAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alta;
    private javax.swing.JButton baja;
    private javax.swing.JButton cargaFichero;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton infoPartidas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea mensaje;
    private javax.swing.JLabel titulo5;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
