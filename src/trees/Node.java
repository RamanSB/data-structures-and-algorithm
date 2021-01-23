package trees;

/**
 * This class represents a Node within a Tree data-structure.
 * - A node may have at most 2 chlidren (or none in the case of a leaf node)
 * - Each node has a reference to 2 possible children (node.leftChild, node.rightChild)
 *
 */
//ToDo: use generics to ensure Nodes can be programmed to contain a generic value using type parameters.
public class Node {

    int data; //We can create a separate class i.e. NodeData which will be an Object containing arbitrary data a node may represent.
    Node leftChild;
    Node rightChild;

    Node(int data){
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    @Override
    public String toString(){
        return "Node: " + this.data;
    }
}
