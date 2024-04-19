/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import buscaminasjunio.Clase_Entre_Ventanas;
import buscaminasjunio.Marcador;
import buscaminasjunio.Partida;

/**
 *
 * @author edwar
 */
public class FStats extends javax.swing.JFrame {

    private static Clase_Entre_Ventanas data = new Clase_Entre_Ventanas();

    public FStats() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titulo8 = new javax.swing.JLabel();
        select = new javax.swing.JLabel();
        desplegable = new javax.swing.JComboBox<Partida>();
        jugadores = new javax.swing.JButton();
        marcador = new javax.swing.JButton();
        tabMov = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mensaje = new javax.swing.JTextArea();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/TITULO-ESTADISTICAS.png"))); // NOI18N
        jPanel1.add(titulo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, 0, 590, 130));

        select.setBackground(new java.awt.Color(23, 90, 41));
        select.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        select.setForeground(new java.awt.Color(255, 255, 255));
        select.setText("Selecciona partida:");
        select.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        select.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        select.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        select.setIconTextGap(5);
        select.setOpaque(true);
        jPanel1.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 250, 30));

        desplegable.setBackground(new java.awt.Color(111, 204, 102));
        desplegable.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        desplegable.setForeground(new java.awt.Color(0, 0, 0));
        desplegable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.add(desplegable, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 120, 30));

        jugadores.setBackground(new java.awt.Color(111, 204, 102));
        jugadores.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jugadores.setForeground(new java.awt.Color(0, 0, 0));
        jugadores.setText("JUGADORES");
        jugadores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jugadores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugadoresActionPerformed(evt);
            }
        });
        jPanel1.add(jugadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 180, 40));

        marcador.setBackground(new java.awt.Color(111, 204, 102));
        marcador.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        marcador.setForeground(new java.awt.Color(0, 0, 0));
        marcador.setText("MARCADOR");
        marcador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        marcador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        marcador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcadorActionPerformed(evt);
            }
        });
        jPanel1.add(marcador, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 180, 40));

        tabMov.setBackground(new java.awt.Color(111, 204, 102));
        tabMov.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        tabMov.setForeground(new java.awt.Color(0, 0, 0));
        tabMov.setText("TABLERO Y MOVIMIENTOS");
        tabMov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        tabMov.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabMovActionPerformed(evt);
            }
        });
        jPanel1.add(tabMov, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 250, 40));

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        mensaje.setBackground(new java.awt.Color(111, 204, 102));
        mensaje.setColumns(20);
        mensaje.setForeground(new java.awt.Color(111, 204, 102));
        mensaje.setRows(5);
        jScrollPane1.setViewportView(mensaje);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 250, 110));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/fondoJugador.jpg"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void jugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugadoresActionPerformed
        Partida p = (Partida) desplegable.getSelectedItem();
        mensaje.setText(p.getJugador_actual().verPerfil() + "\n" + p.getJugador_esperando().verPerfil() + "\n");
        //Escribe los nombres y estadisticas de los jugadores.
    }//GEN-LAST:event_jugadoresActionPerformed

    private void marcadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcadorActionPerformed
        Partida p = (Partida) desplegable.getSelectedItem();
        Marcador marcador = p.getResult();
        mensaje.setText("El marcador quedo:\n" + marcador.getMinasJ1() + " minas para " + p.getJugador_actual().getUsuario() + "\n" + "y " + marcador.getMinasJ2() + " minas para " + p.getJugador_esperando().getUsuario() + "\n");
    }//GEN-LAST:event_marcadorActionPerformed

    private void tabMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabMovActionPerformed
        Partida p = (Partida) desplegable.getSelectedItem();
        mensaje.setText(p.imprimirTablero() + "\n" + p.printMovimientos() + "\n" + "Tambien te lo he dejado en un fichero dentro de la carpeta del proyecto.\n");  //Imprime el tablero en le ventana.
        p.getAlmacen().tablero_y_movimientos(p, data.getFicheroTableroMovimientos());    }//GEN-LAST:event_tabMovActionPerformed

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
            java.util.logging.Logger.getLogger(FStats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FStats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FStats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FStats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FStats().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Partida> desplegable;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jugadores;
    private javax.swing.JButton marcador;
    private javax.swing.JTextArea mensaje;
    private javax.swing.JLabel select;
    private javax.swing.JButton tabMov;
    private javax.swing.JLabel titulo8;
    // End of variables declaration//GEN-END:variables
}
