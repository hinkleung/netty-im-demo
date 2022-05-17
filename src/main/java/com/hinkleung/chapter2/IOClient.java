package com.hinkleung.chapter2;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write((new Date() + ": hello world").getBytes(StandardCharsets.UTF_8));
                        Thread.sleep(2000);
                    } catch (Exception e) {

                    }
                }
            } catch (Exception e) {

            }
        }).start();

    }

}
