

class TreeNode<T> {
    data: T;
    left: TreeNode<T> | null;
    right: TreeNode<T> | null;

    constructor(data: T) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

interface IBinarySearchTree<T> {
    insert(data: T): void;
    search(data: T): TreeNode<T> | null
}

class BinarySearchTree<T> implements IBinarySearchTree<T> {

    root: TreeNode<T> | null;

    constructor() {
        this.root = null;
    }

    insert(data: T): void {
        if (!this.root) {
            this.root = new TreeNode<T>(data);
        } else {
            const newNode: TreeNode<T> = new TreeNode<T>(data);
            this.insertNode(this.root, newNode);
        }
    }

    private insertNode(root: TreeNode<T>, newNode: TreeNode<T>) {
        if (newNode.data < root.data) {
            if (root.left == null) {
                root.left = newNode;
            } else {
                this.insertNode(root.left, newNode);
            }
        } else {
            if (root.right == null) {
                root.right = newNode;
            } else {
                this.insertNode(root.right, newNode);
            }
        }
    }


    search(data: T): TreeNode<T> | null {
        if (this.root == null) {
            return null;
        }
        const queue: (TreeNode<T> | null)[] = [this.root];
        while (queue.length !== 0) {
            const currentNode = queue.shift();
            if (currentNode?.data == data) {
                return currentNode;
            }
            if (currentNode?.left) {
                queue.push(currentNode.left);
            }
            if (currentNode?.right) {
                queue.push(currentNode.right);
            }

        }
        return null;
    }

    visit(node: TreeNode<T> | null) {
        console.log(node?.data);
    }

    inorderTraversal(root: TreeNode<T> | null) {
        if (!root) {
            return;
        }

        this.inorderTraversal(root.left);
        this.visit(root);
        this.inorderTraversal(root.right);
    }

    preorderTraversal(root: TreeNode<T> | null) {
        if (!root) {
            return;
        }

        this.visit(root);
        this.preorderTraversal(root.left);
        this.preorderTraversal(root.right);
    }

    postOrderTraversal(root: TreeNode<T> | null) {
        if (!root) {
            return;
        }

        this.postOrderTraversal(root.left);
        this.postOrderTraversal(root.right);
        this.visit(root);
    }


    bfs(root: TreeNode<T> | null): string {
        if (!root) {
            return "";
        }

        let bfsPath = "";

        const queue = [root];
        let level = 0;
        while (queue.length) {
            console.log("Level: ", level)
            const numberOfNodesInLevel: number = queue.length;
            for (let i = 0; i < numberOfNodesInLevel; i++) {
                let current: TreeNode<T> | null = queue.shift() as TreeNode<T>;
                console.log(current.data);
                bfsPath += current.data + " -> "
                if (current.left) {
                    queue.push(current.left);
                }
                if (current.right) {
                    queue.push(current.right);
                }
            }
            level++;
        }
        const result = bfsPath.substring(0, bfsPath.lastIndexOf("->"));
        console.log(result);
        return result;
    }
}

const bst: BinarySearchTree<number> = new BinarySearchTree();
bst.insert(4);
bst.insert(3);
bst.insert(2);
bst.insert(6);
bst.insert(5);
bst.insert(7);
/* console.log("In order traversal")
bst.inorderTraversal(bst.root);
console.log("Pre order traversal")
bst.preorderTraversal(bst.root);
console.log("Post order traversal")
bst.postOrderTraversal(bst.root); */

bst.bfs(bst.root);
