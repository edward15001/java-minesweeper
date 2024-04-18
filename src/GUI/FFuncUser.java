package GUI;

import buscaminasjunio.Clase_Entre_Ventanas;
import buscaminasjunio.Jugador;
import buscaminasjunio.Usuario;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author edwar
 */
public class FFuncUser extends javax.swing.JFrame {
    
    private Clase_Entre_Ventanas datos = new Clase_Entre_Ventanas();
    
    public FFuncUser() {
        initComponents();
    }
    
    private void empezarPartida() {  //Comprueba si el usuario introducido es correcto y abre el tablero.
        if (datos.getUsers().autenticar(datos.getJugadorAux()) && datos.getJugadorAux().equals(datos.getJ1()) == false) {
            //Si el segundo jugador es correcto y no es el mismo que el actual.
            for (Usuario u : datos.getUsers().getUsuariosTotal()) {  //Busca el jugador pasado en la lista.
                Jugador j2 = (Jugador) u;
                if (j2.equals(datos.getJugadorAux())) {  //Si se encuentra al jugador en la lista.
                    datos.setJ2(j2);
                }
            }
            FTablero nuevaPartida = new FTablero();
            nuevaPartida.setVisible(true);
            nuevaPartida.setLocationRelativeTo(null);
            nuevaPartida.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            nuevaPartida.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    datos.organizarPartidas();
                }
            });
        } else {
            mensaje.setText("Datos erroneos");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        perfil = new javax.swing.JButton();
        ranking = new javax.swing.JButton();
        newGame = new javax.swing.JButton();
        titulo4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mensaje = new javax.swing.JTextArea();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        perfil.setBackground(new java.awt.Color(111, 204, 102));
        perfil.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        perfil.setForeground(new java.awt.Color(0, 0, 0));
        perfil.setText("PERFIL");
        perfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        perfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilActionPerformed(evt);
            }
        });
        panelPrincipal.add(perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 180, 40));

        ranking.setBackground(new java.awt.Color(111, 204, 102));
        ranking.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        ranking.setForeground(new java.awt.Color(0, 0, 0));
        ranking.setText("RANKING");
        ranking.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ranking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ranking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rankingActionPerformed(evt);
            }
        });
        panelPrincipal.add(ranking, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 180, 40));

        newGame.setBackground(new java.awt.Color(111, 204, 102));
        newGame.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        newGame.setForeground(new java.awt.Color(0, 0, 0));
        newGame.setText("NUEVA PARTIDA");
        newGame.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        newGame.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });
        panelPrincipal.add(newGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, 180, 40));

        titulo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/TITULO-JUGADOR.png"))); // NOI18N
        panelPrincipal.add(titulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        mensaje.setBackground(new java.awt.Color(111, 204, 102));
        mensaje.setColumns(20);
        mensaje.setForeground(new java.awt.Color(111, 204, 102));
        mensaje.setRows(5);
        jScrollPane1.setViewportView(mensaje);

        panelPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/fondoJugador2.jpg"))); // NOI18N
        panelPrincipal.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
        FJugador2 ventanaOtroJugador = new FJugador2();
        ventanaOtroJugador.setVisible(true);
        ventanaOtroJugador.setLocationRelativeTo(null);
        ventanaOtroJugador.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ventanaOtroJugador.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                empezarPartida();
            }
        });
        this.dispose();    }//GEN-LAST:event_newGameActionPerformed

    private void rankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rankingActionPerformed
        FRanking clasificacion = new FRanking();
        clasificacion.setVisible(true);
        clasificacion.setLocationRelativeTo(null);
        clasificacion.setDefaultCloseOperation(DISPOSE_ON_CLOSE);    }//GEN-LAST:event_rankingActionPerformed

    private void perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilActionPerformed
        FCaraACara ventanaPerfil = new FCaraACara();
        ventanaPerfil.setVisible(true);
        ventanaPerfil.setLocationRelativeTo(null);
        ventanaPerfil.setDefaultCloseOperation(DISPOSE_ON_CLOSE);    }//GEN-LAST:event_perfilActionPerformed

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
            java.util.logging.Logger.getLogger(FFuncUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FFuncUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FFuncUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FFuncUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FFuncUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea mensaje;
    private javax.swing.JButton newGame;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JButton perfil;
    private javax.swing.JButton ranking;
    private javax.swing.JLabel titulo4;
    // End of variables declaration//GEN-END:variables
}
