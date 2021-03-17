package org.example;

public class SimpleMedicine implements Medicine {

    private final String id;


    public SimpleMedicine(String id) {
        this.id = id;
    }


    @Override
    public String id() {
        return id;
    }
}
