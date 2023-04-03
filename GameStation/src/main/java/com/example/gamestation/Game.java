package com.example.gamestation;

public class Game
{
    protected String gameID;
    protected String gameName;
    protected String gameType;
    protected String gamePlatform;
    protected double gamePrice;
    protected int gameQuantity;

    public Game()
    {

    }

    public Game(String gameID, String gameName, String gameType, String gamePlatform, double gamePrice, int gameQuantity)
    {
        this.gameID = gameID;
        this.gameName = gameName;
        this.gameType = gameType;
        this.gamePlatform = gamePlatform;
        this.gamePrice = gamePrice;
        this.gameQuantity = gameQuantity;
    }
    
    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getGamePlatform() {
        return gamePlatform;
    }

    public void setGamePlatform(String gamePlatform) {
        this.gamePlatform = gamePlatform;
    }

    public double getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(double gamePrice) {
        this.gamePrice = gamePrice;
    }

    public int getGameQuantity() {
        return gameQuantity;
    }

    public void setGameQuantity(int gameQuantity) {
        this.gameQuantity = gameQuantity;
    }
}
