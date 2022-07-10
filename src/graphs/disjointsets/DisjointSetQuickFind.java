package graphs.disjointsets;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * DisjointSetQuickFind uses an underlying root to represent a disjoint set which can be used to check
 * the connectivity between any 2 nodes in a network.
 *
 * The underlying root uses the indices to represent a node and the parent value is the root node.
 *
 * Consider the following network:
 *
 *      1      4 - 7    0
 *     / \     |
 *    2   3    6
 *   /
 *  5
 *
 *  1) We begin by initializing an root and setting each node as their own root node (assuming they are not yet connec-
 *  ted).
 *
 *  2) Our union method [O(n)] is responsible for joining two nodes, such that the 2 nodes have the same root node.*
 *
 *  3) Our find method should run in O(1) time as the root values represent the root nodes. This should be a simple
 *  read at a given root index.
 */
public class DisjointSetQuickFind {

    int[] root;

    /**
     * Initializes the DisjointSetQuickFind object
     * @param n number of nodes in network.
     */
    DisjointSetQuickFind(int n) {
        this.root = new int[n];
        for (int i=0; i<n; i++) {
            this.root[i] = i;
        }
    }

    /**
     * Finds the root node in O(1) time
     * @param node
     * @return root node of node
     */
    int find(int node) {
        return root[node];
    }

    /**
     * Unions / Joins two nodes such that they share the same root node.
     * @param x node 1
     * @param y node 2
     */
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) { // these nodes (x & y) are not yet connected.
            // go through all nodes in the root & any node that has a rootNode = rootY (change it to rootX).
            for (int i=0; i<this.root.length; i++) {
                if (root[i] == rootY) {
                    root[i] = rootX;
                }
            }
        }
    }

    /**
     * Determines if two nodes are connected (a part of the same component).
     * @param x
     * @param y
     * @return whether the 2 nodes connected.
     */
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public void timedUnion(int x, int y) {
        long startTime = (long) (System.nanoTime() / 1e3);
        union(x, y);
        System.out.println("Union performed in " + (System.nanoTime()/1e6 - startTime) + "ms");
    }

    public int timedFind(int x) {
        long startTime = (long) (System.nanoTime() / 1e6);
        int result = find(x);
        System.out.println("Find performed in " + (System.nanoTime()/1e6 - startTime) + "ms");
        return result;
    }

    @Override
    public String toString() {
        Integer[] indices = new Integer[root.length];
        Stream.iterate(0, x -> x+1).limit(root.length).collect(Collectors.toList()).toArray(indices);
        return String.format("%s\n%s\n",Arrays.toString(root), Arrays.toString(indices));
    }


    public static void main(String[] args) {
        int noOfNodesInNetwork = 8;
        DisjointSetQuickFind disjointSet = new DisjointSetQuickFind(noOfNodesInNetwork);
        System.out.println(disjointSet);
        disjointSet.union(1, 2);
        disjointSet.union(1, 3);
        disjointSet.union(2, 5);

        disjointSet.union(4, 6);
        disjointSet.union(4, 7);
        System.out.println(disjointSet);

        System.out.println(disjointSet.connected(1, 5)); // true
        System.out.println(disjointSet.connected(4, 7)); // true
        System.out.println(disjointSet.connected(0, 1)); // false
        System.out.println(disjointSet.connected(3, 6)); // false

        System.out.println(disjointSet.timedFind(3));
    }
}
