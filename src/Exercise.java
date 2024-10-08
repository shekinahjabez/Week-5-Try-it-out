class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}

public class Exercise {
    public static void main(String[] args) {
        // Example usage:
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Exercise exercise = new Exercise();
        int nodeCount = exercise.countNodes(root);
        System.out.println("Number of nodes: " + nodeCount);
        boolean checkBalance = exercise.isBalanced(root);
        System.out.println("Is the tree balanced? " + checkBalance);
    }

    public int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return 1 + leftCount + rightCount;
    }

    public boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}