package com.dmytro.mudrov.forum.server.handlers;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Server extends Thread {

    private static final Logger LOGGER = Logger.getLogger(Server.class);

    private int threadCount;
    private int port;
    private ExecutorService executorService;
    private Dispatcher dispatcher;

    public void run() {
        try {
            executorService = Executors.newFixedThreadPool(threadCount);
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                RequestHandler requestHandler = getRequestHandler(dispatcher, socket);
                executorService.submit(requestHandler);
            }
        } catch (InterruptedIOException e) {
            LOGGER.info("Server stopped!");
        } catch (IOException e) {
            LOGGER.warn(e);
        }
    }

    public void shutdown() {
        executorService.shutdown();
        Thread.currentThread().interrupt();
    }

    protected abstract RequestHandler getRequestHandler(Dispatcher dispatcher, Socket socket);

    public void setPort(int port) {
        this.port = port;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }
}
