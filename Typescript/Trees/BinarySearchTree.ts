

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

}