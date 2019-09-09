package 剑指offer;

import java.util.Stack;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-09 14:36
 * @Version 1.0
 */
public class 最小栈 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        if(minStack.isEmpty() || minStack.peek() > node){
            minStack.push(node);
        }
        stack.push(node);
    }

    public void pop() {
        if(minStack.peek() == stack.pop()){
            minStack.pop();
        }
    }

    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }
        return 0;
    }

    public int min() {
        if(!minStack.isEmpty()){
            return minStack.peek();
        }
        return 0;
    }
}
