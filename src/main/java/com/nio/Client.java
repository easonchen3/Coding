package com.nio;

import java.io.IOException;
import java.net.Socket;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-10 13:51
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8080);
        socket.getOutputStream().write("111".getBytes());
        socket.close();
    }
}
