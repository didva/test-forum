package com.dmytro.mudrov.forum.dto.theme;

import com.dmytro.mudrov.forum.dto.general.BaseResponseDTO;

public class CreateThemeResponseDTO extends BaseResponseDTO {

    private long id;
    private String name;
    private String description;
    private long owner;

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

    @Override
    public String toString() {
        return "CreateThemeResponseDTO{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", description='" + description + '\'' +
               ", owner=" + owner +
               '}';
    }
}
