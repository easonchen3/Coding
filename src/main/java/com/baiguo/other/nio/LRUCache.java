package com.baiguo.other.nio;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-07-21 20:52
 * @Version 1.0
 */
public class LRUCache {

    private LinkedHashMap<Integer,Integer> cache ;

    public LRUCache(int capacity){
        cache = new LinkedHashMap<Integer,Integer>(1,1.0f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size()>capacity;
            }
        };
    }

    public int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
       return  cache.get(key);
    }

    public void put(int key,int value){
        cache.put(key,value);
    }
}
