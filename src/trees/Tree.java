package trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

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

    /**
     * Recursive method use to traverse the tree pre-order (pre-order root, sub-tree of left-child, sub-tree of right child)
     * When the child node of a localRoot is null - the next recursive invocation of the method will yield the base-case.
     * @param localRoot
     */
    void traversePreOrder(Node localRoot){
        if(localRoot != null) {
            System.out.println("Visiting node: " + localRoot.data); //Visiting //Then visit current local root node
            traversePreOrder(localRoot.leftChild); //Recursively visit all left nodes
            traversePreOrder(localRoot.rightChild); //Recursively visit all right nodes.
        }
    }

    void traversePostOrder(Node localRoot){
        if(localRoot!=null){
            traversePostOrder(localRoot.leftChild);
            traversePostOrder(localRoot.rightChild);
            System.out.println("Visiting node: " + localRoot.data);
        }
    }

    Node minimum(){
        Node currentNode = root;
        while(currentNode != null){
            if(currentNode.leftChild == null){
                break;
            }else{
                currentNode = currentNode.leftChild;
            }
        }
        System.out.println("Minimum Node: " + currentNode);
        return currentNode;
    }

    Node maximum(){
        Node currentNode = root;
        while(currentNode != null){
            if(currentNode.rightChild == null){
                break;
            } else {
                currentNode = currentNode.rightChild;
            }
        }
        System.out.format("Max Node: " + currentNode);
        return currentNode;
    }


    /**
     * Traversing in (ascending) order without recursion, we use a Stack (because we are traversing the depth of the tree) [dfs]
     * 1) We push the rootNode to the stack & then subsequently iterate through all left children until there are none left,
     *    setting the current node to the left child and pushing them to the stack during each iteration. #nested-while loop
     * 2) We then pop from the stack (left most node) and point the current reference to the popped node.
     * 3) We then visit that node.
     * 4) We then set the current node to be the right child of the current node
     * 4 Note: Even if the right child is null, we will set the current value to null because this will ensure we do not re-add the
     *         left children of the current node as we have already done (this prevents the nested while loop from re-running)

     */
    void traverseInOrderWithoutRecursion(Node localRoot){
        Deque<Node> nodeStack = new ArrayDeque<>();
        Node current = localRoot;

        while(!nodeStack.isEmpty() || current != null){
            while(current != null){
                nodeStack.push(current);
                current = current.leftChild;
            }
            current = nodeStack.pop();
            visit(current);
            current = current.rightChild;
        }
    }

    /**
     * Traversing pre-Order without recursion, using a Stack (Deque):
     * Stack is a LIFO structure, hence we add the right children first & the left children last, because we
     * want to visit the left children first (after the root) & the right child nodes last.
     * PreOrder: Root, Left, Right
     * 1) Push the rootNode on to the stack and we will begin iterating from there.
     * 2) Pop the root node & visit it.
     * 3) if a right child node exists (push it to the stack)
     * 4) if a left child node exists (push it to the stack)
     * 5) iterate until stack is empty.
     * @param localRoot
     */
    void traversePreOrderWithoutRecursion(Node localRoot){
        Deque<Node> nodeStack = new ArrayDeque<>();
        Node current = localRoot;
        nodeStack.push(current); //Start with only the rootNode on the stack - we will visit this 1st
        while(!nodeStack.isEmpty()){
            current = nodeStack.pop();
            visit(current);
            if(current.rightChild != null){
                nodeStack.push(current.rightChild);
            }
            if(current.leftChild != null){
                nodeStack.push(current.leftChild);
            }
        }
    }



    void visit(Node node){
        System.out.println("Visiting: " + node);
    }


    public static void main(String[] args){
        Tree tree = new Tree();
        Node rootNode = new Node(30);
        tree.root = rootNode;
        Node node23 = tree.insert(23);
        tree.insert(36);
        tree.insert(35);
        tree.insert(37);
        tree.insert(12);
        tree.insert(39);
        tree.insert(40);
        //Node foundNode = tree.find(14);
        //System.out.println(foundNode);
        tree.traverseInOrder(rootNode);
        System.out.println("----------");
       tree.traversePreOrder(rootNode);
        tree.minimum();
        tree.maximum();
        System.out.println("\n----------");
        //tree.traverseInOrderWithoutRecursion(rootNode);
        tree.traversePreOrderWithoutRecursion(rootNode);
        System.out.println("\n--------");
        tree.traversePostOrder(rootNode);
    }



}
