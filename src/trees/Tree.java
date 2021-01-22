package trees;

/**
 * This class represents a Binary Search Tree. A binary search tree is a tree that consists of a collection of nodes,
 * whom have at most 2 children (child nodes). Each node contains a piece of data (See the {Node.class}). A Node's left
 * child must be of a lesser value than its' parent & the right child must contain data of greater value than its' parent.
 *
 * The Tree class enables us to access all nodes in the tree, we only require a single reference to the root node, from
 * this node we can access all subsequent nodes using the node.leftChild, node.rightChild references.
 *
 * The tree class contains methods that allow us to:
 *  - insert a node in to the tree
 *  - find a node within the tree
 *  - delete a node within the tree.
 *
 */
public class Tree {

    Node root = null;

    Node insert(int data){
        Node nodeToInsert = new Node(data);
        Node current = root;
        Node parentNode;
        while(true){
            parentNode = current;
            if(data < current.data){
                current = current.leftChild;
                if(current == null){
                    parentNode.leftChild = nodeToInsert;
                    break;
                }
            }
            if(data > current.data){
                current = current.rightChild;
                if(current == null){
                    parentNode.rightChild = nodeToInsert;
                    break;
                }
            }
        }
        return nodeToInsert;
    }


    Node find(int data){
        Node current = root;
        while(current.data != data){
            //If we are searching for a node with a value greater than the current nodes value - search subtree from the right child
            if(data > current.data){
                current = current.rightChild;
            }
            if(data < current.data){ ////If we are searching for a node with a value less than the current nodes value - search subtree from the left child
                current = current.leftChild;
            }
            if(current == null){
                return null; //Node cannot be found so we return null to indicate this
            }
        }
        return current;
    }



    public static void main(String[] args){
        Tree tree = new Tree();
        Node rootNode = new Node(30);
        tree.root = rootNode;
        tree.insert(23);
        tree.insert(37);
        tree.insert(12);
        tree.insert(39);
        tree.insert(40);
    }

}
