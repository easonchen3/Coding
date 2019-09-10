package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-10 14:00
 * @Version 1.0
 */
public class NioServer {
    private static byte[] buffer = new byte[1024];
    private static List<SocketChannel> list = new ArrayList<>();
    private static ByteBuffer byteBuffer = ByteBuffer.allocate(512);

    public static void main(String[] args){
        //serverSocketChannel 和 serverSocket差不多，只是提供了设置非阻塞的接口
        //Socket和socketChannel原理和上面的类似
        try{
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));
            serverSocketChannel.configureBlocking(false);

            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (serverSocketChannel == null) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(" no conn ! ");

                    readData();
                } else {
                    System.out.println(" conned ");
                    socketChannel.configureBlocking(false);
                    list.add(socketChannel);
                    readData();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void readData() throws IOException {
        for (SocketChannel channel : list) {
            int read = channel.read(byteBuffer);
            if (read > 0) {
                byteBuffer.flip();
                String s = byteBuffer.toString();
                System.out.println("s = " + s);
            }
        }
    }
}
