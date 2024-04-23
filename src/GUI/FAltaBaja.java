package GUI;

import java.awt.event.WindowAdapter;

/**
 *
 * @author edwar
 */
public class FAltaBaja extends javax.swing.JFrame {

    private String name, passw;
    private static FFuncAdmin adv = new FFuncAdmin();
    
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
        titulo6 = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        clave = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JTextField();
        claveUsuario = new javax.swing.JTextField();
        alta = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/TITULO-ALTA_BAJA.png"))); // NOI18N
        jPanel1.add(titulo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

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
        jPanel1.add(alta, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 180, 40));

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

    private void altaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaActionPerformed
        name = nombreUsuario.getText();  //Guarda el nombre del usuario.
        passw = claveUsuario.getText();  //Guarda la contraseña.
        this.dispose();  //Cierra la ventana.
    }//GEN-LAST:event_altaActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        adv.setVisible(true);
        adv.setLocationRelativeTo(null);
        adv.setDefaultCloseOperation(EXIT_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_volverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alta;
    private javax.swing.JLabel clave;
    private javax.swing.JTextField claveUsuario;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nombre;
    private javax.swing.JTextField nombreUsuario;
    private javax.swing.JLabel titulo6;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
