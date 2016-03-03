package com.dmytro.mudrov.forum.client;

import com.dmytro.mudrov.forum.dto.comment.CreateCommentDTO;
import com.dmytro.mudrov.forum.dto.comment.CreateCommentResponseDTO;
import com.dmytro.mudrov.forum.dto.comment.RemoveCommentDTO;
import com.dmytro.mudrov.forum.dto.general.GeneralResponseDTO;
import com.dmytro.mudrov.forum.dto.theme.CreateThemeDTO;
import com.dmytro.mudrov.forum.dto.theme.CreateThemeResponseDTO;
import com.dmytro.mudrov.forum.dto.theme.RemoveThemeDTO;
import com.dmytro.mudrov.forum.dto.user.UserDTO;
import com.dmytro.mudrov.forum.dto.user.UserResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.net.Socket;

public class ForumClient {

    private String host;
    private int port;

    public ForumClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public CreateCommentResponseDTO createComment(CreateCommentDTO createCommentDTO) throws IOException {
        String json = getJson(createCommentDTO);
        String response = executeRequest(json);
        return new ObjectMapper().readValue(response, CreateCommentResponseDTO.class);
    }

    public GeneralResponseDTO removeComment(RemoveCommentDTO removeCommentDTO) throws IOException {
        String json = getJson(removeCommentDTO);
        String response = executeRequest(json);
        return new ObjectMapper().readValue(response, GeneralResponseDTO.class);
    }

    public CreateThemeResponseDTO createTheme(CreateThemeDTO createThemeDTO) throws IOException {
        String json = getJson(createThemeDTO);
        String response = executeRequest(json);
        return new ObjectMapper().readValue(response, CreateThemeResponseDTO.class);
    }

    public GeneralResponseDTO removeTheme(RemoveThemeDTO removeThemeDTO) throws IOException {
        String json = getJson(removeThemeDTO);
        String response = executeRequest(json);
        return new ObjectMapper().readValue(response, GeneralResponseDTO.class);
    }

    public UserResponseDTO createUser(UserDTO userDTO) throws IOException {
        String json = getJson(userDTO);
        String response = executeRequest(json);
        return new ObjectMapper().readValue(response, UserResponseDTO.class);
    }

    private String getJson(Object data) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();
        objectMapper.writeValue(stringWriter, data);
        return stringWriter.toString();
    }

    private String executeRequest(String json) throws IOException {
        Socket socket = new Socket(host, port);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        out.writeInt(json.length());
        out.writeChars(json);
        int size = dataInputStream.readInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            sb.append(dataInputStream.readChar());
        }
        return sb.toString();
    }

}
