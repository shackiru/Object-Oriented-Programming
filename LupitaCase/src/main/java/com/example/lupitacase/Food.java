package com.example.lupitacase;

public class Food
{
    protected String foodID;
    protected String foodName;
    protected int foodPrice;
    protected int foodQuantity;
    public Food()
    {

    }
    public Food(String foodID, String foodName, int foodPrice, int foodQuantity)
    {
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodQuantity = foodQuantity;
    }

    public String getFoodID()
    {
        return foodID;
    }
    public void setFoodID(String foodID)
    {
        this.foodID = foodID;
    }
    public String getFoodName()
    {
        return foodName;
    }
    public void setFoodName(String foodName)
    {
        this.foodName = foodName;
    }
    public int getFoodPrice()
    {
        return foodPrice;
    }
    public void setFoodPrice(int foodPrice)
    {
        this.foodPrice = foodPrice;
    }
    public int getFoodQuantity()
    {
        return foodQuantity;
    }
    public void setFoodQuantity(int foodQuantity)
    {
        this.foodQuantity = foodQuantity;
    }
}
