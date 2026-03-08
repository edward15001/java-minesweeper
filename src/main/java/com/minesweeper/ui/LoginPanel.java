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
        setBackground(Theme.BG_COLOR); // Ensure root is black

        JPanel terminalBox = new JPanel(new GridBagLayout());
        terminalBox.setBackground(Theme.BG_COLOR);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 0, 8, 20); // Spacing
        gbc.anchor = GridBagConstraints.WEST;

        // --- TITLE ---
        JLabel titleLabel = new JLabel("SYS_LOGIN: BUSCAMINAS_COMPETITIVO");
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
        titleLabel.setForeground(Theme.ACCENT_COLOR);
        // Underline effect
        titleLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Theme.DIM_COLOR));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 30, 0); // extra bottom padding for title
        terminalBox.add(titleLabel, gbc);

        // Reset insets
        gbc.insets = new Insets(10, 0, 10, 10);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        // --- USER INPUT ---
        gbc.gridy = 1;
        gbc.gridx = 0;
        JLabel userLabel = new JLabel("> USER: ");
        userLabel.setFont(Theme.TITLE_FONT);
        userLabel.setForeground(Theme.DIM_COLOR);
        terminalBox.add(userLabel, gbc);

        gbc.gridx = 1;
        JTextField usernameField = new JTextField(15);
        usernameField.setBackground(Theme.BG_COLOR);
        usernameField.setForeground(Theme.ACCENT_COLOR);
        usernameField.setFont(Theme.TITLE_FONT);
        usernameField.setCaretColor(Theme.ACCENT_COLOR);
        usernameField.setBorder(null); // No border, pure terminal text flow
        terminalBox.add(usernameField, gbc);

        // --- PASS INPUT ---
        gbc.gridy = 2;
        gbc.gridx = 0;
        JLabel passLabel = new JLabel("> PASS: ");
        passLabel.setFont(Theme.TITLE_FONT);
        passLabel.setForeground(Theme.DIM_COLOR);
        terminalBox.add(passLabel, gbc);

        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setBackground(Theme.BG_COLOR);
        passwordField.setForeground(Theme.ACCENT_COLOR);
        passwordField.setFont(Theme.TITLE_FONT);
        passwordField.setCaretColor(Theme.ACCENT_COLOR);
        passwordField.setBorder(null);
        terminalBox.add(passwordField, gbc);

        // --- SUBMIT BUTTON ---
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(30, 0, 10, 0);

        JButton loginButton = new JButton("> [EXECUTE_LOGIN]");
        loginButton.setFont(Theme.TITLE_FONT);
        loginButton.setBackground(Theme.BG_COLOR);
        loginButton.setForeground(Theme.ACCENT_COLOR);
        loginButton.setBorder(null); // No border
        loginButton.setFocusPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.setContentAreaFilled(false);

        // Hover effect for text-only button
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButton.setForeground(Color.WHITE);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButton.setForeground(Theme.ACCENT_COLOR);
            }
        });

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
                // Style the error dialog a bit
                UIManager.put("OptionPane.background", Theme.BG_COLOR);
                UIManager.put("Panel.background", Theme.BG_COLOR);
                UIManager.put("OptionPane.messageForeground", Theme.ACCENT_COLOR);
                JOptionPane.showMessageDialog(this, "ERR_INVALID_CREDENTIALS", "SYS_WARN",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        terminalBox.add(loginButton, gbc);

        add(terminalBox); // Centered in the GridBagLayout
    }
}
