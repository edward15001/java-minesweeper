package GUI;

import buscaminasjunio.Casilla;
import buscaminasjunio.Clase_Entre_Ventanas;
import buscaminasjunio.Partida;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * @author edwar
 */
public class FTablero extends javax.swing.JFrame {

    private JButton[][] botonCasilla;  //Definimos una matriz de botones para rellenar nuestro tablero.
    private ArrayList<Casilla> seleccionadas = new ArrayList<Casilla>();  //Almacena las casillas que se van seleccionando.
    private static Clase_Entre_Ventanas data = new Clase_Entre_Ventanas();
    private static FFuncUser user = new FFuncUser();

    public FTablero() {
        crearBotones();
        initComponents();
        data.crearPartida();
        nombreP1.setText(data.getPartida().getJugador_actual().getUsuario() + ":");
        nombreP2.setText(data.getPartida().getJugador_esperando().getUsuario() + ":");
        turno.setText(data.getPartida().getJugador_actual().getUsuario());
        puntoP1.setText(String.valueOf(data.getPartida().getResult().getMinasJ1()));
        puntoP2.setText(String.valueOf(data.getPartida().getResult().getMinasJ2()));

    }

    private void crearBotones() {  //Coloca todos los botones en el tablero.

        botonCasilla = new JButton[16][16];

        for (int fila = 0; fila < 16; fila++) {  //Recorre las filas.
            for (int columna = 0; columna < 16; columna++) {  //Recorre las columnas.
                botonCasilla[fila][columna] = new JButton();  //Asigna un botón a cada una de las posiciones de la matriz de botones.
                botonCasilla[fila][columna].setName(fila + "," + columna);  //Le otorga un nombre a cada botón según su coordenada.
                Border border = BorderFactory.createLineBorder(Color.black);
                botonCasilla[fila][columna].setBorder(border);
                if (fila == 0 && columna == 0) {   //Coloca el primer botón, a partir del cual se distribuirán los demás.
                    botonCasilla[fila][columna].setBounds(110, 280, 30, 30);
                } else if (fila == 0 && columna != 0) {  //Coloca la primera fila de botones a partir del anterior.
                    botonCasilla[fila][columna].setBounds(botonCasilla[fila][columna - 1].getX() + botonCasilla[fila][columna - 1].getWidth(), 280, 30, 30);
                } else {  //El resto de botones. Crea el resto de filas a partir de la anterior.
                    botonCasilla[fila][columna].setBounds(botonCasilla[fila - 1][columna].getX(), botonCasilla[fila - 1][columna].getY() + botonCasilla[fila - 1][columna].getHeight(), 30, 30);
                }
                ActionListener accion = new ActionListener() {  //Crea un elemento de tipo acción para definir qué hacer al pulsar.
                    @Override
                    public void actionPerformed(ActionEvent evento) {  //Define la acción que debe realizar un botón.
                        alClickear(evento);
                    }
                };
                botonCasilla[fila][columna].addActionListener(accion);

                getContentPane().add(botonCasilla[fila][columna]);   //Añade los botones al contentPane.
            }
        }
    }

