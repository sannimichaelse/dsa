package arrays;

public class BinarySearch {

    /**
       Input:

       arr[] = [2, 3, 5, 7, 9]
       target = 7

       Output: Element found at index 3

       arr[] = [1, 4, 5, 8, 9]
       target = 2

       Output: Element not found
     **/

    public static void main(String[] args) {
        int[] A = {2, 3, 6, 8, 9, 10};
        int key = 9;
        int index = binarySearch(A, 0, A.length - 1, key);

        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found in the array");
        }
    }

    // Iterative Approach
    private static int binarySearch(int[] array, int target) {

        int low = 0;
        int high = array.length - 1;

        // loop till the search space is exhausted
        while (low <= high) {

            // find the mid-value in the search space and
            // compares it with the target
            int midpoint = (low + high) / 2;

            if (array[midpoint] == target) {
                return midpoint;
            }

            // discard all elements in the left search space,
            // including the middle element
            if (array[midpoint] < target) {
                low = midpoint + 1;
            } else {
                // discard all elements in the right search space,
                // including the middle element
                high = midpoint - 1;
            }
        }

        // `target` doesn't exist in the array
        return -1;
    }

    // Using Recursion
    private static int binarySearch(int[] array, int low, int high, int target) {

        // Base condition (search space is exhausted)
        if (low > high) {
            return -1;
        }

        // find the mid-value in the search space and
        // compares it with the target
        int midpoint = (low + high) / 2;

        if (array[midpoint] == target) {
            return midpoint;
        } else if (array[midpoint] < target) {
            return binarySearch(array, midpoint + 1, high, target);
        } else {
            return binarySearch(array, low, midpoint - 1, target);
        }
    }

}
