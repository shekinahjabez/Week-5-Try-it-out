import java.util.Arrays;

// TreeNode class definition for binary tree operations
class TreeNode {
    int value;
    treeNode left, right;

    TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

public class CombinedExercises {

    // --- Exercise 1: Count the Number of Nodes in a Binary Tree ---
    public int countNodes(treeNode root) {
        /*
        Pseudocode:
        Function countNodes(root)
            If root is null
                Return 0
            End If
            leftCount = countNodes(root.left)
            rightCount = countNodes(root.right)
            Return 1 + leftCount + rightCount
        End Function
        */

        if (root == null) {
            return 0;
        }
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return 1 + leftCount + rightCount;
    }

    // --- Exercise 2: Check if the Binary Tree is Balanced ---
    private int height(treeNode node) {
        /*
        Pseudocode:
        Function height(node)
            If node is null
                Return 0
            End If
            leftHeight = height(node.left)
            rightHeight = height(node.right)
            If abs(leftHeight - rightHeight) > 1
                Return -1
            End If
            Return 1 + max(leftHeight, rightHeight)
        End Function
        */

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

    public boolean isBalanced(treeNode root) {
        /*
        Pseudocode:
        Function isBalanced(root)
            Return height(root) != -1
        End Function
        */
        return height(root) != -1;
    }

    // --- Exercise 3: Merge Two Sorted Arrays ---
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        /*
        Pseudocode:
        Function mergeArrays(arr1, arr2)
            Initialize i = 0, j = 0, k = 0
            mergedArray = new int[arr1.length + arr2.length]
            While i < arr1.length AND j < arr2.length
                If arr1[i] <= arr2[j]
                    mergedArray[k] = arr1[i]
                    i++
                Else
                    mergedArray[k] = arr2[j]
                    j++
                End If
                k++
            End While
            While i < arr1.length
                mergedArray[k] = arr1[i]
                i++
                k++
            End While
            While j < arr2.length
                mergedArray[k] = arr2[j]
                j++
                k++
            End While
            Return mergedArray
        End Function
        */

        int i = 0, j = 0, k = 0;
        int[] mergedArray = new int[arr1.length + arr2.length];

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                mergedArray[k] = arr1[i];
                i++;
            } else {
                mergedArray[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1.length) {
            mergedArray[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            mergedArray[k] = arr2[j];
            j++;
            k++;
        }

        return mergedArray;
    }

    // --- Main Method for Testing ---
    public static void main(String[] args) {
        CombinedExercises exercises = new CombinedExercises();

        // --- Testing Exercise 1: Counting Nodes in a Binary Tree ---
        treeNode root = new treeNode(1);
        root.left = new treeNode(2);
        root.right = new treeNode(3);
        root.left.left = new treeNode(4);
        root.left.right = new treeNode(5);
        System.out.println("Total number of nodes: " + exercises.countNodes(root));  // Output: 5

        // --- Testing Exercise 2: Checking if the Tree is Balanced ---
        System.out.println("Is the tree balanced? " + exercises.isBalanced(root));  // Output: true

        // --- Testing Exercise 3: Merging Two Sorted Arrays ---
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] mergedArray = mergeArrays(arr1, arr2);
        System.out.println("Merged Sorted Array: " + Arrays.toString(mergedArray));  // Output: [1, 2, 3, 4, 5, 6, 7, 8]
    }
}
