package com.minesweeper.ui;

import com.minesweeper.model.User;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private User currentUser;

    public MainFrame() {
        setTitle("Buscaminas Competitivo");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add base Login panel
        mainPanel.add(new LoginPanel(this), "LoginPanel");

        add(mainPanel);
        cardLayout.show(mainPanel, "LoginPanel");
    }

    public void navigateTo(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public void startGame(User player1, User player2) {
        mainPanel.add(new GamePanel(this, player1, player2), "GamePanel");
        navigateTo("GamePanel");
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setupAdminPanel() {
        mainPanel.add(new AdminPanel(this), "AdminPanel");
        navigateTo("AdminPanel");
    }

    public void setupUserPanel() {
        mainPanel.add(new UserPanel(this), "UserPanel");
        navigateTo("UserPanel");
    }
}
