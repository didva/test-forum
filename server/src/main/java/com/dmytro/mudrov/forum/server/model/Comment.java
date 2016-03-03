package com.dmytro.mudrov.forum.server.model;

public class Comment {

    private long id;
    private String name;
    private String description;
    private long owner;
    private long theme;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getOwner() {
        return owner;
    }

    public void setOwner(long owner) {
        this.owner = owner;
    }

    public long getTheme() {
        return theme;
    }

    public void setTheme(long theme) {
        this.theme = theme;
    }
}
