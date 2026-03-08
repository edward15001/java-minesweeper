package com.minesweeper.ui;

import com.minesweeper.dao.GameDAO;
import com.minesweeper.dao.UserDAO;
import com.minesweeper.model.Game;
import com.minesweeper.model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AdminPanel extends JPanel {
    private MainFrame mainFrame;
    private UserDAO userDAO;
    private GameDAO gameDAO;
    private CardLayout contentLayout;
    private JPanel contentPanel;

    // Menu buttons
    private JButton usersBtn;
    private JButton rankBtn;
    private JButton historyBtn;

    public AdminPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.userDAO = new UserDAO();
        this.gameDAO = new GameDAO();

        setLayout(new BorderLayout());
        setBackground(Theme.BG_COLOR);

        // --- HEADER ---
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        headerPanel.setBackground(Theme.BG_COLOR);

        JLabel title = new JLabel(
                "SYS_ADMIN: ROOT_ACCESS // TERMINAL_ID: " + mainFrame.getCurrentUser().getUsername().toUpperCase());
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

        JLabel selectProtocol = new JLabel("OVERRIDE_PROTOCOL:");
        selectProtocol.setFont(Theme.BOLD_FONT);
        selectProtocol.setForeground(Theme.DIM_COLOR);
        selectProtocol.setAlignmentX(Component.LEFT_ALIGNMENT);
        menuPanel.add(selectProtocol);
        menuPanel.add(Box.createVerticalStrut(15));

        usersBtn = createMenuButton("> MANAGE_SYSTEM [USERS]");
        rankBtn = createMenuButton("> GLOBAL_NET [RANK]");
        historyBtn = createMenuButton("> AUDIT_LOGS [MATCHES]");
        JButton logoutBtn = createMenuButton("> [EXIT_SYSTEM]");

        menuPanel.add(usersBtn);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(rankBtn);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(historyBtn);
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

        contentPanel.add(createUserManagementPanel(), "USERS");
        contentPanel.add(createRankingPanel(), "RANK");
        contentPanel.add(createHistoryPanel(), "HISTORY");

        add(contentPanel, BorderLayout.CENTER);

        // --- BOTTOM STATUS BAR ---
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setBackground(Theme.BG_COLOR);
        statusPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel sysStatus = new JLabel(
                "<html>SYS_STATUS: <font color='#CCFF00'>OVERRIDE_ACTIVE</font><br>DATA_STREAM: <font color='#CCFF00'>UNRESTRICTED</font></html>");
        sysStatus.setFont(Theme.MAIN_FONT);
        sysStatus.setForeground(Theme.DIM_COLOR);
        statusPanel.add(sysStatus, BorderLayout.WEST);

        JLabel version = new JLabel("VER_1.4.2 [CYBERPUNK_MINESWEEPER]");
        version.setFont(Theme.MAIN_FONT);
        version.setForeground(Theme.ACCENT_COLOR);
        statusPanel.add(version, BorderLayout.EAST);

        add(statusPanel, BorderLayout.SOUTH);

        // Actions
        usersBtn.addActionListener(e -> {
            selectMenu(usersBtn);
            contentLayout.show(contentPanel, "USERS");
        });
        rankBtn.addActionListener(e -> {
            selectMenu(rankBtn);
            contentLayout.show(contentPanel, "RANK");
        });
        historyBtn.addActionListener(e -> {
            selectMenu(historyBtn);
            contentLayout.show(contentPanel, "HISTORY");
        });
        logoutBtn.addActionListener(e -> {
            this.mainFrame.setCurrentUser(null);
            this.mainFrame.navigateTo("LoginPanel");
        });

        // Initial selection
        selectMenu(usersBtn);

        Theme.applyTheme(this);

        applyMenuOverrides(usersBtn);
        applyMenuOverrides(rankBtn);
        applyMenuOverrides(historyBtn);
        applyMenuOverrides(logoutBtn);
    }

    // Explicitly enforce menu colors after Theme.applyTheme runs
    private void applyMenuOverrides(JButton btn) {
        btn.setBorder(null);
        btn.setFont(Theme.TITLE_FONT);
    }

    private void selectMenu(JButton active) {
        usersBtn.setForeground(Theme.DIM_COLOR);
        rankBtn.setForeground(Theme.DIM_COLOR);
        historyBtn.setForeground(Theme.DIM_COLOR);
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
                if (btn.getForeground() != Theme.ACCENT_COLOR)
                    btn.setForeground(Color.WHITE);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (btn.getForeground() != Theme.ACCENT_COLOR)
                    btn.setForeground(Theme.DIM_COLOR);
            }
        });

        return btn;
    }

    private JPanel createUserManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(Theme.BG_COLOR);

        // Form
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Theme.BG_COLOR);
        formPanel.setBorder(BorderFactory.createTitledBorder(new LineBorder(Theme.DIM_COLOR),
                "SYS_INSERT // NEW_RECORD", 0, 0, Theme.BOLD_FONT, Theme.ACCENT_COLOR));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField userField = new JTextField(15);
        styleInputField(userField);
        JPasswordField passField = new JPasswordField(15);
        styleInputField(passField);

        JComboBox<String> roleCombo = new JComboBox<>(new String[] { "USER", "ADMIN" });
        roleCombo.setBackground(Theme.BG_COLOR);
        roleCombo.setForeground(Theme.ACCENT_COLOR);
        roleCombo.setFont(Theme.MAIN_FONT);

        JButton createBtn = new JButton("> [EXECUTE_INSERT]");
        styleActionBtn(createBtn);

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(createLabel("> USER:"), gbc);
        gbc.gridx = 1;
        formPanel.add(userField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(createLabel("> PASS:"), gbc);
        gbc.gridx = 1;
        formPanel.add(passField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(createLabel("> ROLE:"), gbc);
        gbc.gridx = 1;
        formPanel.add(roleCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 5, 5, 5);
        formPanel.add(createBtn, gbc);

        // User List
        DefaultListModel<User> listModel = new DefaultListModel<>();
        JList<User> userList = new JList<>(listModel);
        userList.setBackground(Theme.BG_COLOR);
        userList.setForeground(Color.WHITE);
        userList.setFont(Theme.MAIN_FONT);
        userList.setSelectionBackground(Theme.ACCENT_COLOR);
        userList.setSelectionForeground(Theme.BG_COLOR);

        loadUsers(listModel);

        createBtn.addActionListener(e -> {
            String u = userField.getText();
            String p = new String(passField.getPassword());
            String r = (String) roleCombo.getSelectedItem();
            if (!u.isEmpty() && !p.isEmpty()) {
                if (userDAO.createUser(u, p, r)) {
                    showSysMsg("RECORD_INSERTED", JOptionPane.INFORMATION_MESSAGE);
                    userField.setText("");
                    passField.setText("");
                    loadUsers(listModel);
                } else {
                    showSysMsg("ERR_CREATION_FAILED (DUPLICATE?)", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                showSysMsg("ERR_INCOMPLETE_PARAMS", JOptionPane.WARNING_MESSAGE);
            }
        });

        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBackground(Theme.BG_COLOR);
        listPanel.setBorder(BorderFactory.createTitledBorder(new LineBorder(Theme.DIM_COLOR), "SYS_QUERY // USERS_DB",
                0, 0, Theme.BOLD_FONT, Theme.ACCENT_COLOR));

        JScrollPane scroll = new JScrollPane(userList);
        scroll.getViewport().setBackground(Theme.BG_COLOR);
        scroll.setBorder(null);
        listPanel.add(scroll, BorderLayout.CENTER);

        JButton deleteBtn = new JButton("> [DROP_RECORD]");
        styleActionBtn(deleteBtn);
        deleteBtn.addActionListener(e -> {
            User selected = userList.getSelectedValue();
            if (selected != null) {
                if ("admin".equals(selected.getUsername())) {
                    showSysMsg("ERR_ROOT_PROTECTION", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int confirm = JOptionPane.showConfirmDialog(this,
                        "CONFIRM_PURGE: " + selected.getUsername() + "?", "SYS_WARN",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    if (userDAO.deleteUser(selected.getId())) {
                        loadUsers(listModel);
                        showSysMsg("RECORD_PURGED", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } else {
                showSysMsg("ERR_NO_RECORD_SELECTED", JOptionPane.WARNING_MESSAGE);
            }
        });

        JPanel btnWrap = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnWrap.setBackground(Theme.BG_COLOR);
        btnWrap.add(deleteBtn);
        listPanel.add(btnWrap, BorderLayout.SOUTH);

        panel.add(formPanel, BorderLayout.WEST);
        panel.add(listPanel, BorderLayout.CENTER);
        return panel;
    }

    private void styleInputField(JTextField field) {
        field.setBackground(Theme.BG_COLOR);
        field.setForeground(Color.WHITE); // Input text in white for contrast
        field.setFont(Theme.TITLE_FONT);
        field.setCaretColor(Theme.ACCENT_COLOR);
        field.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Theme.DIM_COLOR)); // Only bottom line
    }

    private JLabel createLabel(String txt) {
        JLabel l = new JLabel(txt);
        l.setFont(Theme.TITLE_FONT);
        l.setForeground(Theme.DIM_COLOR);
        return l;
    }

    private void styleActionBtn(JButton btn) {
        btn.setFont(Theme.TITLE_FONT);
        btn.setBackground(Theme.BG_COLOR);
        btn.setForeground(Theme.ACCENT_COLOR);
        btn.setBorder(null);
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void showSysMsg(String msg, int type) {
        UIManager.put("OptionPane.background", Theme.BG_COLOR);
        UIManager.put("Panel.background", Theme.BG_COLOR);
        UIManager.put("OptionPane.messageForeground", Theme.ACCENT_COLOR);
        JOptionPane.showMessageDialog(this, msg, "SYS_NOTIFY", type);
    }

    private void loadUsers(DefaultListModel<User> model) {
        model.clear();
        for (User u : userDAO.getAllUsers()) {
            model.addElement(u);
        }
    }

    private JPanel createRankingPanel() {
        JPanel panel = new JPanel(new BorderLayout(0, 15));
        panel.setBackground(Theme.BG_COLOR);

        String[] columns = { "IDX", "USER", "VICTORIES", "MINES", "SCANS" };
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);
        styleTerminalTable(table);

        JButton refreshBtn = new JButton("> [REFRESH_NET_DATA]");
        styleActionBtn(refreshBtn);
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
        refreshBtn.doClick();

        JPanel btnWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnWrapper.setBackground(Theme.BG_COLOR);
        btnWrapper.add(refreshBtn);

        panel.add(btnWrapper, BorderLayout.NORTH);
        JScrollPane scroll = new JScrollPane(table);
        scroll.getViewport().setBackground(Theme.BG_COLOR);
        scroll.setBorder(null);
        panel.add(scroll, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createHistoryPanel() {
        JPanel panel = new JPanel(new BorderLayout(0, 15));
        panel.setBackground(Theme.BG_COLOR);

        String[] columns = { "TIMESTAMP", "HOST", "H_SCORE", "GUEST", "G_SCORE", "RESULT" };
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);
        styleTerminalTable(table);

        JButton refreshBtn = new JButton("> [REFRESH_LOGS]");
        styleActionBtn(refreshBtn);
        refreshBtn.addActionListener(e -> {
            tableModel.setRowCount(0);
            List<Game> games = gameDAO.getGameHistory();
            for (Game g : games) {
                tableModel.addRow(new Object[] {
                        g.getDate(),
                        g.getPlayer1Username(),
                        g.getPlayer1Score(),
                        g.getPlayer2Username(),
                        g.getPlayer2Score(),
                        g.getWinnerUsername() != null ? g.getWinnerUsername() : "DRAW"
                });
            }
        });
        refreshBtn.doClick();

        JPanel btnWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnWrapper.setBackground(Theme.BG_COLOR);
        btnWrapper.add(refreshBtn);

        panel.add(btnWrapper, BorderLayout.NORTH);
        JScrollPane scroll = new JScrollPane(table);
        scroll.getViewport().setBackground(Theme.BG_COLOR);
        scroll.setBorder(null);
        panel.add(scroll, BorderLayout.CENTER);
        return panel;
    }

    private void styleTerminalTable(JTable table) {
        table.setBackground(Theme.BG_COLOR);
        table.setForeground(Theme.ACCENT_COLOR);
        table.setFont(Theme.BOLD_FONT);
        table.setGridColor(Theme.DIM_COLOR);
        table.setRowHeight(30);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));

        table.getTableHeader().setBackground(Theme.BG_COLOR);
        table.getTableHeader().setForeground(Theme.ACCENT_COLOR);
        table.getTableHeader().setFont(Theme.TITLE_FONT);
        table.getTableHeader().setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Theme.DIM_COLOR));

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setBackground(Theme.BG_COLOR);
        renderer.setForeground(Color.WHITE);
        renderer.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(45, 45, 45)));

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }
}
