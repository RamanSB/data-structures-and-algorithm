package arrays;

class OrderedArray {
    private final int[] arr;
    private int nElems;

    public OrderedArray(int max) {
        arr = new int[max];
    }

    public int size() {
        return nElems;
    }

    public int find(int searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;

            if (arr[curIn] == searchKey)
                return curIn;
            else if (lowerBound > upperBound)
                return nElems;
            else {
                if (arr[curIn] < searchKey)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }
    }

    public boolean insert(int val) {
        int lowerBound = 0;
        int upperBound = size() - 1;
        int midIdx = 0;

        while (true) {
            if (lowerBound > upperBound) {
                break;
            }
            midIdx = (lowerBound + upperBound) / 2;
            if (arr[midIdx] > val) {
                upperBound = midIdx - 1;
            } else if (arr[midIdx] <= val) {
                lowerBound = midIdx + 1;
                midIdx = lowerBound;
            }
        }

        for (int k=nElems; k>midIdx; k--) {
            arr[k] = arr[k-1];
        }
        arr[midIdx] = val;
        nElems++;
        return true;
    }

    public boolean delete(int value) {
        int idxOfElemToDelete = find(value);
        if (idxOfElemToDelete == nElems) {
            return false;
        } else {
            for (int k=idxOfElemToDelete; k<nElems; k++) {
                arr[k] = arr[k+1];
            }
            nElems--;
            return true;
        }
    }


    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(arr[j] + " ");
        System.out.println();
    }

    public static OrderedArray merge(OrderedArray arrA, OrderedArray arrB, int maxSize) {
        OrderedArray mergedArray = new OrderedArray(maxSize);
        int arrIncrementerA = 0;
        int arrIncrementerB = 0;
        if (arrA.nElems > arrB.nElems) {
            while (arrIncrementerB < arrB.nElems && arrIncrementerA < arrA.nElems) {
                if (arrB.arr[arrIncrementerB] >= arrA.arr[arrIncrementerA]) {
                    mergedArray.arr[mergedArray.nElems] = (arrA.arr[arrIncrementerA]);
                    arrIncrementerA++;
                } else {
                    mergedArray.arr[mergedArray.nElems] = (arrB.arr[arrIncrementerB]);
                    arrIncrementerB++;
                }
                mergedArray.nElems++;
            }
            if (arrIncrementerA < arrA.nElems) {
                for(int i=arrIncrementerB; i<arrB.nElems; i++) {
                    mergedArray.arr[mergedArray.nElems] = (arrB.arr[i]);
                    mergedArray.nElems++;
                }
            } else {
                for (int i=arrIncrementerA; i<arrA.nElems; i++) {
                    mergedArray.arr[mergedArray.nElems] = (arrA.arr[i]);
                    mergedArray.nElems++;
                }
            }

        }
        return mergedArray;
    }

    public static void main(String[] args) {
        int maxSize = 100;
        OrderedArray arr = new OrderedArray(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(12);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.insert(33);

        arr.display();

        //ELEMENT TO BE SEARCHED

		int searchKey = 11;

		if( arr.find(searchKey) != arr.size())
			System.out.println("Found " + searchKey);
		else
			System.out.println("Can’t find " + searchKey);

		arr.display();



        OrderedArray arr2 = new OrderedArray(maxSize);

        arr2.insert(34);
        arr2.insert(54);
        arr2.insert(23);
        arr2.insert(76);
        arr2.insert(87);
        arr2.insert(63);
        arr2.insert(82);
        arr2.insert(45);
        arr2.insert(73);
        arr2.insert(78);
        arr2.display();

        //Displaying arrays before merging
        arr.display();;
        arr2.display();
        //MERGE TWO ARRAY
        OrderedArray arr3 = OrderedArray.merge(arr, arr2, maxSize);
        System.out.println("Merged array: ");
        arr3.display();

    }
}


