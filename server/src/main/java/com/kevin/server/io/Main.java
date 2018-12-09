package com.kevin.server.io;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author kevin
 * @date 2018/12/9
 * @since 0.1.0
 **/
@Slf4j
public class Main {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        log.warn("server start in 9999");
        Socket client = serverSocket.accept();
        log.warn("I get a client from "+client.getInetAddress());
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        String request,response;
        while ((request = reader.readLine())!=null){
            if ("Done".equals(request)){
                log.warn("client disconnect");
                break;
            }
            response = "I receive "+request;
            log.warn(response + "-------");
            out.println(response);
        }
    }
}
