package com.minesweeper.ui;

import com.minesweeper.dao.UserDAO;
import com.minesweeper.model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class UserPanel extends JPanel {
    private MainFrame mainFrame;
    private UserDAO userDAO;

    public UserPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.userDAO = new UserDAO();
        setLayout(new BorderLayout());

        // Header
        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Panel de Usuario: " + mainFrame.getCurrentUser().getUsername(),
                SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton logoutBtn = new JButton("Cerrar Sesión");
        logoutBtn.addActionListener(e -> {
            this.mainFrame.setCurrentUser(null);
            this.mainFrame.navigateTo("LoginPanel");
        });
        JPanel logoutPanel = new JPanel();
        logoutPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        logoutPanel.add(logoutBtn);

        headerPanel.add(title, BorderLayout.CENTER);
        headerPanel.add(logoutPanel, BorderLayout.EAST);
        add(headerPanel, BorderLayout.NORTH);

        // Tabs
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Jugar Partida", createPlayPanel());
        tabbedPane.add("Mis Estadísticas", createStatsPanel());
        tabbedPane.add("Ranking Global", createRankingPanel());

        add(tabbedPane, BorderLayout.CENTER);
        Theme.applyTheme(this);
    }

    private JPanel createPlayPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel instruction = new JLabel("Selecciona a tu contrincante (Invitado):");
        instruction.setFont(new Font("Arial", Font.PLAIN, 16));

        JComboBox<User> opponentCombo = new JComboBox<>();
        List<User> allUsers = userDAO.getAllUsers();
        for (User u : allUsers) {
            if ("USER".equals(u.getRole()) && u.getId() != mainFrame.getCurrentUser().getId()) {
                opponentCombo.addItem(u);
            }
        }

        JButton startBtn = new JButton("Iniciar Partida");
        startBtn.setFont(new Font("Arial", Font.BOLD, 16));
        startBtn.addActionListener(e -> {
            User opponent = (User) opponentCombo.getSelectedItem();
            if (opponent != null) {
                mainFrame.startGame(mainFrame.getCurrentUser(), opponent);
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un contrincante válido.", "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(instruction, gbc);
        gbc.gridy = 1;
        panel.add(opponentCombo, gbc);
        gbc.gridy = 2;
        panel.add(startBtn, gbc);

        return panel;
    }

    private JPanel createStatsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        User currentUser = mainFrame.getCurrentUser();
        // stats can be outdated if fetched from memory, so we refresh from DB
        User updatedUser = null;
        for (User u : userDAO.getAllUsers()) {
            if (u.getId() == currentUser.getId()) {
                updatedUser = u;
                break;
            }
        }
        if (updatedUser == null) {
            updatedUser = currentUser;
        }

        final int played = updatedUser.getGamesPlayed();
        final int won = updatedUser.getGamesWon();
        final int mines = updatedUser.getMinesFound();

        JPanel graphPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int w = getWidth();
                int h = getHeight();

                int maxVal = Math.max(played, Math.max(won, mines));
                if (maxVal == 0)
                    maxVal = 1; // avoid div by 0

                int barHeight = Math.max(20, h / 8);
                int gap = 30;
                int startY = 40;

                g2.setFont(Theme.BOLD_FONT);

                // Draw Played
                g2.setColor(Theme.FG_COLOR);
                g2.drawString("Partidas Jugadas: " + played, 20, startY - 5);
                g2.setColor(Theme.PANEL_BG);
                g2.fillRect(20, startY, w - 60, barHeight);
                g2.setColor(Theme.ACCENT_COLOR);
                g2.fillRect(20, startY, (int) ((double) played / maxVal * (w - 60)), barHeight);

                startY += barHeight + gap;

                // Draw Won
                g2.setColor(Theme.FG_COLOR);
                g2.drawString("Partidas Ganadas: " + won, 20, startY - 5);
                g2.setColor(Theme.PANEL_BG);
                g2.fillRect(20, startY, w - 60, barHeight);
                g2.setColor(Theme.ACCENT_COLOR);
                g2.fillRect(20, startY, (int) ((double) won / maxVal * (w - 60)), barHeight);

                startY += barHeight + gap;

                // Draw Mines
                g2.setColor(Theme.FG_COLOR);
                g2.drawString("Total Minas Encontradas: " + mines, 20, startY - 5);
                g2.setColor(Theme.PANEL_BG);
                g2.fillRect(20, startY, w - 60, barHeight);
                g2.setColor(Theme.ACCENT_COLOR);
                g2.fillRect(20, startY, (int) ((double) mines / maxVal * (w - 60)), barHeight);
            }
        };
        graphPanel.setPreferredSize(new Dimension(500, 300));
        panel.add(graphPanel, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createRankingPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        String[] columns = { "Posición", "Usuario", "Partidas Ganadas", "Minas Encontradas", "Partidas Jugadas" };
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);

        JButton refreshBtn = new JButton("Actualizar Ranking");
        refreshBtn.addActionListener(e -> {
            tableModel.setRowCount(0);
            List<User> ranking = userDAO.getRanking();
            int pos = 1;
            for (User u : ranking) {
                tableModel.addRow(new Object[] { pos++, u.getUsername(), u.getGamesWon(), u.getMinesFound(),
                        u.getGamesPlayed() });
            }
        });
        refreshBtn.doClick(); // Load initial data

        panel.add(refreshBtn, BorderLayout.NORTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }
}
