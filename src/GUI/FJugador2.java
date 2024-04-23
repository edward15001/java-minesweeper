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
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/TITULO-JUGADOR.png"))); // NOI18N
        jPanel1.add(titulo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 310, -1));

        nombreUsuario.setBackground(new java.awt.Color(23, 90, 41));
        nombreUsuario.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        nombreUsuario.setBorder(null);
        jPanel1.add(nombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 170, 30));

        claveUsuario.setBackground(new java.awt.Color(23, 90, 41));
        claveUsuario.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        claveUsuario.setForeground(new java.awt.Color(255, 255, 255));
        claveUsuario.setBorder(null);
        jPanel1.add(claveUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 170, 30));

        nombre.setBackground(new java.awt.Color(23, 90, 41));
        nombre.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setText("Usuario:");
        nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        nombre.setOpaque(true);
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        clave.setBackground(new java.awt.Color(23, 90, 41));
        clave.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        clave.setForeground(new java.awt.Color(255, 255, 255));
        clave.setText("Contraseña:");
        clave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        clave.setOpaque(true);
        jPanel1.add(clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

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
        jPanel1.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 180, 40));

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

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        Jugador aux = new Jugador(nombreUsuario.getText(), claveUsuario.getText());
        data.setJugadorAux(aux);  //Pasa los datos a la clase común para los jframes.
        this.dispose(); //Cierra la ventana.
    }//GEN-LAST:event_loginActionPerformed

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
