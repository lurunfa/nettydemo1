package com.kevin.client.io;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author kevin
 * @date 2018/12/9
 * @since 0.1.0
 **/
@Slf4j
public class Main {

    public static void main(String[] args) throws Exception{
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(9999));
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);

        for (int i = 0; i < 20; i++) {
            printWriter.println("hello ");
            String response;
            if ((response = reader.readLine())!=null){
                log.warn("response from server "+response);
            }
            Thread.sleep(2000);
        }
        printWriter.print("Done ");
        log.warn("done");


    }
}
