package LeetCode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-15 13:32
 * @Version 1.0
 */
public class LRUCache {
    LinkedList<Node> cache;
    int capacity;
    public LRUCache(int capacity){
        this.cache = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key){
        Iterator<Node> nodeIterator = cache.descendingIterator();
        int result = -1;
        while(nodeIterator.hasNext()){
            Node node = nodeIterator.next();
            if(node.key == key){
                result = node.val;
                nodeIterator.remove();
                put(key,result);
                break;
            }
        }
        return result;
    }

    public void put(int key,int val){
        Iterator<Node> iterator = cache.iterator();
        while(iterator.hasNext()){
            Node node = iterator.next();
            if(node.key == key){
                iterator.remove();
                break;
            }
        }

        if(capacity == cache.size()){
            cache.removeFirst();
        }
        cache.add(new Node(key,val));
    }

}
class Node{
    int key;
    int val;
    Node (int key,int val){
        this.key = key;
        this.val = val;
    }
}
