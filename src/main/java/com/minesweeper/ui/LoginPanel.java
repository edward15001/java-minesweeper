package com.minesweeper.ui;

import com.minesweeper.dao.UserDAO;
import com.minesweeper.model.User;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private UserDAO userDAO;

    public LoginPanel(MainFrame mainFrame) {
        this.userDAO = new UserDAO();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Buscaminas Competitivo");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JTextField usernameField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Iniciar Sesión");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        add(new JLabel("Usuario:"), gbc);
        gbc.gridx = 1;
        add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Contraseña:"), gbc);
        gbc.gridx = 1;
        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(loginButton, gbc);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            User user = userDAO.authenticate(username, password);
            if (user != null) {
                usernameField.setText("");
                passwordField.setText("");
                mainFrame.setCurrentUser(user);
                if ("ADMIN".equals(user.getRole())) {
                    mainFrame.setupAdminPanel();
                } else {
                    mainFrame.setupUserPanel();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas", "Error Login",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        Theme.applyTheme(this);
    }
}
