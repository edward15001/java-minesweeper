package GUI;

import buscaminasjunio.Clase_Entre_Ventanas;
import buscaminasjunio.Jugador;
import buscaminasjunio.Usuario;

/**
 *
 * @author edwar
 */
public class FCaraACara extends javax.swing.JFrame {

    private static Clase_Entre_Ventanas data = new Clase_Entre_Ventanas();
    private static FFuncAdmin adv = new FFuncAdmin();

    public FCaraACara() {
        initComponents();
        mensaje.setText(data.getJ1().verPerfil());
        rellenarComboBox();
    }

    private void rellenarComboBox() {
        for (Usuario j : data.getUsers().getUsuariosTotal()) {  //Recorre los usuarios registrados.
            if (data.getJ1().equals(j) == false) {  //Se guardan los usuarios que no son el actual.
                desplegable.addItem(j);  //Añade el jugador al botón.
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tutulo = new javax.swing.JLabel();
        desplegable = new javax.swing.JComboBox<Usuario>();
        select = new javax.swing.JLabel();
        comprobar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mensaje = new javax.swing.JTextArea();
        volver = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tutulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/TITULO-CARA-A-CARA.png"))); // NOI18N
        jPanel1.add(tutulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 460, -1));

        desplegable.setBackground(new java.awt.Color(111, 204, 102));
        desplegable.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        desplegable.setForeground(new java.awt.Color(0, 0, 0));
        desplegable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.add(desplegable, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, 120, 30));

        select.setBackground(new java.awt.Color(23, 90, 41));
        select.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        select.setForeground(new java.awt.Color(255, 255, 255));
        select.setText("Selecciona oponente:");
        select.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        select.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        select.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        select.setIconTextGap(5);
        select.setOpaque(true);
        jPanel1.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 230, 30));

        comprobar.setBackground(new java.awt.Color(111, 204, 102));
        comprobar.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        comprobar.setForeground(new java.awt.Color(0, 0, 0));
        comprobar.setText("COMPROBAR");
        comprobar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        comprobar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprobarActionPerformed(evt);
            }
        });
        jPanel1.add(comprobar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 500, 180, 40));

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        mensaje.setBackground(new java.awt.Color(111, 204, 102));
        mensaje.setColumns(20);
        mensaje.setForeground(new java.awt.Color(111, 204, 102));
        mensaje.setRows(5);
        jScrollPane1.setViewportView(mensaje);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 360, 320));

        volver.setBackground(new java.awt.Color(111, 204, 102));
        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons.return/icons8-volver-48.png"))); // NOI18N
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 70, 70));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/fondoJugadorMod.jpg"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprobarActionPerformed
        Jugador jugadorOtro = (Jugador) desplegable.getSelectedItem();  //Recibe el nombre del jugador seleccionado.;
        data.getJ1().crearComparativa(jugadorOtro);  //Crea la comparativa entre los dos jugadores. 
        if (jugadorOtro.getPartidasJugadas().isEmpty()) {  //Si la lista de partidas del otro jugador est vacía.
            mensaje.setText("Este usuario aun no ha jugado.\n");
        } else {
            mensaje.setText(data.getJ1().getFaceit().playerComparison());
        }
    }//GEN-LAST:event_comprobarActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        adv.setVisible(true);
        adv.setLocationRelativeTo(null);
        adv.setDefaultCloseOperation(EXIT_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_volverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton comprobar;
    private javax.swing.JComboBox<Usuario> desplegable;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea mensaje;
    private javax.swing.JLabel select;
    private javax.swing.JLabel tutulo;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
