package queue;

import java.util.Arrays;

/**
 * Main methods of a queue are offer() & poll():
 * offer() adds an element to the rear of the queue (O(1))
 * poll() removes an element from the front of the queue (O(1))
 */

public class Queue {

    int[] array;
    int maxSize;
    int front;
    int rear;

    Queue(int maxSize){
        if(this.maxSize >= 0){
            this.maxSize = maxSize;
        }
        this.array = new int[maxSize];
        front = 0;
        rear = 0;
    }

    void offer(int elem){
        if(rear==maxSize){
            rear = 0;
        }
        array[rear++] = elem;
    }

    int poll(){
        if(front==maxSize){
            front = 0;
        }
        return array[front++];
    }

    int peek(){
        return array[front];
    }

    @Override
    public String toString(){
        return Arrays.toString(array) + " | " + String.format("front: %d, rear: %d", front, rear);
    }



    public static void main(String[] args){
        Queue queue = new Queue(5);
        queue.offer(5);
        queue.offer(12);
        System.out.println(queue);
        queue.offer(37);
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        queue.offer(50);
        System.out.println(queue);
        queue.offer(51);
        System.out.println(queue);
        queue.offer(302);
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.poll());
    }

}
