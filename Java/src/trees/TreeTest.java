package trees;

/**
 * Keeps an instance variable with a reference to the rootNode
 * <p>
 * Methods: find(NodeTest node), insert(Node n), inOrderTraversal();
 */
public class TreeTest {

    NodeTest rootNode;


    TreeTest() { }

    TreeTest(NodeTest rootNode) {
        this.rootNode = rootNode;
    }

    NodeTest find(NodeTest searchNode) {
        if (searchNode != null & this.rootNode != null) {
            NodeTest current = this.rootNode;
            int level = 0;
            while (current != null) {
                System.out.println("Iterating through level: " + level++);
                if (searchNode.data > current.data) {
                    current = current.right;
                } else if (searchNode.data < current.data) {
                    current = current.left;
                } else {
                    return current;
                }
            }
        }
        return null;
    }

    boolean insert(NodeTest newNode) {
        if(this.rootNode == null){
            this.rootNode = newNode;
            System.out.println(newNode + " has assigned as the root node");
            return true;
        }

        if (newNode != null & this.rootNode != null) {
            NodeTest current = this.rootNode;
            NodeTest parent = null;
            while (current != null) {
                //System.out.println("Traversing: " + current);
                parent = current;
                if (newNode.data > current.data) {
                    current = current.right;
                } else if (newNode.data < current.data) {
                    current = current.left;
                } else {
                    System.out.println("Node: " + newNode.data + " already exists.");
                    return false;
                }
            }
            if(parent != null && newNode.data > parent.data){
                parent.right = newNode;
            }
            else{
                parent.left = newNode;
            }
            System.out.println("Inserted node " + newNode + " child of " + parent);
            return true;
        }
        return false;
    }

    /**
     * in order traversal - visits the nodes in ascending order of value, furthest descendant on the left subtree to the root
     * and down through the right subtree in order of ascending value.
     * @param node
     */
    void inOrderTraversal(NodeTest node){
        if(node!=null){
            inOrderTraversal(node.left);
            //Visiting a node, here we will simply just print the node we are visiting
            System.out.println("Visiting " + node);
            inOrderTraversal(node.right);
        }
    }



    public static void main(String[] args){
        TreeTest testTree = new TreeTest();
        NodeTest rootNode = new NodeTest(45);

        testTree.rootNode = rootNode;
        testTree.insert(new NodeTest(13));
        testTree.insert(new NodeTest(34));
        testTree.insert(new NodeTest(9));
        testTree.insert(new NodeTest(10));
        testTree.insert(new NodeTest(53));
        testTree.insert(new NodeTest(51));
        testTree.insert(new NodeTest(67));
        testTree.insert(new NodeTest(72));
        System.out.println("Found: " + testTree.find(new NodeTest(53)));
        testTree.inOrderTraversal(rootNode);

    }
}
