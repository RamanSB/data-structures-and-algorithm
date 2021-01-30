package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Stack {

    int nElems;
    int maxSize;
    int top;
    int[] array;

    Stack(int maxSize){
        nElems = 0;
        top = -1;
        if(maxSize>=0) {
            this.maxSize = maxSize;
            array = new int[this.maxSize];
        }
    }

    int peek(){
        return array[top];
    }

    void push(int elem){
        if(top+1 >= this.maxSize){
            top=-1;
        }
        nElems++;
        array[++top] = elem;
    }

    int pop(){
        return array[top--];
    }

    @Override
    public String toString(){
        return Arrays.toString(array) + " | top = " + this.top;
    }

    public static void main(String[] args){
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(40);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);

        Stack stackX = new Stack(3);
        stackX.push(40);
        System.out.println(stackX);
        stackX.push(20);
        System.out.println(stackX);
        stackX.push(30);
        System.out.println(stackX);
        System.out.println(stackX.peek());
        stackX.pop();
        System.out.println(stackX);
        stackX.push(35);
        System.out.println(stackX);

    }
}
