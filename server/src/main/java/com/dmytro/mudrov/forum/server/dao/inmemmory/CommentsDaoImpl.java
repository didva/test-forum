package com.dmytro.mudrov.forum.server.dao.inmemmory;

import com.dmytro.mudrov.forum.server.dao.CommentDao;
import com.dmytro.mudrov.forum.server.model.Comment;

import java.util.HashMap;
import java.util.Map;

public class CommentsDaoImpl implements CommentDao {

    private static long id = 0;
    private Map<Long, Comment> commentsMap = new HashMap<>();

    @Override
    public synchronized long save(Comment comment) {
        if (comment.getId() == 0) {
            comment.setId(++id);
        }
        commentsMap.put(comment.getId(), comment);
        return comment.getId();
    }

    @Override
    public synchronized void remove(long id) {
        commentsMap.remove(id);
    }

    @Override
    public Comment find(long id) {
        return commentsMap.get(id);
    }
}
