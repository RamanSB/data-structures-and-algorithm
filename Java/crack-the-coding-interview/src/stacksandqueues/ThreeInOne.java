package stacksandqueues;

import java.util.Arrays;

public class ThreeInOne {

    int[] array;
    int top1st, top2nd, top3rd;

    public ThreeInOne(int size){
        array = new int[size];
        top1st = -1;
        top2nd = (size/3) - 1;
        top3rd = (2*size/3) - 1;
    }

    public static void main(String[] args){
        ThreeInOne stack3 = new ThreeInOne(12);
        System.out.println(stack3);
        stack3.push1(4);
        stack3.push1(5);
        stack3.push1(6);
        System.out.println(stack3.peek1());
        stack3.push1(7);
        System.out.println(stack3.pop1());
        System.out.println(stack3.pop1());
        System.out.println(stack3.pop1());
        System.out.println(stack3.pop1());
        System.out.println(stack3);


        stack3.push2(10);
        stack3.push2(14);
        stack3.push2(12);
        stack3.push2(11);
        System.out.println(stack3);
        System.out.println(stack3.pop2());
        System.out.println(stack3);
    }

    @Override
    public String toString(){
        return String.format("Array: %s | Top1st: %d | Top2nd: %d | Top3rd: %d", Arrays.toString(array), top1st, top2nd, top3rd);
    }

    public void push1(int item){
        if(top1st==this.array.length/3 - 1){
            throw new ArrayStoreException("No more space in the stack");
        }
        array[++top1st] = item;
    }

    public int peek1(){
        return array[top1st];
    }

    public int pop1(){
        if(top1st == -1){
            throw new ArrayIndexOutOfBoundsException("There exists no element to remove");
        }
        return array[top1st--];
    }

    public void push2(int item){
        if(top2nd == (2*this.array.length/3)-1){
            throw new ArrayStoreException("No more space available in the 2nd stack");
        }
        array[++top2nd] = item;
    }

    public int peek2(){
        return array[top2nd];
    }

    public int pop2(){
        if(top2nd == this.array.length/3 - 1){
            throw new ArrayIndexOutOfBoundsException("No elements exist to be removed in stack 2");
        }
        return array[top2nd--];
    }

    public void push3(int item){

    }

    public int peek3(){
        return 0;
    }

    public int pop3(){
        return 0;
    }

}
