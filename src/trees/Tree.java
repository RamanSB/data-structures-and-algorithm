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


    /**
     * This has a time complexity of O(log(N)) as for N nodes we only make comparisons equal to the max level (depth) of the tree.
     * One comparison per level of the tree.
     * @param data
     * @return
     */
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

    /**
     * Recursive method use to traverse the tree in-order (in-order of ascending node value)
     * When the child node of a localRoot is null - the next recursive invocation of the method will yield the base-case.
     * @param localRoot
     */
    void traverseInOrder(Node localRoot){
        if(localRoot != null) {
            traverseInOrder(localRoot.leftChild); //Recursively visit all left nodes
            System.out.println("Visiting node: " + localRoot.data); //Visiting //Then visit current local root node
            traverseInOrder(localRoot.rightChild); //Recursively visit all right nodes.
        }
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
        //Node foundNode = tree.find(14);
        //System.out.println(foundNode);
        tree.traverseInOrder(rootNode);
    }

}
