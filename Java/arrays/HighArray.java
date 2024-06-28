package arrays;

import java.util.Scanner;

public class HighArray {

    private final int[] arr;
    private int nElems;

    public HighArray(int size) {
        arr = new int[size];
        nElems = 0;
    }

    public int getNumEle() {
        return nElems;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void insert(int val) {
        arr[nElems] = val;
        nElems++;
    }

    public int search(int val) {
        int i;
        for (i = 0; i < nElems; i++)
            if (arr[i] == val) break;

        if (i == nElems) return (-1);
        else return i;
    }

    public int delete(int val) {
        int index = search(val);
        if (index != -1) {
            for (int k = index; k < nElems - 1; k++) {
                arr[k] = arr[k + 1];
            }
            nElems--;
            return 1;
        } else {
            return 0;
        }
    }

    public int getMax() {
        if (nElems == 0) {
            return -1;
        }
        int highestElem = arr[0];
        for (int i=1; i<nElems; i++) {
            if (arr[i] > highestElem) {
                highestElem = arr[i];
            }
        }
        return highestElem;
    }

    public int removeMax() {
        int maxElem = getMax();
        if (maxElem != -1) {
            delete(maxElem);
        }
        return maxElem; // -1
    }



    public static void main(String[] args) {
        int size = 20;
        HighArray ar = new HighArray(size);
        Scanner sc = new Scanner(System.in);

        ar.insert(34);
        ar.insert(56);
        ar.insert(23);
        ar.insert(12);
        ar.insert(90);
        ar.insert(89);
        ar.insert(21);
        ar.insert(77);
        ar.insert(99);
        ar.insert(44);
        ar.insert(55);
        ar.insert(22);
        ar.insert(88);
        ar.insert(11);
        ar.insert(00);
        ar.insert(66);
        ar.insert(33);

        ar.display();

        /*System.out.println("\nMax Elem: " + ar.getMax());
        ar.removeMax();
        ar.display();

        System.out.println("\nMax Elem: " + ar.getMax());
        ar.removeMax();
        ar.display();*/

        // 2.3
        HighArray highArray = new HighArray(size); // this will have the values from ar sorted in descending order.
        int maxElem;
        while ((maxElem = ar.removeMax()) != -1) {
            highArray.insert(maxElem);
        }
        System.out.println("");
        highArray.display();
    }

}
