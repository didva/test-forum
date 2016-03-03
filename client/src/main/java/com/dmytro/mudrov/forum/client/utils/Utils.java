package com.dmytro.mudrov.forum.client.utils;

import com.dmytro.mudrov.forum.dto.comment.CreateCommentDTO;
import com.dmytro.mudrov.forum.dto.comment.RemoveCommentDTO;
import com.dmytro.mudrov.forum.dto.theme.CreateThemeDTO;
import com.dmytro.mudrov.forum.dto.theme.RemoveThemeDTO;
import com.dmytro.mudrov.forum.dto.user.UserDTO;

public final class Utils {

    private Utils() {
    }

    public static UserDTO getUserDTO(String name, String surname, String email, String pwd, double amount) {
        UserDTO userDTO = new UserDTO();
        userDTO.setAction("register");
        userDTO.setName(name);
        userDTO.setSurname(surname);
        userDTO.setEmail(email);
        userDTO.setPassword(pwd);
        userDTO.setAmount(amount);
        return userDTO;
    }

    public static CreateThemeDTO getCreateThemeDTO(String name, String description, long owner) {
        CreateThemeDTO createThemeDTO = new CreateThemeDTO();
        createThemeDTO.setAction("create-theme");
        createThemeDTO.setName(name);
        createThemeDTO.setDescription(description);
        createThemeDTO.setOwner(owner);
        return createThemeDTO;
    }

    public static RemoveThemeDTO getRemoveThemeDTO(long id, long removerId) {
        RemoveThemeDTO removeThemeDTO = new RemoveThemeDTO();
        removeThemeDTO.setAction("remove-theme");
        removeThemeDTO.setId(id);
        removeThemeDTO.setRemoverId(removerId);
        return removeThemeDTO;
    }

    public static CreateCommentDTO getCreateCommentDTO(String name, String description, long theme, long owner) {
        CreateCommentDTO createCommentDTO = new CreateCommentDTO();
        createCommentDTO.setAction("create-comment");
        createCommentDTO.setName(name);
        createCommentDTO.setDescription(description);
        createCommentDTO.setTheme(theme);
        createCommentDTO.setOwner(owner);
        return createCommentDTO;
    }

    public static RemoveCommentDTO getRemoveCommentDTO(long id, long removerId) {
        RemoveCommentDTO removeCommentDTO = new RemoveCommentDTO();
        removeCommentDTO.setAction("remove-comment");
        removeCommentDTO.setId(id);
        removeCommentDTO.setRemoverId(removerId);
        return removeCommentDTO;
    }
}
