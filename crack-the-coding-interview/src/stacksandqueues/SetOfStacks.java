package stacksandqueues;

import jdk.nashorn.internal.runtime.arrays.ArrayIndex;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SetOfStacks {

    int threshold;
    int[][] stackMainArray;
    int noOfStacksInSet;
    int stackIndex;
    int top = -1;

    SetOfStacks(int threshold, int noOfStacksInSet){
        this.threshold = threshold;
        this.noOfStacksInSet = noOfStacksInSet;
        this.stackMainArray = new int[noOfStacksInSet][threshold];
        this.stackIndex = -1;
    }

    void push(int elem){
        if((top+1)%threshold == 0){
            stackIndex+=1;
            top = -1;
            if(stackIndex >= noOfStacksInSet){
                throw new ArrayIndexOutOfBoundsException("All stacks in set are full");
            }
        }
        stackMainArray[stackIndex][++top] = elem;
    }

    int peek(){
        return stackMainArray[stackIndex][top];
    }

    int pop(){
        if(top==-1){
            stackIndex--;
            top = threshold-1;
        }
        if(stackIndex <= -1 || top <=-1){
            throw new ArrayIndexOutOfBoundsException("All stacks are empty");
        }
        int poppedItem = stackMainArray[stackIndex][top--];
        if(stackIndex == 0 & top==-1){
            stackIndex--;
        }
        return poppedItem;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<stackMainArray.length; i++){
            stringBuilder.append(Arrays.toString(stackMainArray[i])+"\n");
        }
        return "-----------------" +
                "SetOfStacks{" +
                "threshold=" + threshold +
                ", stackMainArray=" + stringBuilder.toString() +
                ", noOfStacksInSet=" + noOfStacksInSet +
                ", stackIndex=" + stackIndex +
                ", top=" + top +
                '}'+"\n";
    }

    public static void main(String[] args){
        SetOfStacks setOfStacks = new SetOfStacks(4, 3);
        setOfStacks.push(5);
        setOfStacks.push(8);
        System.out.println(setOfStacks);
        setOfStacks.push(9);
        setOfStacks.push(12);
        setOfStacks.push(13);
        System.out.println(setOfStacks);
        setOfStacks.push(21);
        setOfStacks.push(24);
        System.out.println(setOfStacks);
        System.out.println(setOfStacks.peek());
        setOfStacks.push(24);
        setOfStacks.push(84);
        setOfStacks.push(15);
        setOfStacks.push(96);
        System.out.println(setOfStacks);
        setOfStacks.push(1);
        System.out.println(setOfStacks);
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks);
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks);
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks);
        setOfStacks.push(53);
        setOfStacks.push(53);
        setOfStacks.push(12);
        setOfStacks.push(53);
        setOfStacks.push(13);
        setOfStacks.push(132);
        System.out.println(setOfStacks);
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks);
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks);


    }

}
