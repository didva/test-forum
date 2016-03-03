package com.dmytro.mudrov.forum.server.handlers;

import com.dmytro.mudrov.forum.dto.general.BaseResponseDTO;
import com.dmytro.mudrov.forum.dto.general.GeneralResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.log4j.Logger;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.net.Socket;

public class RequestHandler implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(RequestHandler.class);

    private Dispatcher dispatcher;
    private Socket socket;

    public RequestHandler(Dispatcher dispatcher, Socket socket) {
        this.dispatcher = dispatcher;
        this.socket = socket;
    }

    public void run() {
        try {
            BaseResponseDTO response = dispatcher.dispatch(socket);
            writeResponse(socket, response);
        } catch (Exception e) {
            writeResponse(socket, new GeneralResponseDTO(false, e.getMessage()));
            LOGGER.warn(e);
        } finally {
            close(socket);
        }
    }

    private void close(Socket socket) {
        try {
            socket.close();
        } catch (Exception e) {
            LOGGER.warn(e);
        }
    }

    private void writeResponse(Socket socket, Object response) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            StringWriter stringWriter = new StringWriter();
            objectMapper.writeValue(stringWriter, response);
            String responseString = stringWriter.toString();

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeInt(responseString.length());
            dataOutputStream.writeChars(responseString);
        } catch (IOException e) {
            LOGGER.warn(e);
        }
    }
}
