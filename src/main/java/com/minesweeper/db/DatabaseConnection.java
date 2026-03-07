package com.minesweeper.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.mindrot.jbcrypt.BCrypt;

public class DatabaseConnection {
    // Determine user home directory safely
    private static final String USER_HOME = System.getProperty("user.home");
    private static final String DB_DIR = USER_HOME + File.separator + ".minesweeper";
    private static final String DB_FILE = DB_DIR + File.separator + "minesweeper.db";
    // Construct JDBC URL with the correct path
    private static final String URL = "jdbc:sqlite:" + DB_FILE;

    public static Connection getConnection() throws SQLException {
        // Ensure the directory exists before connecting
        File directory = new File(DB_DIR);
        if (!directory.exists()) {
            directory.mkdirs(); // create directories if they don't exist
        }
        return DriverManager.getConnection(URL);
    }

    public static void initializeDatabase() {
        String sqlUsers = """
                    CREATE TABLE IF NOT EXISTS users (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        username VARCHAR(50) UNIQUE NOT NULL,
                        password VARCHAR(255) NOT NULL,
                        role VARCHAR(10) NOT NULL,
                        mines_found INTEGER DEFAULT 0,
                        games_played INTEGER DEFAULT 0,
                        games_won INTEGER DEFAULT 0
                    );
                """;

        String sqlGames = """
                    CREATE TABLE IF NOT EXISTS games (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        date DATETIME DEFAULT CURRENT_TIMESTAMP,
                        player1_id INTEGER,
                        player2_id INTEGER,
                        player1_score INTEGER,
                        player2_score INTEGER,
                        winner_id INTEGER,
                        FOREIGN KEY(player1_id) REFERENCES users(id),
                        FOREIGN KEY(player2_id) REFERENCES users(id),
                        FOREIGN KEY(winner_id) REFERENCES users(id)
                    );
                """;

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement()) {

            // Create tables
            stmt.execute(sqlUsers);
            stmt.execute(sqlGames);

            // Insert default admin if not exists
            String checkAdmin = "SELECT COUNT(*) FROM users WHERE role = 'ADMIN'";
            var rs = stmt.executeQuery(checkAdmin);
            if (rs.next() && rs.getInt(1) == 0) {
                // Default admin: admin / admin
                String defaultAdminHash = BCrypt.hashpw("admin", BCrypt.gensalt());
                String insertAdmin = String.format(
                        "INSERT INTO users (username, password, role) VALUES ('admin', '%s', 'ADMIN')",
                        defaultAdminHash);
                stmt.execute(insertAdmin);
                System.out.println("Default admin user created (admin/admin)");
            }

        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
