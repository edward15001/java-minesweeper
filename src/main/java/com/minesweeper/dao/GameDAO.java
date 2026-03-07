package com.minesweeper.dao;

import com.minesweeper.db.DatabaseConnection;
import com.minesweeper.model.Game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDAO {

    public boolean recordGame(int player1Id, int player2Id, int player1Score, int player2Score, Integer winnerId) {
        String sql = "INSERT INTO games(player1_id, player2_id, player1_score, player2_score, winner_id) VALUES(?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, player1Id);
            pstmt.setInt(2, player2Id);
            pstmt.setInt(3, player1Score);
            pstmt.setInt(4, player2Score);
            if (winnerId != null) {
                pstmt.setInt(5, winnerId);
            } else {
                pstmt.setNull(5, Types.INTEGER); // Draw
            }
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Game> getGameHistory() {
        List<Game> games = new ArrayList<>();
        // Query bridging games and users to get usernames
        String sql = """
                    SELECT g.*,
                           u1.username AS p1_user,
                           u2.username AS p2_user,
                           uw.username AS winner_user
                    FROM games g
                    LEFT JOIN users u1 ON g.player1_id = u1.id
                    LEFT JOIN users u2 ON g.player2_id = u2.id
                    LEFT JOIN users uw ON g.winner_id = uw.id
                    ORDER BY g.date DESC
                """;
        try (Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Game game = new Game(
                        rs.getInt("id"),
                        rs.getTimestamp("date"),
                        rs.getInt("player1_id"),
                        rs.getInt("player2_id"),
                        rs.getInt("player1_score"),
                        rs.getInt("player2_score"),
                        rs.getObject("winner_id") != null ? rs.getInt("winner_id") : null);
                game.setPlayer1Username(rs.getString("p1_user"));
                game.setPlayer2Username(rs.getString("p2_user"));
                game.setWinnerUsername(rs.getString("winner_user"));
                games.add(game);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }
}
