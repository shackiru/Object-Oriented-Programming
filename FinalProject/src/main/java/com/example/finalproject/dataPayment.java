package com.example.finalproject;

public class dataPayment
{
    private String idPayment;
    private int price;
    private int totalPrice;
    private int quantity;

    public dataPayment()
    {

    }

    public dataPayment(String idPayment, int price, int totalPrice, int quantity) {
        this.idPayment = idPayment;
        this.price = price;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
    }

    public String getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(String idPayment) {
        this.idPayment = idPayment;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
