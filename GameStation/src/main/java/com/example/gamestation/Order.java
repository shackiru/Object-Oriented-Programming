package com.example.gamestation;

public class Order
{
    private String idOrder;
    private double orderPrice;
    private String orderStatus;

    private int orderQuantity;

    public Order()
    {

    }

    public Order(String idOrder, double orderPrice, String orderStatus, int orderQuantity)
    {
        this.idOrder = idOrder;
        this.orderPrice = orderPrice;
        this.orderStatus = orderStatus;
        this.orderQuantity = orderQuantity;
    }

    public String getIdOrder()
    {
        return idOrder;
    }

    public void setIdOrder(String idOrder)
    {
        this.idOrder = idOrder;
    }

    public double getOrderPrice()
    {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice)
    {
        this.orderPrice = orderPrice;
    }

    public String getOrderStatus()
    {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    public int getOrderQuantity()
    {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity)
    {
        this.orderQuantity = orderQuantity;
    }
}
