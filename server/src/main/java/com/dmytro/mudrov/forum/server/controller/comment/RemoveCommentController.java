package com.dmytro.mudrov.forum.server.controller.comment;

import com.dmytro.mudrov.forum.dto.comment.RemoveCommentDTO;
import com.dmytro.mudrov.forum.dto.general.GeneralResponseDTO;
import com.dmytro.mudrov.forum.server.controller.Controller;
import com.dmytro.mudrov.forum.server.service.CommentService;

public class RemoveCommentController implements Controller<RemoveCommentDTO> {

    private CommentService commentService;

    @Override
    public GeneralResponseDTO process(RemoveCommentDTO data) {
        commentService.remove(data);
        return new GeneralResponseDTO(true);
    }

    @Override
    public Class<RemoveCommentDTO> getDTOClass() {
        return RemoveCommentDTO.class;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }
}
