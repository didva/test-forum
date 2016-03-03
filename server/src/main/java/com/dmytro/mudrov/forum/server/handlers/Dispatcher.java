package com.dmytro.mudrov.forum.server.handlers;

import com.dmytro.mudrov.forum.dto.general.BaseDTO;
import com.dmytro.mudrov.forum.dto.general.BaseResponseDTO;
import com.dmytro.mudrov.forum.dto.general.GeneralResponseDTO;
import com.dmytro.mudrov.forum.server.controller.Controller;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

public class Dispatcher {

    private Map<String, Controller<BaseDTO>> controllers;

    public BaseResponseDTO dispatch(Socket socket) throws Exception {
        String json = readJson(socket);
        String action = getAction(json);
        if (controllers != null) {
            Controller<BaseDTO> controller = controllers.get(action);
            if (controller != null) {
                BaseDTO baseDTO = getData(json, controller);
                return controller.process(baseDTO);
            }
        }
        return new GeneralResponseDTO(false, "Request mapping not found");
    }

    private BaseDTO getData(String json, Controller<BaseDTO> controller) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, controller.getDTOClass());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAction(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        BaseDTO baseDTO = objectMapper.readValue(json, BaseDTO.class);
        return baseDTO.getAction();
    }

    private String readJson(Socket socket) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        int size = dataInputStream.readInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            sb.append(dataInputStream.readChar());
        }
        return sb.toString();
    }

    public void setControllers(Map<String, Controller<BaseDTO>> controllers) {
        this.controllers = controllers;
    }

}
