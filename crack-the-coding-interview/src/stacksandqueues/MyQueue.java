package stacksandqueues;

import java.util.Stack;

public class MyQueue<T> {

    Stack<T> initialStack;
    Stack<T> popStack;

    MyQueue(){
        initialStack = new Stack<>();
        popStack = new Stack<>();
    }

    /*
        Removes element from front of queue
     */
    T poll(){
        if(initialStack.isEmpty() && popStack.isEmpty()){
            return null;
        }
        while(!initialStack.isEmpty()){
            popStack.push(initialStack.pop());
        }
        T frontEndItemToPoll = popStack.pop();
        return frontEndItemToPoll;
    }

    void offer(T t){
        if(popStack.isEmpty()){
            initialStack.push(t);
        }else{
            while(!popStack.isEmpty()) {
                initialStack.push(popStack.pop());
            }
            initialStack.push(t);
        }
    }

    public static void main(String[] args){
        MyQueue<Integer> queue = new MyQueue<>();
        queue.offer(5);
        queue.offer(10);
        queue.offer(15);
        queue.offer(1);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue);
        queue.offer(42);
        queue.offer(80);
        queue.offer(9);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue);
    }

    @Override
    public String toString(){
        return String.format("S1: %s \ns2: %s", initialStack, popStack);
    }

}
