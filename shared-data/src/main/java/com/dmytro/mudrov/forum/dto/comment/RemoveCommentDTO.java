package com.dmytro.mudrov.forum.dto.comment;

import com.dmytro.mudrov.forum.dto.general.BaseDTO;

public class RemoveCommentDTO extends BaseDTO {

    private long id;
    private long removerId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRemoverId() {
        return removerId;
    }

    public void setRemoverId(long removerId) {
        this.removerId = removerId;
    }
}