    private void alClickear(ActionEvent e) {  //Qué hacer al pulsar el botón.
        JButton boton = (JButton) e.getSource();
        String[] coordenada = boton.getName().split(",");
        //Separa el nombre del botón, que contiene sus coordenadas en un array de dos elementos.
        int coordX = Integer.parseInt(coordenada[0]);
        int coordY = Integer.parseInt(coordenada[1]);  //Guardar las coordenadas como enteros.
        Partida partida = data.getPartida();

        partida.setMovimientos(coordX, coordY);
        Casilla aux = partida.getTab().getCasilla(coordX, coordY);
        boton.setText(aux.getContenido());
        //Coloca en el botón el símbolo tras ser revelado.

        if (aux.getContenido().equals("0") && this.seleccionadas.contains(aux) == false) {  //Si el contenido de la casilla es 0 y no ha sido seleccionada.
            //Se revelan las casillas adyacentes.
            this.seleccionadas.add(aux);
            boton.setEnabled(false);
            boton.setForeground(partida.getColorCasilla());
            boton.setOpaque(true);
            boton.setContentAreaFilled(false);
            revelarAdyacentes(aux);
        } else {
            this.seleccionadas.add(aux);
            boton.setEnabled(false);
            boton.setForeground(Color.red);
            boton.setOpaque(true);
            boton.setContentAreaFilled(false);
        }
        partida.jugar();
        actualizarMarcador();
        turno.setText(partida.getJugador_actual().getUsuario());

        if (partida.gameOver()) {  //Abre la ventana de fin de juego y muestra quién es el ganador y el marcador.
            partida.setGanador(partida.getJugador_actual());
            data.rellenarResultadoPartida();/*
            datos.getJ2().añadirPartida(partida);
            datos.getJ2().actualizarEstadisticas(partida, partida.getMarcador().getMinasJ2(), partida.getMarcador().getMinasJ1());*/
            data.organizarPartidas();  //Coloca las partidas de la lista a los jugadores adecuados.
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    JButton pulsador = this.botonCasilla[i][j];
                    if (seleccionadas.contains(partida.getTab().getCasilla(i, j)) == false) {
                        pulsador.setText(partida.getTab().getCasilla(i, j).getContenido());
                        pulsador.setEnabled(false);
                    }
                }
            }
            texto.setText("El ganador es: ");
        }
    }

    private void actualizarMarcador() {  //Cambia el valor de los marcadores si procede.
        puntoP1.setText(String.valueOf(data.getPartida().getResult().getMinasJ1()));
        puntoP2.setText(String.valueOf(data.getPartida().getResult().getMinasJ2()));
    }

    private void revelarAdyacentes(Casilla aux) {
        ArrayList<Casilla> adyacentes;
        adyacentes = data.getPartida().getTab().casillasAdyacentes(aux);
        for (Casilla c : adyacentes) {
            if (seleccionadas.contains(c) == false) {
                this.seleccionadas.add(c);
                JButton boton = botonCasilla[c.getX()][c.getY()];
                boton.setText(c.getContenido());
                boton.setEnabled(false);
                boton.setForeground(data.getPartida().getColorCasilla());
                boton.setOpaque(true);
                boton.setContentAreaFilled(false);
                if (c.getContenido().equals("0")) {  //Si el contenido vuelve a ser 0.
                    revelarAdyacentes(c);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Player1 = new javax.swing.JLabel();
        Player2 = new javax.swing.JLabel();
        nombreP1 = new javax.swing.JLabel();
        nombreP2 = new javax.swing.JLabel();
        puntoP1 = new javax.swing.JLabel();
        puntoP2 = new javax.swing.JLabel();
        turno = new javax.swing.JLabel();
        texto = new javax.swing.JLabel();
        volver = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(700, 800));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Player1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/iconsRed/icons8-usuario-96.png"))); // NOI18N
        jPanel1.add(Player1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Player2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/iconsGreen/icons8-usuario-96.png"))); // NOI18N
        jPanel1.add(Player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        nombreP1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        nombreP1.setForeground(new java.awt.Color(0, 0, 0));
        nombreP1.setText(":");
        jPanel1.add(nombreP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        nombreP2.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        nombreP2.setForeground(new java.awt.Color(0, 0, 0));
        nombreP2.setText(":");
        jPanel1.add(nombreP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, -1, -1));

        puntoP1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        puntoP1.setForeground(new java.awt.Color(0, 0, 0));
        puntoP1.setText(".");
        jPanel1.add(puntoP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        puntoP2.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        puntoP2.setForeground(new java.awt.Color(0, 0, 0));
        puntoP2.setText(".");
        jPanel1.add(puntoP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 10, 20));

        turno.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        turno.setForeground(new java.awt.Color(0, 0, 0));
        turno.setText(":");
        jPanel1.add(turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        texto.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        texto.setForeground(new java.awt.Color(0, 0, 0));
        texto.setText("TURNO DE");
        jPanel1.add(texto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        volver.setBackground(new java.awt.Color(111, 204, 102));
        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons.return/icons8-volver-48.png"))); // NOI18N
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 70, 70));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/fondoBatalla.jpg"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        user.setVisible(true);
        user.setLocationRelativeTo(null);
        user.setDefaultCloseOperation(EXIT_ON_CLOSE);
        dispose();    }//GEN-LAST:event_volverActionPerformed

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
            java.util.logging.Logger.getLogger(FTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FTablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Player1;
    private javax.swing.JLabel Player2;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nombreP1;
    private javax.swing.JLabel nombreP2;
    private javax.swing.JLabel puntoP1;
    private javax.swing.JLabel puntoP2;
    private javax.swing.JLabel texto;
    private javax.swing.JLabel turno;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
