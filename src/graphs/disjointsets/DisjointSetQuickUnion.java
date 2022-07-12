package graphs.disjointsets;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * DisjointSetQuickUnion is a datastructure that employs an underlying array to keep track of a nodes parent vertex.
 * This can be used to determine whether nodes in a network are connected (belong to the same component).
 *
 * Consider the following network:
 *
 *      1      4 - 7    0
 *     / \     |
 *    2   3    6
 *   /
 *  5
 *
 * 1) We begin by initializing an array (parent) where all nodes are unconnected and are their own respective parents.
 *
 * 2) The find method operates in O(n) time. As the parent array stores parent nodes we can identify a root node as a node
 * that is its own parent.
 *
 *
 */
public class DisjointSetQuickUnion {

    int[] parent;

    DisjointSetQuickUnion(int n) {
        parent = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
    }

    /**
     * Finds the root node of the given node parameter.
     * <p>
     * <strong>Operates in O(n) time.</strong>
     * @param x
     * @return root node of node x.
     */
    int find(int x) {
        while (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }

    /**
     * Ensures the 2 nodes share the same root node.
     *
     * @param x
     * @param y
     */
    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) { // nodes x & y are not connected.
            // connect the root of Y to the root of X, so rootY's parent is now rootX.
            parent[rootY] = rootX;
        }
    }

    void timedUnion(int x, int y) {
        long startTime = System.nanoTime();
        union(x, y);
        System.out.println("Union performed in " + ((System.nanoTime() - startTime) + "ns"));
    }

    int timedFind(int x) {
        long startTime = System.nanoTime();
        int result = find(x);
        System.out.println("Find performed in " + ((System.nanoTime() - startTime) + "ns"));
        return result;
    }

    @Override
    public String toString() {
        Integer[] indices = new Integer[parent.length];
        Stream.iterate(0, x -> x+1).limit(parent.length).collect(Collectors.toList()).toArray(indices);
        return String.format("%s\n%s\n", Arrays.toString(parent), Arrays.toString(indices));
    }


    public static void main(String[] args) {
        DisjointSetQuickUnion disjointSet = new DisjointSetQuickUnion(8);
        System.out.println(disjointSet);
        disjointSet.timedUnion(1,2);
        disjointSet.timedUnion(1,3);
        disjointSet.timedUnion(2,5);
        System.out.println(disjointSet);
        disjointSet.timedUnion(4,6);
        disjointSet.timedUnion(4,7);
        System.out.println(disjointSet);
        System.out.println(disjointSet.timedFind(0));
        System.out.println(disjointSet.timedFind(2));
        System.out.println(disjointSet.timedFind(5));
        System.out.println(disjointSet.timedFind(6));
        disjointSet.timedUnion(3, 7);
        System.out.println(disjointSet);

    }


}
