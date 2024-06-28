package stacksandqueues;

import java.util.Arrays;

public class StackMin {

    int top;
    StackNode[] array;
    int size;
    int minimum; //This will be used to keep track of the minimum in the stack

    StackMin(int capacity){
        this.array = new StackNode[capacity];
        int size = 0;
        top = -1;
    }

    void push(StackNode node){
        if(top==this.array.length-1 || size==this.array.length){
            throw new ArrayIndexOutOfBoundsException("At max capacity");
        }
        if(size==0 || top==-1){
            node.localMinimum = node.data;
            this.minimum = node.localMinimum;
        }else if(node.data < this.minimum){
            node.localMinimum = node.data;
            this.minimum = node.localMinimum;
        } else {
            node.localMinimum = this.minimum;
        }
        size++;
        array[++top] = node;
    }

    StackNode pop(){
        if(size==0 || top==-1){
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        }
        size--;
        return array[top--];
    }


    int getMinimum(){
        return array[top].localMinimum;
    }

    public static void main(String[] args){
        StackMin stack = new StackMin(10);
        stack.push(new StackNode( 30));
        stack.push(new StackNode( 12));
        System.out.println(stack.getMinimum());
        stack.push(new StackNode( 21));
        stack.push(new StackNode( 19));
        stack.push(new StackNode( 17));
        System.out.println(stack.getMinimum());
        stack.push(new StackNode( 10));
        System.out.println(stack.getMinimum());
        stack.push(new StackNode(9));
        System.out.println(stack.getMinimum());
        stack.pop();
        stack.pop();
        System.out.println(stack.getMinimum());
        System.out.println(stack);
        System.out.println(stack.getMinimum());
    }

    @Override
    public String toString(){
        return Arrays.toString(array) + " | Top:" + top + ", size: " + size;
    }


    static class StackNode {
        int data;
        int localMinimum; //this variable keeps track of the minimum thus far - till this stack node is added.

        StackNode(int data){
            this.data = data;
        }

        @Override
        public String toString(){
            return String.format("%d [%d]", this.data, this.localMinimum);
        }
    }


}
