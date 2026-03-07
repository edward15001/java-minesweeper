package com.minesweeper.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String role; // "ADMIN" or "USER"
    private int minesFound;
    private int gamesPlayed;
    private int gamesWon;

    public User(int id, String username, String password, String role, int minesFound, int gamesPlayed, int gamesWon) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.minesFound = minesFound;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public int getMinesFound() {
        return minesFound;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setMinesFound(int minesFound) {
        this.minesFound = minesFound;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    @Override
    public String toString() {
        return username; // Helpful for displaying in UI lists/comboboxes
    }
}
