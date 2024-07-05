package com.example.finalproject;

public class Game {
    private String id;
    private String gameName;
    private String genre;
    private int quan;
    private int gamePrice;
    private String publisher;

    public Game() {
        // TODO Auto-generated constructor stub
    }

    public Game(String id, String gameName, String genre, int quan, int gamePrice, String publisher) {
        super();
        this.id = id;
        this.gameName = gameName;
        this.genre = genre;
        this.quan = quan;
        this.gamePrice = gamePrice;
        this.publisher = publisher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getQuan() {
        return quan;
    }

    public void setQuan(int quan) {
        this.quan = quan;
    }

    public int getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(int gamePrice) {
        this.gamePrice = gamePrice;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


}
