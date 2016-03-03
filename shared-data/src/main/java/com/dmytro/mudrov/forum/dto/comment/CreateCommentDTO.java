package com.dmytro.mudrov.forum.dto.comment;

import com.dmytro.mudrov.forum.dto.general.BaseDTO;

public class CreateCommentDTO extends BaseDTO {

    private String name;
    private String description;
    private long owner;
    private long theme;

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
