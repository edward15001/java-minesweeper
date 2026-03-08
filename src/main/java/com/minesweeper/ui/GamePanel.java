package com.minesweeper.ui;

import com.minesweeper.dao.GameDAO;
import com.minesweeper.dao.UserDAO;
import com.minesweeper.model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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

    private int[][] board;
    private boolean[][] revealed;
    private JButton[][] buttons;

    private JLabel p1ScoreLabel;
    private JLabel p2ScoreLabel;
    private JLabel p1MinesLabel;
    private JLabel p2MinesLabel;
    private JLabel p2ProgressLabel;

    // Cyberpunk specific colors matching mockup
    private final Color CYBER_NEON = new Color(204, 255, 0); // #CCFF00
    private final Color CYBER_DIM = new Color(120, 140, 90);
    private final Color CYBER_DARK_GREEN = new Color(60, 80, 20); // Board grid borders
    private final Color CYBER_BG = new Color(25, 25, 25);
    private final Color CYBER_CELL_UNREVEALED = new Color(35, 45, 15);
    private final Color CYBER_CELL_REVEALED = new Color(15, 15, 15);

    private final Font FONT_BOLD = new Font("Monospaced", Font.BOLD, 12);
    private final Font FONT_TITLE = new Font("Monospaced", Font.BOLD, 14);

    private int totalMinesFound = 0;
    private int cellsRevealed = 0;

    public GamePanel(MainFrame mainFrame, User player1, User player2) {
        this.mainFrame = mainFrame;
        this.player1 = player1;
        this.player2 = player2;

        setBackground(CYBER_BG);
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        // --- TOP HEADER ---
        JPanel topWrapper = new JPanel(new BorderLayout());
        topWrapper.setBackground(CYBER_BG);

        JLabel headerTab = new JLabel(" HEADER ");
        headerTab.setFont(FONT_BOLD);
        headerTab.setOpaque(true);
        headerTab.setBackground(Color.GRAY);
        headerTab.setForeground(Color.BLACK);

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        titlePanel.setBackground(CYBER_BG);
        titlePanel.setBorder(new LineBorder(CYBER_DIM, 1));
        JLabel titleLabel = new JLabel("COMPETITIVE MINESWEEPER // PHASE 03 / SECTOR 7");
        titleLabel.setFont(FONT_TITLE);
        titleLabel.setForeground(CYBER_NEON);
        titlePanel.add(titleLabel);

        topWrapper.add(headerTab, BorderLayout.NORTH);
        topWrapper.add(titlePanel, BorderLayout.CENTER);
        add(topWrapper, BorderLayout.NORTH);

        // --- LEFT PANEL (PLAYER 1 STATS) ---
        add(createPlayer1Panel(), BorderLayout.WEST);

        // --- RIGHT PANEL (PLAYER 2 STATS) ---
        add(createPlayer2Panel(), BorderLayout.EAST);

        // --- CENTER PANEL (BOARD) ---
        JPanel boardWrapper = new JPanel(new BorderLayout());
        boardWrapper.setBackground(CYBER_BG);

        JLabel boardTitle = new JLabel(
                " MIND/SWEEPER // LIVE MATCH  ( Turn: " + player1.getUsername().toUpperCase() + " )",
                SwingConstants.LEFT);
        boardTitle.setFont(FONT_BOLD);
        boardTitle.setForeground(CYBER_NEON);
        boardTitle.setBorder(new LineBorder(CYBER_NEON, 1));
        boardWrapper.add(boardTitle, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel(new GridLayout(ROWS, COLS)) {
            @Override
            public Dimension getMinimumSize() {
                return getPreferredSize(); // Prevent squishing, guarantee square grid
            }

            @Override
            public Dimension getMaximumSize() {
                return getPreferredSize();
            }
        };
        boardPanel.setBackground(CYBER_BG);
        boardPanel.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(5, 5, 5, 5),
                new LineBorder(CYBER_NEON, 2)));

        buttons = new JButton[ROWS][COLS];
        board = new int[ROWS][COLS];
        revealed = new boolean[ROWS][COLS];

        initializeBoard();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                JButton btn = new JButton();
                btn.setPreferredSize(new Dimension(28, 28));
                btn.setMargin(new Insets(0, 0, 0, 0));
                btn.setBorderPainted(true);
                btn.setFocusPainted(false);
                btn.setContentAreaFilled(true);
                btn.setOpaque(true);

                btn.setFont(FONT_TITLE);
                btn.setBackground(CYBER_CELL_UNREVEALED);
                btn.setForeground(CYBER_NEON);
                btn.setBorder(new LineBorder(CYBER_DARK_GREEN, 1));

                final int finalR = r;
                final int finalC = c;
                btn.addActionListener(e -> handleClick(finalR, finalC, boardTitle));

                buttons[r][c] = btn;
                boardPanel.add(btn);
            }
        }

        JPanel boardCenterAligner = new JPanel(new GridBagLayout());
        boardCenterAligner.setBackground(CYBER_BG);
        GridBagConstraints gbcBoard = new GridBagConstraints();
        gbcBoard.gridx = 0;
        gbcBoard.gridy = 0;
        gbcBoard.weightx = 1.0;
        gbcBoard.weighty = 1.0;
        gbcBoard.anchor = GridBagConstraints.CENTER;
        boardCenterAligner.add(boardPanel, gbcBoard);

        boardWrapper.add(boardCenterAligner, BorderLayout.CENTER);
        add(boardWrapper, BorderLayout.CENTER);

        // --- BOTTOM PANEL (LOG) ---
        JPanel bottomWrapper = new JPanel(new BorderLayout());
        bottomWrapper.setBackground(CYBER_BG);

        JPanel logPanel = new JPanel(new GridLayout(3, 1));
        logPanel.setBackground(CYBER_BG);
        logPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(new LineBorder(CYBER_DIM), "SESSION_LOG // EVENT [ACTIVE]", 0, 0,
                        FONT_BOLD, CYBER_NEON),
                new EmptyBorder(5, 10, 5, 10)));

        logPanel.add(createStyledLabel("TARGET_MINES: " + MINES, CYBER_DIM, CYBER_NEON));
        logPanel.add(createStyledLabel("GAME_STATE: RANKED_LIVE", CYBER_DIM, CYBER_NEON));
        logPanel.add(createStyledLabel("DIFFICULTY: EXPERT (MOD 4)", CYBER_DIM, CYBER_NEON));

        bottomWrapper.add(logPanel, BorderLayout.WEST);

        JButton surrenderBtn = new JButton("> TERM_SESSION ()");
        surrenderBtn.setFont(FONT_TITLE);
        surrenderBtn.setBackground(CYBER_BG);
        surrenderBtn.setForeground(CYBER_NEON);
        surrenderBtn.setBorder(new LineBorder(CYBER_NEON, 1));
        surrenderBtn.setFocusPainted(false);
        surrenderBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        surrenderBtn.addActionListener(e -> mainFrame.setupUserPanel());

        JPanel btnWrapper = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnWrapper.setBackground(CYBER_BG);
        btnWrapper.add(surrenderBtn);
        bottomWrapper.add(btnWrapper, BorderLayout.EAST);

        add(bottomWrapper, BorderLayout.SOUTH);
    }

    private JPanel createPlayer1Panel() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(CYBER_BG);
        p.setPreferredSize(new Dimension(240, 0)); // Prevent squishing

        JLabel tab = new JLabel(" PLAYER STATS ");
        tab.setFont(FONT_BOLD);
        tab.setOpaque(true);
        tab.setBackground(Color.GRAY);
        tab.setForeground(Color.BLACK);
        p.add(tab, BorderLayout.NORTH);

        JPanel c = new JPanel(new GridBagLayout());
        c.setBackground(CYBER_BG);
        c.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(CYBER_DIM, 1),
                new EmptyBorder(10, 10, 10, 10)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 5, 2, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        addStatRow(c, "RANK:", "MASTER [III]", CYBER_DIM, CYBER_NEON, gbc);
        addStatRow(c, "USERNAME:", player1.getUsername().toUpperCase(), CYBER_DIM, CYBER_NEON, gbc);

        p1ScoreLabel = new JLabel(String.valueOf(p1Score));
        p1ScoreLabel.setFont(FONT_BOLD);
        p1ScoreLabel.setForeground(CYBER_NEON);
        addCustomStatRow(c, "SCORE:", p1ScoreLabel, gbc);

        addStatRow(c, "TIME:", "00:00.00", CYBER_DIM, CYBER_NEON, gbc); // Dummy timer

        p1MinesLabel = new JLabel("0/" + MINES + " LEFT");
        p1MinesLabel.setFont(FONT_BOLD);
        p1MinesLabel.setForeground(CYBER_NEON);
        addCustomStatRow(c, "MINES:", p1MinesLabel, gbc);

        addStatRow(c, "APM:", "112", CYBER_DIM, CYBER_NEON, gbc); // Dummy
        addStatRow(c, "ACCURACY:", "97.8%", CYBER_DIM, CYBER_NEON, gbc); // Dummy

        // Dummy ASCII Graph
        JTextArea graph = new JTextArea("\n   _.-^-._    [#CCFF00]\n -'       '-. [#608050]\n------------- [#000000]");
        graph.setFont(new Font("Monospaced", Font.PLAIN, 10));
        graph.setBackground(CYBER_BG);
        graph.setForeground(CYBER_DIM);
        graph.setEditable(false);

        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        c.add(graph, gbc);

        p.add(c, BorderLayout.CENTER);
        return p;
    }

    private JPanel createPlayer2Panel() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(CYBER_BG);
        p.setPreferredSize(new Dimension(240, 0)); // Prevent squishing

        JLabel tab = new JLabel(" OPPONENT_STREAM ");
        tab.setFont(FONT_BOLD);
        tab.setOpaque(true);
        tab.setBackground(Color.GRAY);
        tab.setForeground(Color.BLACK);
        p.add(tab, BorderLayout.NORTH);

        JPanel c = new JPanel(new GridBagLayout());
        c.setBackground(CYBER_BG);
        c.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(new LineBorder(CYBER_DIM, 1), "RANKED_MATCH [v]", 0, 0, FONT_BOLD,
                        CYBER_NEON),
                new EmptyBorder(10, 10, 10, 10)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 5, 2, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        addStatRow(c, "OPPONENT:", player2.getUsername().toUpperCase(), CYBER_DIM, CYBER_NEON, gbc);
        addStatRow(c, "RANK:", "MASTER [II]", CYBER_DIM, CYBER_NEON, gbc);

        p2ProgressLabel = new JLabel("[          ] 0%");
        p2ProgressLabel.setFont(FONT_BOLD);
        p2ProgressLabel.setForeground(CYBER_NEON);
        addCustomStatRow(c, "PROGRESS:", p2ProgressLabel, gbc);

        p2ScoreLabel = new JLabel(String.valueOf(p2Score));
        p2ScoreLabel.setFont(FONT_BOLD);
        p2ScoreLabel.setForeground(CYBER_NEON);
        addCustomStatRow(c, "SCORE:", p2ScoreLabel, gbc);

        p2MinesLabel = new JLabel("0/" + MINES);
        p2MinesLabel.setFont(FONT_BOLD);
        p2MinesLabel.setForeground(CYBER_NEON);
        addCustomStatRow(c, "MINES:", p2MinesLabel, gbc);

        JTextArea graph = new JTextArea("\n █████░░░░░░ [#CCFF00]\n ░░░░░░░░░░░ [#608050]\n [ #CCFF00 ] ");
        graph.setFont(new Font("Monospaced", Font.PLAIN, 10));
        graph.setBackground(CYBER_BG);
        graph.setForeground(CYBER_DIM);
        graph.setEditable(false);

        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        c.add(graph, gbc);

        p.add(c, BorderLayout.CENTER);
        return p;
    }

    private void addStatRow(JPanel container, String lblStr, String valStr, Color lblColor, Color valColor,
            GridBagConstraints gbc) {
        JLabel valLabel = new JLabel(valStr);
        valLabel.setFont(FONT_BOLD);
        valLabel.setForeground(valColor);
        addCustomStatRow(container, lblStr, valLabel, gbc);
    }

    private void addCustomStatRow(JPanel container, String lblStr, JLabel valLabel, GridBagConstraints gbc) {
        JLabel lbl = new JLabel(lblStr);
        lbl.setFont(FONT_BOLD);
        lbl.setForeground(CYBER_DIM);

        gbc.gridx = 0;
        container.add(lbl, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        container.add(valLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST;
    }

    private JLabel createStyledLabel(String text, Color prefixColor, Color suffixColor) {
        JLabel l = new JLabel(text);
        l.setFont(FONT_BOLD);
        // We use split approach or just keep it simple with one color
        l.setForeground(CYBER_DIM);
        return l;
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

    private void handleClick(int r, int c, JLabel boardTitle) {
        if (revealed[r][c])
            return;

        boolean foundMine = false;

        if (board[r][c] == -1) { // Found a Mine
            revealed[r][c] = true;
            totalMinesFound++;

            // "F>" as flag design seen in mockup
            buttons[r][c].setText("⚑");
            buttons[r][c].setBackground(CYBER_CELL_REVEALED); // Dark cell
            buttons[r][c].setForeground(CYBER_NEON);
            buttons[r][c].setBorder(new LineBorder(CYBER_NEON, 1)); // Bright border when flagged
            buttons[r][c].setEnabled(false);

            if (isPlayer1Turn) {
                p1Score += 100;
                p1ScoreLabel.setText(String.format("%,d", p1Score));
                p1MinesLabel.setText(p1Score / 100 + "/" + MINES + " LEFT");
            } else {
                p2Score += 100;
                p2ScoreLabel.setText(String.format("%,d", p2Score));
                p2MinesLabel.setText(p2Score / 100 + "/" + MINES);
                updateP2ProgressBar();
            }

            foundMine = true;
        } else { // Normal Cell
            revealCell(r, c);
        }

        // Turn alternation logic: Keeps turn if found a mine
        if (!foundMine) {
            isPlayer1Turn = !isPlayer1Turn;
            boardTitle.setText(" MIND/SWEEPER // LIVE MATCH  ( Turn: "
                    + (isPlayer1Turn ? player1.getUsername() : player2.getUsername()).toUpperCase() + " )");
        }

        checkGameOver();
    }

    private void updateP2ProgressBar() {
        int percent = (int) (((double) (p2Score / 100) / (MINES / 2.0)) * 100);
        if (percent > 100)
            percent = 100;

        int bars = percent / 10;
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < 10; i++) {
            if (i < bars)
                sb.append("█");
            else
                sb.append(" ");
        }
        sb.append("] ").append(percent).append("%");
        p2ProgressLabel.setText(sb.toString());

        // Color transition logic (green to yellowish) if necessary, sticking to neon
        // for now
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
        buttons[r][c].setBackground(CYBER_CELL_REVEALED);
        buttons[r][c].setBorder(new LineBorder(CYBER_DARK_GREEN, 1));

        if (board[r][c] > 0) {
            buttons[r][c].setText(String.valueOf(board[r][c]));
            // Number coloring matching mockup style (various greens)
            switch (board[r][c]) {
                case 1:
                    buttons[r][c].setForeground(CYBER_NEON);
                    break;
                case 2:
                    buttons[r][c].setForeground(new Color(180, 255, 50));
                    break;
                case 3:
                    buttons[r][c].setForeground(new Color(230, 255, 100));
                    break;
                default:
                    buttons[r][c].setForeground(Color.WHITE);
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
                        buttons[r][c].setText("F");
                        buttons[r][c].setBackground(CYBER_CELL_REVEALED);
                        buttons[r][c].setForeground(CYBER_DIM);
                        buttons[r][c].setBorder(new LineBorder(CYBER_DIM, 1));
                    }
                }
            }

            Integer winnerId = null;
            String winnerMsg = "SYS_RESULT // DRAW";
            if (p1Score > p2Score) {
                winnerId = player1.getId();
                winnerMsg = "SYS_RESULT // VICTORY: " + player1.getUsername().toUpperCase();
            } else if (p2Score > p1Score) {
                winnerId = player2.getId();
                winnerMsg = "SYS_RESULT // VICTORY: " + player2.getUsername().toUpperCase();
            }

            UIManager.put("OptionPane.background", CYBER_BG);
            UIManager.put("Panel.background", CYBER_BG);
            UIManager.put("OptionPane.messageForeground", CYBER_NEON);
            JOptionPane.showMessageDialog(this, "SESSION_TERMINATED\n" + winnerMsg, "SYS_END",
                    JOptionPane.INFORMATION_MESSAGE);

            GameDAO gameDAO = new GameDAO();
            UserDAO userDAO = new UserDAO();

            boolean saved = gameDAO.recordGame(player1.getId(), player2.getId(), p1Score / 100, p2Score / 100,
                    winnerId);
            if (saved) {
                userDAO.updateUserStats(player1.getId(), p1Score / 100,
                        (winnerId != null && winnerId == player1.getId()));
                userDAO.updateUserStats(player2.getId(), p2Score / 100,
                        (winnerId != null && winnerId == player2.getId()));
            } else {
                JOptionPane.showMessageDialog(this, "ERR_DB_SAVE_FAILED", "SYS_ERR", JOptionPane.ERROR_MESSAGE);
            }

            mainFrame.setupUserPanel();
        }
    }
}
