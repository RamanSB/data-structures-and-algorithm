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
    int[] stackTops; //Used for popAt

    SetOfStacks(int threshold, int noOfStacksInSet){
        this.threshold = threshold;
        this.noOfStacksInSet = noOfStacksInSet;
        this.stackMainArray = new int[noOfStacksInSet][threshold];
        this.stackIndex = -1;
        this.stackTops = new int[noOfStacksInSet];
    }

    void push(int elem){
        if((top+1)%threshold == 0){
            stackIndex+=1;
            top = -1;
            if(stackIndex >= noOfStacksInSet){
                throw new ArrayIndexOutOfBoundsException("All stacks in set are full");
            }
        }
        stackTops[stackIndex] = (top+1);
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
        stackTops[stackIndex] = (top-1);
        if(stackIndex == 0 & top==-1){
            stackIndex--;
        }
        return poppedItem;
    }

    int popAt(int index){
        if(stackTops[index] == -1){
            throw new ArrayIndexOutOfBoundsException("Stack at index " + index + " is empty.");
        }
        return stackMainArray[index][stackTops[index]--];
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
        SetOfStacks setOfStacks = new SetOfStacks(3, 4);
        setOfStacks.push(2);
        setOfStacks.push(2);
        setOfStacks.push(2);
        setOfStacks.push(2);
        System.out.println(setOfStacks);
        setOfStacks.pop();
        setOfStacks.pop();
        setOfStacks.pop();
        setOfStacks.pop();
        System.out.println(setOfStacks);
        setOfStacks.push(4);
        setOfStacks.push(4);
        setOfStacks.push(4);
        setOfStacks.push(4);
        System.out.println(setOfStacks);
        setOfStacks.push(5);
        setOfStacks.push(5);
        setOfStacks.push(6);
        System.out.println(setOfStacks);
        setOfStacks.push(6);
        setOfStacks.push(6);
        setOfStacks.push(67);
        System.out.println(setOfStacks);
        setOfStacks.push(67);
        setOfStacks.push(67);
        System.out.println(setOfStacks);
        System.out.println(setOfStacks.popAt(3));
        System.out.println(setOfStacks.popAt(2));
        System.out.println(setOfStacks.popAt(1));
        System.out.println(setOfStacks.popAt(1));
        System.out.println(setOfStacks.popAt(2));
    }

}
