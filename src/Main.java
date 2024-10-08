class treeNode {
    int value;
    treeNode left, right;

    treeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

class BinaryTree {

    // Function to count nodes in the binary tree
    public int countNodes(treeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return 1 + leftCount + rightCount;
    }

    // Helper function to determine the height and check balance
    private int height(treeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Function to check if the binary tree is balanced
    public boolean isBalanced(treeNode root) {
        return height(root) != -1;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        treeNode root = new treeNode(1);
        root.left = new treeNode(2);
        root.right = new treeNode(3);
        root.left.left = new treeNode(4);
        root.left.right = new treeNode(5);

        System.out.println("Total number of nodes: " + tree.countNodes(root));  // Output: 5
        System.out.println("Is the tree balanced? " + tree.isBalanced(root));  // Output: true
    }
}
