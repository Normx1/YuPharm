package model;

public class Order {
    private int id_Order;
    private int id_Drug;
    private int id_User;
    private String drugName;
    private String userName;
    private int cost;
    private int count;
    private byte recipe;

    public int getId_Order() {
        return id_Order;
    }

    public void setId_Order(int id_Order) {
        this.id_Order = id_Order;
    }

    public int getId_Drug() {
        return id_Drug;
    }

    public void setId_Drug(int id_Drug) {
        this.id_Drug = id_Drug;
    }

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public byte getRecipe() {
        return recipe;
    }

    public void setRecipe(byte recipe) {
        this.recipe = recipe;
    }

    public Order() {
    }

    public Order(int id_Order, int id_Drug, int id_User, int cost, int count, byte recipe) {
        this.id_Order = id_Order;
        this.id_Drug = id_Drug;
        this.id_User = id_User;
        this.cost = cost;
        this.count = count;
        this.recipe = recipe;
    }

    public Order(int id_Order, int id_Drug, int id_User, String drugName, String userName, int cost, int count, byte recipe) {
        this.id_Order = id_Order;
        this.id_Drug = id_Drug;
        this.id_User = id_User;
        this.drugName = drugName;
        this.userName = userName;
        this.cost = cost;
        this.count = count;
        this.recipe = recipe;

    }
}
