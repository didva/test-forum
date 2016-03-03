package com.dmytro.mudrov.forum.server.controller.comment;

import com.dmytro.mudrov.forum.dto.comment.CreateCommentDTO;
import com.dmytro.mudrov.forum.dto.comment.CreateCommentResponseDTO;
import com.dmytro.mudrov.forum.server.controller.Controller;
import com.dmytro.mudrov.forum.server.model.Comment;
import com.dmytro.mudrov.forum.server.service.CommentService;

public class CreateCommentController implements Controller<CreateCommentDTO> {

    private CommentService commentService;

    @Override
    public CreateCommentResponseDTO process(CreateCommentDTO data) {
        Comment comment = commentService.create(data);
        return getCommentResponse(comment);
    }

    private CreateCommentResponseDTO getCommentResponse(Comment comment) {
        CreateCommentResponseDTO response = new CreateCommentResponseDTO();
        response.setId(comment.getId());
        response.setName(comment.getName());
        response.setDescription(comment.getDescription());
        response.setTheme(comment.getTheme());
        response.setOwner(comment.getOwner());
        return response;
    }

    @Override
    public Class<CreateCommentDTO> getDTOClass() {
        return CreateCommentDTO.class;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }
}
