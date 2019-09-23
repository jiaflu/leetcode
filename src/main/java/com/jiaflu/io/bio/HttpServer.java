package com.jiaflu.io.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class HttpServer {

    public static void main(String[] args) {

        try {
            int TCP_PORT = 9090;

            ServerSocket ss = new ServerSocket(TCP_PORT);
            Socket socket = ss.accept();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String buffer = null;
            while ((buffer = br.readLine()) != null && !buffer.equals("")) {
                System.out.println(buffer);
            }

            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            bw.write("HTTP/1.1 200 OK\n");
            bw.write("Content-Type: text/html; charset=UTF-8\n\n");
            bw.write("<html>\n" + "<head>\n" + "    <title>first page</title>\n"
                    + "</head>\n" + "<body>\n" + "    <h1>Hello Web Server!</h1>\n"
                    + "</body>\n" + "</html>\n");
            bw.flush();
            bw.close();

            br.close();
            socket.close();
            ss.close();
        } catch (IOException e) {
            System.out.println("Error binding the specified port.");
        }
    }
}
