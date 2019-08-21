package com.jiaflu.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */

public class IOServer {
    public static void main(String[] args) throws IOException {
        // 服务端处理客户端连接请求
        ServerSocket serverSocket = new ServerSocket(3333);
        new Thread(() -> {
            while (true) {
                try {
                    // 阻塞方法获取新得连接(只在获得新连接得时候阻塞一下)
                    Socket socket = serverSocket.accept();

                    // 每一个新得连接都创建一个线程，负责读取数据
                    new Thread(() -> {
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            // 按字节流方式读取数据
                            while ((len = inputStream.read(data)) != -1) {
                                System.out.println(new String(data, 0, len));
                            }
                            Thread.sleep(2000);
                        } catch (IOException | InterruptedException e) {

                        }
                    }).start();
                } catch (IOException e) {

                }
            }
        }).start();
    }
}
