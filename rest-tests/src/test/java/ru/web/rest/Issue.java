package ru.web.rest;

/**
 * Created by Радочка on 15.11.2016.
 */
public class Issue {
    private int id;
    private String description;

    public int getId() {
        return id;
    }

    public Issue withId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Issue withDescription(String description) {
        this.description = description;
        return this;
    }
}
