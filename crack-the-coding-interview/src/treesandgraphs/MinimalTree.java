package treesandgraphs;


/**
 * 4.2 Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a
 * binary search tree with minimal height.
 *
 * My approach:
 * Consider such an array: [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15] - In order to make the tree of minimal depth, chances are
 * the center value in the array will be the root and the values to the left formulate the Left subtree & same for the right.
 *
 *  So we begin by setting the root to be 8 & then partition the array in to 2 sub-arrays, leftArr & rightArr.
 *  The center value of the leftArr will be the left child of a given node and the same for the right - we then recurse this solution.
 *
 *  I believe the time complexuity is O(n/2 + n/2) = O(n) where n is the size of the inputArray & the space complexity
 *  O(2^n)? As the code recurses twice for each node?
 */
public class MinimalTree {

    int[] inputArray;
    Node root;

    public static int calculateMinimumDepth(int[] orderedArr){
        int n = orderedArr.length;
        double depth = Math.log10(n+1)/Math.log10(2);
        System.out.println(n);
        System.out.println(n/2);
        return (int) Math.ceil(depth);
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        MinimalTree tree = new MinimalTree(arr);
        calculateMinimumDepth(arr);
        tree.createMinimalTree(arr, tree.root);
        tree.inOrderTraversal(tree.root);
        tree.createMinimalTree(arr, tree.root);
    }

    void createMinimalTree(int[] inputArray, Node node){
        if(inputArray.length==1){
            return;
        }
        int[] leftArr = new int[inputArray.length/2];
        for(int i=0; i<inputArray.length/2; i++){
            leftArr[i] = inputArray[i];
        }
        int[] rightArr = new int[inputArray.length/2];
        for(int i=0; i<inputArray.length/2; i++) {
            rightArr[i] = inputArray[1 + i + inputArray.length / 2];
        }
        node.left = new Node(leftArr[leftArr.length/2]);
        node.right = new Node(rightArr[rightArr.length/2]);
        createMinimalTree(leftArr, node.left);
        createMinimalTree(rightArr, node.right);

    }

    void setRoot(int[] orderedArr){
        this.root = new Node(orderedArr[orderedArr.length/2]);
        System.out.println(this.root);
    }

    MinimalTree(int[] inputArrayOfUniqueAscendingItems){
        this.inputArray = inputArrayOfUniqueAscendingItems;
        setRoot(inputArrayOfUniqueAscendingItems);
    }

    void inOrderTraversal(Node localRoot){
        if(localRoot!=null) {
            inOrderTraversal(localRoot.left);
            System.out.println(localRoot);
            inOrderTraversal(localRoot.right);
        }
    }


    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }


}
