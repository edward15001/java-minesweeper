package com.minesweeper;

import com.minesweeper.db.DatabaseConnection;
import com.minesweeper.ui.MainFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Initialize the local SQLite database and default admin
        DatabaseConnection.initializeDatabase();

        // Start the application GUI
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
