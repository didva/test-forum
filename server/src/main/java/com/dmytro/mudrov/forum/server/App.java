package com.dmytro.mudrov.forum.server;

import com.dmytro.mudrov.forum.server.handlers.Server;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        try {
            Server server = context.getBean(Server.class);
            server.join();
        } catch (InterruptedException e) {
            context.close();
            LOGGER.warn(e);
        }
    }

}
