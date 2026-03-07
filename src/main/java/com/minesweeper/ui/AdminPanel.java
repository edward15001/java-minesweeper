package com.minesweeper.ui;

import com.minesweeper.dao.GameDAO;
import com.minesweeper.dao.UserDAO;
import com.minesweeper.model.Game;
import com.minesweeper.model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AdminPanel extends JPanel {
    private MainFrame mainFrame;
    private UserDAO userDAO;
    private GameDAO gameDAO;

    public AdminPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.userDAO = new UserDAO();
        this.gameDAO = new GameDAO();

        setLayout(new BorderLayout());

        // Header
        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Panel de Administrador", SwingConstants.CENTER);
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
        tabbedPane.add("Gestión de Usuarios", createUserManagementPanel());
        tabbedPane.add("Ranking", createRankingPanel());
        tabbedPane.add("Historial de Partidas", createHistoryPanel());

        add(tabbedPane, BorderLayout.CENTER);
        Theme.applyTheme(this);
    }

    private JPanel createUserManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Form
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Nuevo Usuario/Admin"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JTextField userField = new JTextField(15);
        JPasswordField passField = new JPasswordField(15);
        JComboBox<String> roleCombo = new JComboBox<>(new String[] { "USER", "ADMIN" });
        JButton createBtn = new JButton("Crear Usuario");

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Usuario:"), gbc);
        gbc.gridx = 1;
        formPanel.add(userField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Contraseña:"), gbc);
        gbc.gridx = 1;
        formPanel.add(passField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Rol:"), gbc);
        gbc.gridx = 1;
        formPanel.add(roleCombo, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        formPanel.add(createBtn, gbc);

        // User List
        DefaultListModel<User> listModel = new DefaultListModel<>();
        JList<User> userList = new JList<>(listModel);
        loadUsers(listModel);

        createBtn.addActionListener(e -> {
            String u = userField.getText();
            String p = new String(passField.getPassword());
            String r = (String) roleCombo.getSelectedItem();
            if (!u.isEmpty() && !p.isEmpty()) {
                if (userDAO.createUser(u, p, r)) {
                    JOptionPane.showMessageDialog(this, "Usuario creado exitosamente");
                    userField.setText("");
                    passField.setText("");
                    loadUsers(listModel);
                } else {
                    JOptionPane.showMessageDialog(this, "Error al crear usuario (¿Ya existe?)", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Completa todos los campos", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBorder(BorderFactory.createTitledBorder("Lista de Usuarios (Selecciona para eliminar)"));
        listPanel.add(new JScrollPane(userList), BorderLayout.CENTER);

        JButton deleteBtn = new JButton("Dar de Baja (Eliminar)");
        deleteBtn.addActionListener(e -> {
            User selected = userList.getSelectedValue();
            if (selected != null) {
                if ("admin".equals(selected.getUsername())) {
                    JOptionPane.showMessageDialog(this, "No se puede eliminar al admin por defecto.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int confirm = JOptionPane.showConfirmDialog(this,
                        "¿Seguro que deseas eliminar a " + selected.getUsername() + "?", "Confirmar",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    if (userDAO.deleteUser(selected.getId())) {
                        loadUsers(listModel);
                        JOptionPane.showMessageDialog(this, "Usuario eliminado");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un usuario de la lista", "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        listPanel.add(deleteBtn, BorderLayout.SOUTH);

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(listPanel, BorderLayout.CENTER);
        return panel;
    }

    private void loadUsers(DefaultListModel<User> model) {
        model.clear();
        for (User u : userDAO.getAllUsers()) {
            model.addElement(u);
        }
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

    private JPanel createHistoryPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        String[] columns = { "Fecha", "Jugador 1", "P1 Minas", "Jugador 2", "P2 Minas", "Ganador" };
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);

        JButton refreshBtn = new JButton("Actualizar Historial");
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
                        g.getWinnerUsername() != null ? g.getWinnerUsername() : "Empate"
                });
            }
        });
        refreshBtn.doClick(); // Load initial

        panel.add(refreshBtn, BorderLayout.NORTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }
}
