package com.example.finalproject;

import java.util.ArrayList;

public class myGameData
{
    private String gameTitle;
    private String gamePublisher;
    private int gamePrice;
    public myGameData()
    {

    }

    public myGameData(String gameTitle, String gamePublisher, int gamePrice)
    {
        this.gameTitle = gameTitle;
        this.gamePublisher = gamePublisher;
        this.gamePrice = gamePrice;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getGamePublisher() {
        return gamePublisher;
    }

    public void setGamePublisher(String gamePublisher) {
        this.gamePublisher = gamePublisher;
    }

    public int getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(int gamePrice) {
        this.gamePrice = gamePrice;
    }
}
