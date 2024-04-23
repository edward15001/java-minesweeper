package GUI;

import buscaminasjunio.Clase_Entre_Ventanas;
import javax.swing.JOptionPane;

/**
 *
 * @author edwar
 */
public class FAdmin extends javax.swing.JFrame{

    String user = new String();
    String passw = new String();
    Clase_Entre_Ventanas data = new Clase_Entre_Ventanas();
    private static FFuncAdmin ventanaAvanzada = new FFuncAdmin();
    private static FMenuInicial menu = new FMenuInicial();


    private void comprobar() {  //Comprueba que los datos introducidos corresponden con los del administrador.
        if (user.equals(data.getAdmin().getNombre()) && passw.equals(data.getAdmin().getContrasenia())) {
            //Si las credenciales introducidas son correctas.
            
            ventanaAvanzada.setVisible(true);
            ventanaAvanzada.setLocationRelativeTo(null);
            ventanaAvanzada.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.dispose();
        } else {
            mensaje.setText("Datos erroneos");
        }
    }

    public FAdmin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        claveAdmin = new javax.swing.JTextField();
        nombreAdmin = new javax.swing.JTextField();
        admin = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        titulo2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mensaje = new javax.swing.JTextArea();
        volver = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelPrincipal.setMinimumSize(new java.awt.Dimension(0, 0));
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        claveAdmin.setBackground(new java.awt.Color(23, 90, 41));
        claveAdmin.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        claveAdmin.setForeground(new java.awt.Color(255, 255, 255));
        claveAdmin.setBorder(null);
        panelPrincipal.add(claveAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 170, 30));

        nombreAdmin.setBackground(new java.awt.Color(23, 90, 41));
        nombreAdmin.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        nombreAdmin.setForeground(new java.awt.Color(255, 255, 255));
        nombreAdmin.setBorder(null);
        panelPrincipal.add(nombreAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 170, 30));

        admin.setBackground(new java.awt.Color(23, 90, 41));
        admin.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        admin.setForeground(new java.awt.Color(255, 255, 255));
        admin.setText("Admin:");
        admin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        admin.setOpaque(true);
        panelPrincipal.add(admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, -1, -1));

        password.setBackground(new java.awt.Color(23, 90, 41));
        password.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setText("Contraseña:");
        password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        password.setOpaque(true);
        panelPrincipal.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        login.setBackground(new java.awt.Color(111, 204, 102));
        login.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        login.setForeground(new java.awt.Color(0, 0, 0));
        login.setText("LOGIN");
        login.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        login.setMaximumSize(new java.awt.Dimension(63, 33));
        login.setMinimumSize(new java.awt.Dimension(63, 33));
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        panelPrincipal.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 180, 40));

        titulo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/TITULO-ADMINISTRADOR.png"))); // NOI18N
        panelPrincipal.add(titulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        mensaje.setBackground(new java.awt.Color(111, 204, 102));
        mensaje.setColumns(20);
        mensaje.setForeground(new java.awt.Color(111, 204, 102));
        mensaje.setRows(8);
        mensaje.setTabSize(10);
        mensaje.setPreferredSize(new java.awt.Dimension(250, 140));
        jScrollPane1.setViewportView(mensaje);

        panelPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 320, 160));

        volver.setBackground(new java.awt.Color(111, 204, 102));
        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons.return/icons8-volver-48.png"))); // NOI18N
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        panelPrincipal.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 70, 70));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/fondoBatallaMod.jpg"))); // NOI18N
        fondo.setMaximumSize(new java.awt.Dimension(100000, 100000));
        fondo.setMinimumSize(new java.awt.Dimension(0, 0));
        panelPrincipal.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        user = nombreAdmin.getText();
        passw = claveAdmin.getText();
        comprobar();
        
    }//GEN-LAST:event_loginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin;
    private javax.swing.JTextField claveAdmin;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton login;
    private javax.swing.JTextArea mensaje;
    private javax.swing.JTextField nombreAdmin;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel password;
    private javax.swing.JLabel titulo2;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
