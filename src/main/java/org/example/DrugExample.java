package org.example;

public class DrugExample {
    private  int id;
    private String ru_name;
    private String en_name;
    private int count;
    private boolean recipe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRu_name() {
        return ru_name;
    }

    public void setRu_name(String ru_name) {
        this.ru_name = ru_name;
    }

    public String getEn_name() {
        return en_name;
    }

    public void setEn_name(String en_name) {
        this.en_name = en_name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isRecipe() {
        return recipe;
    }

    public void setRecipe(boolean recipe) {
        this.recipe = recipe;
    }

    public DrugExample(int id, String ru_name, String en_name, int count, boolean recipe) {
        this.id = id;
        this.ru_name = ru_name;
        this.en_name = en_name;
        this.count = count;
        this.recipe = recipe;
    }

}
