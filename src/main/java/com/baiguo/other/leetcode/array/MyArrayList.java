package com.baiguo.other.leetcode.array;

/**
 * 手写ArrayList
 * 通过数组来实现的
 *
 * @Author: BaoJian.Xu
 * @Date: 2019-07-20 13:57
 * @Version 1.0
 */
public class MyArrayList {

    //基本的数据类型，来保存数据
    private Object[] elementData;

    //数组的长度
    private int size;

    public MyArrayList(){
         elementData = new Object[10];
    }

    public void add(Object obj){
        if(size >= elementData.length){
            Object[] temp = new Object[elementData.length * 2];
            System.arraycopy(elementData,0,temp,0,size);
            elementData = temp;
        }
        elementData[size++] = obj;
    }

}
