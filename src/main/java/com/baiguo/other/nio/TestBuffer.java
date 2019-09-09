package com.baiguo.other.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * 缓冲区，在Nio中负责数据的存取，缓冲区就是数组
 *
 * 根据不同的类型提供了不同的缓冲区
 *  ByteBuffer  使用最多
 *  CharBuffer
 *  ShortBuffer
 *  IntBuffer
 *  LongBuffer
 *  FloatBuffer
 *  DoubleBuffer
 *
 *
 *  管理方式都一样，allocate()获取缓冲区
 *
 *  缓冲区存取数据的两个核心方法
 *  1.put() 存取缓冲区
 *  2.get() 获取缓冲区的数据
 *
 *  Buffer的四个核心属性
 *  capacity 容量。表示缓冲区中最大存储的容量，一旦声明不可以改变
 *  limit    界限 ，表示缓冲区中可以操作数据的大小(limit 后的数据是不可以进行读写的)
 *  position 位置 表示缓冲区中给正在操作数的位置
 *  mark     标记，可以记录position的位置，可以通过reset恢复到mark
 *
 *   0 <= mark <= position <= limit <= capacity
 *
 *
 * 直接缓冲区和非直接缓冲区
 *      非直接缓冲区: 通过allocate（）方法分配缓冲区，将缓冲区分配建立在JVM的内存中
 *      直接缓冲区：通过allocateDirect（） 分配直接缓冲区，将缓冲区建立在操作系统的物理内存中。可以提交效率
 *
 *
 *
 * @Author: BaoJian.Xu
 * @Date: 2019-07-20 22:22
 * @Version 1.0
 */
public class TestBuffer {

    @Test
    public void test3(){
        //分配直接缓冲区
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        System.out.println(buffer.isDirect());
    }

    @Test
    public void test2(){
        String str = "abcde";
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.put(str.getBytes());

        buffer.flip();

        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst,0,2);
        System.out.println(new String(dst,0,2));

        System.out.println(buffer.position());

        buffer.mark(); //mark = position = 2

        buffer.get(dst,2,2);
        System.out.println(new String(dst,2,2));
        System.out.println(buffer.position()); // postition = 4

        //reset
        buffer.reset(); // posistion = mark = 2
        System.out.println(buffer.position());
        //判断缓冲区是或否还有剩余的数据，
        if(buffer.hasRemaining()){
            //获取缓冲区可以操作的数据量
            System.out.println(buffer.remaining());
        }
    }

    @Test
    public void test1(){
        String str = "abcde";
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //分配一个指定大小的缓冲区
        print("allocate",buffer);

        //写入数据的模式
        buffer.put(str.getBytes());
        print("put",buffer);

        //切换到读取数据的模式
        buffer.flip();
        print("flip",buffer);

        //读取缓冲区中的数据
        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst);
        System.out.println(new String(dst,0,dst.length));
        print("get",buffer);

        //可重复读数据
        buffer.rewind();
        print("rewind",buffer);

        //clear 清空缓冲区,但是缓冲区中的数据依然存在，缓冲区中的数据处于一个被遗忘的状态
        buffer.clear();
        print("clear",buffer);

        System.out.println((char)buffer.get());
    }

    public static void print(String method,ByteBuffer buffer){
        System.out.println("----------"+method+"()-------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
    }
}
