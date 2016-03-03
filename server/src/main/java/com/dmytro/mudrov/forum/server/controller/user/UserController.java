package com.dmytro.mudrov.forum.server.controller.user;

import com.dmytro.mudrov.forum.dto.user.UserDTO;
import com.dmytro.mudrov.forum.dto.user.UserResponseDTO;
import com.dmytro.mudrov.forum.server.controller.Controller;
import com.dmytro.mudrov.forum.server.model.User;
import com.dmytro.mudrov.forum.server.service.UserService;

public class UserController implements Controller<UserDTO> {

    private UserService userService;

    public UserResponseDTO process(UserDTO data) {
        User user = userService.saveOrUpdate(data);
        return getUserResponse(user);
    }

    private UserResponseDTO getUserResponse(User user) {
        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setSurname(user.getSurname());
        response.setEmail(user.getEmail());
        response.setAmount(user.getAmount());
        return response;
    }

    public Class<UserDTO> getDTOClass() {
        return UserDTO.class;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
