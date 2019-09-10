package com.nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-10 13:48
 * @Version 1.0
 */
public class Server {

    private static byte[] buffer = new byte[1024];

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8080));

        Socket socket = serverSocket.accept();
        int read = socket.getInputStream().read(buffer);
        System.out.println(new String(buffer,0,read));
    }
}
