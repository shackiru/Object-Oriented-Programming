package com.example.finalproject;

public class User {
    private String username;
    private String password;
    private String member;
    private int balance;

    public User() {
        // TODO Auto-generated constructor stub
    }



    public User(String username, String password, String member, int balance) {
        super();
        this.username = username;
        this.password = password;
        this.member = member;
        this.balance = balance;
    }



    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public String getMember() {
        return member;
    }



    public void setMember(String member) {
        this.member = member;
    }



    public int getBalance() {
        return balance;
    }



    public void setBalance(int balance) {
        this.balance = balance;
    }






}