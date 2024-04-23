package GUI;

import buscaminasjunio.Clase_Entre_Ventanas;
import buscaminasjunio.Jugador;
import buscaminasjunio.Usuario;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author edwar
 */
public class FFuncUser extends javax.swing.JFrame {
    
    private Clase_Entre_Ventanas datos = new Clase_Entre_Ventanas();
    private static FMenuInicial menu = new FMenuInicial();
    private static FJugador2 vJ2 = new FJugador2();
    private static FStats ventanaPerfil = new FStats();
    private static FRanking clasificacion = new FRanking();
    
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
        volver = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 600));
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
        panelPrincipal.add(perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 180, 40));

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
        panelPrincipal.add(ranking, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 180, 40));

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
        panelPrincipal.add(newGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 180, 40));

        titulo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/TITULO-JUGADOR.png"))); // NOI18N
        panelPrincipal.add(titulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 310, -1));

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
        panelPrincipal.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 70, 70));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/fondoJugadorMod.jpg"))); // NOI18N
        panelPrincipal.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
        vJ2.setVisible(true);
        vJ2.setLocationRelativeTo(null);
        vJ2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        vJ2.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                empezarPartida();
            }
        });
        this.dispose();    }//GEN-LAST:event_newGameActionPerformed

    private void rankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rankingActionPerformed
        clasificacion.setVisible(true);
        clasificacion.setLocationRelativeTo(null);
        clasificacion.setDefaultCloseOperation(DISPOSE_ON_CLOSE);    }//GEN-LAST:event_rankingActionPerformed

    private void perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilActionPerformed
        ventanaPerfil.setVisible(true);
        ventanaPerfil.setLocationRelativeTo(null);
        ventanaPerfil.setDefaultCloseOperation(DISPOSE_ON_CLOSE);    }//GEN-LAST:event_perfilActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_volverActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea mensaje;
    private javax.swing.JButton newGame;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JButton perfil;
    private javax.swing.JButton ranking;
    private javax.swing.JLabel titulo4;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
