package com.minesweeper.ui;

import com.minesweeper.dao.GameDAO;
import com.minesweeper.dao.UserDAO;
import com.minesweeper.model.User;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {
    private MainFrame mainFrame;
    private User player1;
    private User player2;

    private int p1Score = 0;
    private int p2Score = 0;
    private boolean isPlayer1Turn = true;

    private final int ROWS = 16;
    private final int COLS = 16;
    private final int MINES = 40;

    private int[][] board; // -1 = mine, 0-8 = adjacent
    private boolean[][] revealed;
    private JButton[][] buttons;

    private JLabel p1ScoreLabel;
    private JLabel p2ScoreLabel;
    private JLabel turnLabel;

    private int totalMinesFound = 0;
    private int cellsRevealed = 0;

    public GamePanel(MainFrame mainFrame, User player1, User player2) {
        this.mainFrame = mainFrame;
        this.player1 = player1;
        this.player2 = player2;

        setLayout(new BorderLayout());

        // --- TOP PANEL (Turn Indicator) ---
        JPanel topPanel = new JPanel();
        turnLabel = new JLabel("Turno de: " + player1.getUsername());
        turnLabel.setFont(Theme.TITLE_FONT);
        turnLabel.setForeground(Theme.ACCENT_COLOR);
        topPanel.add(turnLabel);
        add(topPanel, BorderLayout.NORTH);

        // --- CENTER PANEL (Board) ---
        JPanel boardPanel = new JPanel(new GridLayout(ROWS, COLS));
        buttons = new JButton[ROWS][COLS];
        board = new int[ROWS][COLS];
        revealed = new boolean[ROWS][COLS];

        initializeBoard();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                JButton btn = new JButton();
                btn.putClientProperty("isGrid", true);
                btn.setPreferredSize(new Dimension(30, 30));
                btn.setMargin(new Insets(0, 0, 0, 0));
                btn.setFont(Theme.BOLD_FONT);
                btn.setBackground(Theme.PANEL_BG);
                btn.setBorder(BorderFactory.createLineBorder(Theme.BG_COLOR));

                final int finalR = r;
                final int finalC = c;
                btn.addActionListener(e -> handleClick(finalR, finalC));

                buttons[r][c] = btn;
                boardPanel.add(btn);
            }
        }
        add(boardPanel, BorderLayout.CENTER);

        // --- SIDE PANELS (Players) ---
        JPanel p1Panel = new JPanel(new GridLayout(3, 1));
        p1Panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        p1Panel.add(new JLabel("Anfitrión:"));
        p1Panel.add(new JLabel(player1.getUsername(), SwingConstants.CENTER));
        p1ScoreLabel = new JLabel("Minas: 0", SwingConstants.CENTER);
        p1ScoreLabel.setFont(Theme.TITLE_FONT);
        p1ScoreLabel.setForeground(Theme.ACCENT_COLOR);
        p1Panel.add(p1ScoreLabel);
        add(p1Panel, BorderLayout.WEST);

        JPanel p2Panel = new JPanel(new GridLayout(3, 1));
        p2Panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        p2Panel.add(new JLabel("Invitado:"));
        p2Panel.add(new JLabel(player2.getUsername(), SwingConstants.CENTER));
        p2ScoreLabel = new JLabel("Minas: 0", SwingConstants.CENTER);
        p2ScoreLabel.setFont(Theme.TITLE_FONT);
        p2ScoreLabel.setForeground(new Color(255, 85, 85));
        p2Panel.add(p2ScoreLabel);
        add(p2Panel, BorderLayout.EAST);

        // --- BOTTOM PANEL ---
        JPanel bottomPanel = new JPanel();
        JButton surrenderBtn = new JButton("Salir sin guardar (Rendirse)");
        surrenderBtn.addActionListener(e -> mainFrame.setupUserPanel());
        bottomPanel.add(surrenderBtn);
        add(bottomPanel, BorderLayout.SOUTH);

        Theme.applyTheme(this);
    }

    private void initializeBoard() {
        Random rand = new Random();
        int minesPlaced = 0;

        while (minesPlaced < MINES) {
            int r = rand.nextInt(ROWS);
            int c = rand.nextInt(COLS);
            if (board[r][c] != -1) {
                board[r][c] = -1;
                minesPlaced++;
            }
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == -1)
                    continue;

                int count = 0;
                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        int nr = r + dr, nc = c + dc;
                        if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && board[nr][nc] == -1) {
                            count++;
                        }
                    }
                }
                board[r][c] = count;
            }
        }
    }

    private void handleClick(int r, int c) {
        if (revealed[r][c])
            return;

        boolean foundMine = false;

        if (board[r][c] == -1) { // Found a Mine
            revealed[r][c] = true;
            totalMinesFound++;
            buttons[r][c].setText("*");

            if (isPlayer1Turn) {
                p1Score++;
                p1ScoreLabel.setText("Minas: " + p1Score);
                buttons[r][c].setBackground(Theme.ACCENT_COLOR);
            } else {
                p2Score++;
                p2ScoreLabel.setText("Minas: " + p2Score);
                buttons[r][c].setBackground(new Color(255, 85, 85));
            }
            buttons[r][c].setForeground(Theme.BG_COLOR);
            buttons[r][c].setEnabled(false);

            foundMine = true;
        } else { // Normal Cell
            revealCell(r, c);
        }

        // Turn alternation logic: Keeps turn if found a mine!
        if (!foundMine) {
            isPlayer1Turn = !isPlayer1Turn;
            updateTurnLabel();
        }

        checkGameOver();
    }

    private void updateTurnLabel() {
        if (isPlayer1Turn) {
            turnLabel.setText("Turno de: " + player1.getUsername());
            turnLabel.setForeground(Theme.ACCENT_COLOR);
        } else {
            turnLabel.setText("Turno de: " + player2.getUsername());
            turnLabel.setForeground(new Color(255, 85, 85));
        }
    }

    private void revealCell(int r, int c) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS)
            return;
        if (revealed[r][c])
            return;
        if (board[r][c] == -1)
            return;

        revealed[r][c] = true;
        cellsRevealed++;
        buttons[r][c].setEnabled(false);
        buttons[r][c].setBackground(Theme.BG_COLOR);

        if (board[r][c] > 0) {
            buttons[r][c].setText(String.valueOf(board[r][c]));
            switch (board[r][c]) {
                case 1:
                    buttons[r][c].setForeground(Theme.ACCENT_COLOR);
                    break;
                case 2:
                    buttons[r][c].setForeground(new Color(255, 255, 85)); // Yellow
                    break;
                case 3:
                    buttons[r][c].setForeground(new Color(255, 120, 85)); // Orange
                    break;
                case 4:
                    buttons[r][c].setForeground(new Color(255, 85, 85)); // Red
                    break;
                default:
                    buttons[r][c].setForeground(Theme.FG_COLOR);
                    break;
            }
        } else {
            // board[r][c] == 0, auto-reveal adjacent
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    revealCell(r + dr, c + dc);
                }
            }
        }
    }

    private void checkGameOver() {
        int safeCells = (ROWS * COLS) - MINES;
        if (totalMinesFound >= MINES || cellsRevealed >= safeCells) {

            // Show all remaining mines
            for (int r = 0; r < ROWS; r++) {
                for (int c = 0; c < COLS; c++) {
                    if (board[r][c] == -1 && !revealed[r][c]) {
                        buttons[r][c].setText("*");
                        buttons[r][c].setBackground(Color.ORANGE);
                    }
                }
            }

            Integer winnerId = null;
            String winnerMsg = "¡Empate!";
            if (p1Score > p2Score) {
                winnerId = player1.getId();
                winnerMsg = "¡Ha ganado " + player1.getUsername() + "!";
            } else if (p2Score > p1Score) {
                winnerId = player2.getId();
                winnerMsg = "¡Ha ganado " + player2.getUsername() + "!";
            }

            JOptionPane.showMessageDialog(this, "Juego Terminado\n" + winnerMsg, "Fin de Partida",
                    JOptionPane.INFORMATION_MESSAGE);

            GameDAO gameDAO = new GameDAO();
            UserDAO userDAO = new UserDAO();

            boolean saved = gameDAO.recordGame(player1.getId(), player2.getId(), p1Score, p2Score, winnerId);
            if (saved) {
                userDAO.updateUserStats(player1.getId(), p1Score, (winnerId != null && winnerId == player1.getId()));
                userDAO.updateUserStats(player2.getId(), p2Score, (winnerId != null && winnerId == player2.getId()));
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar la partida en BD", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            mainFrame.setupUserPanel(); // Returns to user panel
        }
    }
}
