package com.baiguo.other.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.SortedMap;

/**
 * 通道：用于源节点和目标结点的连接，在NIO中通道是负责数据的传输，通道本神不存储数据，需要配合缓冲区使用
 *
 * 通道的实现类
 *  java.nio.channels.Channnel接口
 *      \--FileChannel  本地
 *      \--SocketChannel 网络tcp
 *      \--ServerChannel  网络tcp
 *      \--DategramChannel 网络udp
 *
 *  获取通道
 *      1.Java针对支持通道的类提供了getChannel()方法
 *          本地IO ：FileInputStream/FileOutputStream
 *                  RandomAccessFile
 *          网络IO：
 *              Socket，ServerSocket，DatagramSocket
 *
 *      2.jdk 1.7 中的NIO2 针对各个通道提供了一个静态方法open()方法
 *      3.jdk 1.7 中的NIO2 的Files 工具类中的newByteChannel()方法
 *
 * 通道之间的数据传输
 *  transferFrom()
 *  transferTo()
 *
 *  分散Scatter 于聚集 Gather
 *      分散读取（Scattering Reads） 将通道的数据分散到多个缓冲区中
 *      聚集写入(Gathering Writes)   将多个缓冲区中的数据聚集到一个通道中去
 *
 * @Author: BaoJian.Xu
 * @Date: 2019-07-21 10:52
 * @Version 1.0
 */
public class TestChannel {

    @Test
    public void test5(){
        SortedMap<String, Charset> map = Charset.availableCharsets();
        map.entrySet().stream().forEach(System.out::println);
    }

    @Test
    public void test4() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("e:/1.txt","rw");

        FileChannel channel = raf1.getChannel();

        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);
        ByteBuffer[] bufs = {buf1,buf2};

        channel.read(bufs);

        for (ByteBuffer byteBuffer:bufs){
            byteBuffer.flip();
        }
        System.out.println(new String(bufs[0].array(),0,buf1.limit()));
        System.out.println("-------------------------------");
        System.out.println(new String(bufs[1].array(),0,buf2.limit()));

        RandomAccessFile raf2 = new RandomAccessFile("e:/2.txt","rw");
        FileChannel channel2 = raf2.getChannel();

        channel2.write(bufs);
    }

    //通道之间的数据传输  直接缓冲区的方式
    @Test
    public void test3(){

        FileChannel inchannel = null;
        FileChannel outchannel = null;
        try {
            inchannel = FileChannel.open(Paths.get("e:/ss.mp4"),StandardOpenOption.READ);
            outchannel = FileChannel.open(Paths.get("e:/1.mp4"),StandardOpenOption.WRITE,StandardOpenOption.CREATE_NEW);

            //inchannel.transferTo(0,inchannel.size(),outchannel);
            outchannel.transferFrom(inchannel,0,inchannel.size());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inchannel!=null){
                try{
                    inchannel.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(outchannel!=null){
                try{
                    outchannel.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    //直接使用缓冲区完成文件的复制 内存映射文件
    @Test
    public void test2(){
        long start = System.currentTimeMillis();

        FileChannel inchannel = null;
        FileChannel outchannel = null;
        try {
            inchannel = FileChannel.open(Paths.get("E:/ss.mp4"), StandardOpenOption.READ);
            outchannel = FileChannel.open(Paths.get("E:/2.mp4"), StandardOpenOption.WRITE,StandardOpenOption.READ);

            //内存映射文件
            MappedByteBuffer inMapBuffer = inchannel.map(FileChannel.MapMode.READ_ONLY, 0, inchannel.size());
            MappedByteBuffer outMapBuffer = outchannel.map(FileChannel.MapMode.READ_WRITE, 0, inchannel.size());

            byte[] dst = new byte[inMapBuffer.limit()];
            inMapBuffer.get(dst);
            outMapBuffer.put(dst);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inchannel!=null){
                try{
                   inchannel.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(outchannel!=null){
                try{
                   outchannel.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start));
    }

    //1 利用通道完成文件的复制(非直接缓冲区)
    @Test
    public void test1() throws FileNotFoundException {

        long start = System.currentTimeMillis();

        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream("E:/ss.mp4");
            fos = new FileOutputStream("E:/1.mp4");

            //获取通道
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            //分配非直接缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            //将通道的数据存入缓冲区中
            while(inChannel.read(buffer)!=-1){
                buffer.flip(); //切换到读取数据的模式
                //将缓冲区的数据写入通道
                outChannel.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outChannel != null){
                try{
                    outChannel.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(inChannel != null){
                try{
                   inChannel.close(); 
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try{
                   fos.close(); 
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(fis!=null){
                try{
                   fis.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start));
    }
}
