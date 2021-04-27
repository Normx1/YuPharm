package model;

public class Drug {
    private int id;
    private String name;
    private int cost;
    private int count;
    private byte recipe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Drug(int id, String name, int cost, int count, byte recipe) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.count = count;
        this.recipe = recipe;
    }

    public Drug() {
    }

    public Drug(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Drug(String name, int cost, int count, byte recipe) {
        this.name = name;
        this.cost = cost;
        this.count = count;
        this.recipe = recipe;

    }
}
