package com.dmytro.mudrov.forum.dto.theme;

import com.dmytro.mudrov.forum.dto.general.BaseDTO;

public class CreateThemeDTO extends BaseDTO {

    private String name;
    private String description;
    private long owner;

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
}
