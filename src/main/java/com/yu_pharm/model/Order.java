package com.yu_pharm.model;

public class Order<T, T1> {
    private int id_Order;
    private T drug;
    private T1 user;
    private int cost;
    private int count;

    public int getId_Order() {
        return id_Order;
    }

    public void setId_Order(int id_Order) {
        this.id_Order = id_Order;
    }

    public T getDrug() {
        return drug;
    }

    public void setDrug(T drug) {
        this.drug = drug;
    }

    public T1 getUser() {
        return user;
    }

    public void setUser(T1 user) {
        this.user = user;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Order(int id_Order) {
        this.id_Order = id_Order;
    }

    public Order(int id_Order, T drug, T1 user) {
        this.id_Order = id_Order;
        this.drug = drug;
        this.user = user;
    }

    public Order(int id_Order, T drug, T1 user, int cost) {
        this.id_Order = id_Order;
        this.drug = drug;
        this.user = user;
        this.cost = cost;
    }

    public Order() {
    }

    public Order(int id_Order, T drug, T1 user, int cost, int count) {
        this.id_Order = id_Order;
        this.drug = drug;
        this.user = user;
        this.cost = cost;
        this.count = count;
    }
}
