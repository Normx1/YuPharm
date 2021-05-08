package com.yu_pharm.model;

public class Drug {
    private int id;
    private String name;
    private int cost;
    private int count;
    private byte recipe;
    private String description;
    private String application;
    private String main_action;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getMain_action() {
        return main_action;
    }

    public void setMain_action(String main_action) {
        this.main_action = main_action;
    }

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
    public Drug(int id, String name, int cost, int count, byte recipe, String description, String application, String main_action) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.count = count;
        this.recipe = recipe;
        this.description = description;
        this.application = application;
        this.main_action = main_action;
    }

    public Drug(String name, int cost, int count, byte recipe, String main_action, String description, String application) {
        this.name = name;
        this.cost = cost;
        this.count = count;
        this.recipe = recipe;
        this.description = description;
        this.application = application;
        this.main_action = main_action;
    }
}
