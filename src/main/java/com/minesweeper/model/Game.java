package com.minesweeper.model;

import java.sql.Timestamp;

public class Game {
    private int id;
    private Timestamp date;
    private int player1Id;
    private int player2Id;
    private int player1Score;
    private int player2Score;
    private Integer winnerId;

    // Additional helpful properties not strictly mapped one to one, but useful for
    // views:
    private String player1Username;
    private String player2Username;
    private String winnerUsername;

    public Game(int id, Timestamp date, int player1Id, int player2Id, int player1Score, int player2Score,
            Integer winnerId) {
        this.id = id;
        this.date = date;
        this.player1Id = player1Id;
        this.player2Id = player2Id;
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.winnerId = winnerId;
    }

    public int getId() {
        return id;
    }

    public Timestamp getDate() {
        return date;
    }

    public int getPlayer1Id() {
        return player1Id;
    }

    public int getPlayer2Id() {
        return player2Id;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public Integer getWinnerId() {
        return winnerId;
    }

    public String getPlayer1Username() {
        return player1Username;
    }

    public void setPlayer1Username(String player1Username) {
        this.player1Username = player1Username;
    }

    public String getPlayer2Username() {
        return player2Username;
    }

    public void setPlayer2Username(String player2Username) {
        this.player2Username = player2Username;
    }

    public String getWinnerUsername() {
        return winnerUsername;
    }

    public void setWinnerUsername(String winnerUsername) {
        this.winnerUsername = winnerUsername;
    }
}
