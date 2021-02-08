package arrays;

public class FindFirstOccurrence {

    public static void main(String[] args){
        int[] A = {2, 3, 5, 5, 6, 6, 8, 9, 9, 9};
        int key = 5;

        int index = findFirstOccurrence(A, key);

        if (index != -1) {
            System.out.println("The first occurrence of element " + key +
                    " is located at index " + index);
        } else {
            System.out.println("Element not found in the array");
        }
    }

    private static int findFirstOccurrence(int[] array, int target){

        int low = 0;
        int high = array.length - 1;

        // initialize the result by -1
        int result = -1;
        while(low <= high){
            // find the mid-value in the search space and compares it with the target
            int midpoint = (low + high) / 2;
            // if the key is located, update the result and
            // search towards the left (lower indices)
            if(array[midpoint] == target){
                result = midpoint;
                high = midpoint - 1;
            }else if(array[midpoint] < target){
                low = midpoint + 1;
            }else {
                high = midpoint - 1;
            }
        }
        // return the leftmost index, or -1 if the element is not found
        return result;
    }
}
