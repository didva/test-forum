package com.dmytro.mudrov.forum.server.dao;

import com.dmytro.mudrov.forum.server.model.Comment;

public interface CommentDao {

    long save(Comment comment);

    void remove(long id);

    Comment find(long id);

}
