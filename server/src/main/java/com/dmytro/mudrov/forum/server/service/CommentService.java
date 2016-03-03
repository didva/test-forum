package com.dmytro.mudrov.forum.server.service;

import com.dmytro.mudrov.forum.dto.comment.CreateCommentDTO;
import com.dmytro.mudrov.forum.dto.comment.RemoveCommentDTO;
import com.dmytro.mudrov.forum.server.dao.CommentDao;
import com.dmytro.mudrov.forum.server.model.Comment;

public class CommentService {

    private CommentDao commentDao;
    private ThemeService themeService;
    private UserService userService;

    public Comment create(CreateCommentDTO createCommentDTO) {
        if (userService.findUser(createCommentDTO.getOwner()) == null) {
            throw new IllegalArgumentException("Invalid user id!");
        }
        if (themeService.findTheme(createCommentDTO.getTheme()) == null) {
            throw new IllegalArgumentException("Invalid theme id!");
        }
        Comment comment = createComment(createCommentDTO);
        commentDao.save(comment);
        return comment;
    }

    public void remove(RemoveCommentDTO removeCommentDTO) {
        if (userService.findUser(removeCommentDTO.getRemoverId()) == null) {
            throw new IllegalArgumentException("Invalid user id!");
        }
        commentDao.remove(removeCommentDTO.getId());
    }

    private Comment createComment(CreateCommentDTO createCommentDTO) {
        Comment comment = new Comment();
        comment.setDescription(createCommentDTO.getDescription());
        comment.setName(createCommentDTO.getName());
        comment.setTheme(createCommentDTO.getTheme());
        comment.setOwner(createCommentDTO.getOwner());
        return comment;
    }

    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public void setThemeService(ThemeService themeService) {
        this.themeService = themeService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
