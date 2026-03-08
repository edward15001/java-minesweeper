package com.minesweeper.ui;

import com.minesweeper.dao.UserDAO;
import com.minesweeper.model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class UserPanel extends JPanel {
    private MainFrame mainFrame;
    private UserDAO userDAO;
    private CardLayout contentLayout;
    private JPanel contentPanel;

    // Store buttons to manage selection highlights
    private JButton playBtn;
    private JButton statsBtn;
    private JButton rankBtn;

    public UserPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.userDAO = new UserDAO();
        setLayout(new BorderLayout());
        setBackground(Theme.BG_COLOR);

        // --- HEADER ---
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        headerPanel.setBackground(Theme.BG_COLOR);

        JLabel title = new JLabel("FIELD_01: SUB_SURFACE SCANNER // TERMINAL_ID: "
                + mainFrame.getCurrentUser().getUsername().toUpperCase());
        title.setFont(Theme.TITLE_FONT);
        title.setForeground(Theme.ACCENT_COLOR);
        title.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Theme.DIM_COLOR));
        headerPanel.add(title);

        add(headerPanel, BorderLayout.NORTH);

        // --- LEFT MENU ---
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(Theme.BG_COLOR);
        menuPanel.setBorder(new EmptyBorder(40, 20, 20, 40));

        JLabel selectProtocol = new JLabel("SELECT_PROTOCOL:");
        selectProtocol.setFont(Theme.BOLD_FONT);
        selectProtocol.setForeground(Theme.DIM_COLOR);
        selectProtocol.setAlignmentX(Component.LEFT_ALIGNMENT);
        menuPanel.add(selectProtocol);
        menuPanel.add(Box.createVerticalStrut(15));

        playBtn = createMenuButton("> NEW_GRID [STD]");
        statsBtn = createMenuButton("> LOAD_PRIOR_SCAN [STATS]");
        rankBtn = createMenuButton("> GLOBAL_NET [RANK]");
        JButton logoutBtn = createMenuButton("> [EXIT_SYSTEM]");

        menuPanel.add(playBtn);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(statsBtn);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(rankBtn);
        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(logoutBtn);

        add(menuPanel, BorderLayout.WEST);

        // --- CONTENT PANEL (CARDS) ---
        contentLayout = new CardLayout();
        contentPanel = new JPanel(contentLayout);
        contentPanel.setBackground(Theme.BG_COLOR);
        contentPanel.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(20, 20, 20, 20),
                new LineBorder(Theme.DIM_COLOR, 1)));

        contentPanel.add(createPlayPanel(), "PLAY");
        contentPanel.add(createStatsPanel(), "STATS");
        contentPanel.add(createRankingPanel(), "RANK");

        add(contentPanel, BorderLayout.CENTER);

        // --- BOTTOM STATUS BAR ---
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setBackground(Theme.BG_COLOR);
        statusPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel sysStatus = new JLabel(
                "<html>SYS_STATUS: <font color='#CCFF00'>NOMINAL</font><br>DATA_STREAM: <font color='#CCFF00'>ACTIVE</font></html>");
        sysStatus.setFont(Theme.MAIN_FONT);
        sysStatus.setForeground(Theme.DIM_COLOR);
        statusPanel.add(sysStatus, BorderLayout.WEST);

        JLabel version = new JLabel("VER_1.4.2 [CYBERPUNK_MINESWEEPER]");
        version.setFont(Theme.MAIN_FONT);
        version.setForeground(Theme.ACCENT_COLOR);
        statusPanel.add(version, BorderLayout.EAST);

        add(statusPanel, BorderLayout.SOUTH);

        // Actions
        playBtn.addActionListener(e -> {
            selectMenu(playBtn);
            contentLayout.show(contentPanel, "PLAY");
        });
        statsBtn.addActionListener(e -> {
            selectMenu(statsBtn);
            contentLayout.show(contentPanel, "STATS");
        });
        rankBtn.addActionListener(e -> {
            selectMenu(rankBtn);
            contentLayout.show(contentPanel, "RANK");
        });
        logoutBtn.addActionListener(e -> {
            this.mainFrame.setCurrentUser(null);
            this.mainFrame.navigateTo("LoginPanel");
        });

        // Initial selection
        selectMenu(playBtn);

        Theme.applyTheme(this);

        // Overrides after theme application to assure styling
        applyMenuOverrides(playBtn);
        applyMenuOverrides(statsBtn);
        applyMenuOverrides(rankBtn);
        applyMenuOverrides(logoutBtn);
    }

    private void selectMenu(JButton active) {
        // Reset all
        playBtn.setForeground(Theme.DIM_COLOR);
        statsBtn.setForeground(Theme.DIM_COLOR);
        rankBtn.setForeground(Theme.DIM_COLOR);
        // Set active
        active.setForeground(Theme.ACCENT_COLOR);
    }

    private JButton createMenuButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(Theme.TITLE_FONT);
        btn.setBackground(Theme.BG_COLOR);
        btn.setForeground(Theme.DIM_COLOR);
        btn.setBorder(null);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        btn.setHorizontalAlignment(SwingConstants.LEFT);

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (btn.getForeground() != Theme.ACCENT_COLOR) {
                    btn.setForeground(Color.WHITE);
                }
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (btn.getForeground() != Theme.ACCENT_COLOR) {
                    btn.setForeground(Theme.DIM_COLOR);
                }
            }
        });

        return btn;
    }

    // Explicitly enforce menu colors after Theme.applyTheme runs
    private void applyMenuOverrides(JButton btn) {
        btn.setBorder(null);
        btn.setFont(Theme.TITLE_FONT);
    }

    private JPanel createPlayPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Theme.BG_COLOR);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel instruction = new JLabel("> SELECT TARGET [OPPONENT]:");
        instruction.setFont(Theme.TITLE_FONT);
        instruction.setForeground(Theme.DIM_COLOR);

        JComboBox<User> opponentCombo = new JComboBox<>();
        opponentCombo.setBackground(Theme.BG_COLOR);
        opponentCombo.setForeground(Theme.ACCENT_COLOR);
        opponentCombo.setFont(Theme.TITLE_FONT);
        opponentCombo.setBorder(new LineBorder(Theme.ACCENT_COLOR, 1));

        List<User> allUsers = userDAO.getAllUsers();
        for (User u : allUsers) {
            if ("USER".equals(u.getRole()) && u.getId() != mainFrame.getCurrentUser().getId()) {
                opponentCombo.addItem(u);
            }
        }

        JButton startBtn = new JButton("> [EXECUTE_MATCH_SEQUENCE]");
        startBtn.setFont(Theme.TITLE_FONT);
        startBtn.setBackground(Theme.BG_COLOR);
        startBtn.setForeground(Theme.ACCENT_COLOR);
        startBtn.setBorder(new LineBorder(Theme.ACCENT_COLOR, 1));
        startBtn.setFocusPainted(false);
        startBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        startBtn.addActionListener(e -> {
            User opponent = (User) opponentCombo.getSelectedItem();
            if (opponent != null) {
                mainFrame.startGame(mainFrame.getCurrentUser(), opponent);
            } else {
                UIManager.put("OptionPane.background", Theme.BG_COLOR);
                UIManager.put("Panel.background", Theme.BG_COLOR);
                UIManager.put("OptionPane.messageForeground", Theme.ACCENT_COLOR);
                JOptionPane.showMessageDialog(this, "ERR_NO_OPPONENT_FOUND", "SYS_WARN",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(instruction, gbc);

        gbc.gridy = 1;
        panel.add(opponentCombo, gbc);

        gbc.gridy = 2;
        gbc.insets = new Insets(30, 10, 10, 10);
        panel.add(startBtn, gbc);

        return panel;
    }

    private JPanel createStatsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Theme.BG_COLOR);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        User currentUser = mainFrame.getCurrentUser();
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
                    maxVal = 1;

                int barHeight = Math.max(25, h / 8);
                int gap = 35;
                int startY = 40;

                g2.setFont(Theme.TITLE_FONT);

                // Draw Played
                g2.setColor(Theme.ACCENT_COLOR);
                g2.drawString("> LOCAL_SCANS: " + played, 20, startY - 10);
                g2.setColor(new Color(45, 45, 45)); // Dark background
                g2.fillRect(20, startY, w - 60, barHeight);
                g2.setColor(Theme.DIM_COLOR); // Filled amount
                g2.fillRect(20, startY, (int) ((double) played / maxVal * (w - 60)), barHeight);

                startY += barHeight + gap;

                // Draw Won
                g2.setColor(Theme.ACCENT_COLOR);
                g2.drawString("> VICTORIES: " + won, 20, startY - 10);
                g2.setColor(new Color(45, 45, 45));
                g2.fillRect(20, startY, w - 60, barHeight);
                g2.setColor(Theme.DIM_COLOR);
                g2.fillRect(20, startY, (int) ((double) won / maxVal * (w - 60)), barHeight);

                startY += barHeight + gap;

                // Draw Mines
                g2.setColor(Theme.ACCENT_COLOR);
                g2.drawString("> TOTAL_MINES_CLEARED: " + mines, 20, startY - 10);
                g2.setColor(new Color(45, 45, 45));
                g2.fillRect(20, startY, w - 60, barHeight);
                g2.setColor(Theme.ACCENT_COLOR); // Accentuate the actual objective
                g2.fillRect(20, startY, (int) ((double) mines / maxVal * (w - 60)), barHeight);
            }
        };
        graphPanel.setBackground(Theme.BG_COLOR);
        graphPanel.setPreferredSize(new Dimension(500, 300));
        panel.add(graphPanel, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createRankingPanel() {
        JPanel panel = new JPanel(new BorderLayout(0, 15));
        panel.setBackground(Theme.BG_COLOR);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        String[] columns = { "IDX", "USER", "VICTORIES", "MINES", "SCANS" };
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);

        // Terminal Table Styling
        table.setBackground(Theme.BG_COLOR);
        table.setForeground(Theme.ACCENT_COLOR);
        table.setFont(Theme.BOLD_FONT);
        table.setGridColor(Theme.DIM_COLOR);
        table.setRowHeight(30);
        table.setShowGrid(false); // remove vertical/horizontal lines for a cleaner terminal look
        table.setIntercellSpacing(new Dimension(0, 0));

        // No column borders, just text
        table.getTableHeader().setBackground(Theme.BG_COLOR);
        table.getTableHeader().setForeground(Theme.ACCENT_COLOR);
        table.getTableHeader().setFont(Theme.TITLE_FONT);
        table.getTableHeader().setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Theme.DIM_COLOR));

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setBackground(Theme.BG_COLOR);
        renderer.setForeground(Color.WHITE); // Make row content white for contrast against green header
        renderer.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(45, 45, 45))); // row separator

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }

        JButton refreshBtn = new JButton("> [REFRESH_NET_DATA]");
        refreshBtn.setFont(Theme.TITLE_FONT);
        refreshBtn.setBackground(Theme.BG_COLOR);
        refreshBtn.setForeground(Theme.ACCENT_COLOR);
        refreshBtn.setBorder(null);
        refreshBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        refreshBtn.addActionListener(e -> {
            tableModel.setRowCount(0);
            List<User> ranking = userDAO.getRanking();
            int pos = 1;
            for (User u : ranking) {
                tableModel.addRow(new Object[] { String.format("%03d", pos++), u.getUsername(), u.getGamesWon(),
                        u.getMinesFound(),
                        u.getGamesPlayed() });
            }
        });
        refreshBtn.doClick(); // Load initial data

        JPanel btnWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnWrapper.setBackground(Theme.BG_COLOR);
        btnWrapper.add(refreshBtn);

        panel.add(btnWrapper, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(Theme.BG_COLOR);
        scrollPane.setBorder(null);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }
}
