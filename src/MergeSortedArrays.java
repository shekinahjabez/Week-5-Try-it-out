import java.util.Arrays;

public class MergeSortedArrays {

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        /*
        Pseudocode:
        Function mergeArrays(arr1, arr2)
            // Input: Two sorted arrays arr1 and arr2
            // Output: A single sorted array containing all elements of arr1 and arr2
            // Variables: i (index for arr1), j (index for arr2), mergedArray (the resulting array)
        */

        int i = 0, j = 0;
        int[] mergedArray = new int[arr1.length + arr2.length];
        int k = 0; // Index for mergedArray

        // Loop through both arrays until one is exhausted
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

        // Add remaining elements from arr1 (if any)
        while (i < arr1.length) {
            mergedArray[k] = arr1[i];
            i++;
            k++;
        }

        // Add remaining elements from arr2 (if any)
        while (j < arr2.length) {
            mergedArray[k] = arr2[j];
            j++;
            k++;
        }

        // Return the merged sorted array
        return mergedArray;
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        int[] mergedArray = mergeArrays(arr1, arr2);

        // Print the result
        System.out.println("Merged Sorted Array: " + Arrays.toString(mergedArray));
    }
}
