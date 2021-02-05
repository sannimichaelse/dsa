package arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 *     1
 *
 *     Given an unsorted integer array, find a pair with a given sum in it
 *
 *     Input:
 *     arr = [8, 7, 2, 5, 3, 1]
 *     sum = 10
 *
 *     Output:
 *     Pair found at index 0 and 2 (8 + 2)
 *      or
 *     Pair found at index 1 and 4 (7 + 3)
 *
 *
 **/

public class FindPair {

    public static void main(String[] args){

        int[] A = { 8, 7, 2, 5, 3, 1 };
        int sum = 10;

        //O(n2)
        findPairA(A, sum);

        // O(n log(n))
        findPairB(A, sum);

        //// O(n)
        findPairB(A, sum);

    }

    // Naive Approach with time complexity of O(n2)
    static void findPairA(int[] array, int sum){

        for(int i = 0; i<array.length; i++){

            for(int j = 0; j<array.length; j++){

                if(array[i] + array[j] == sum){
                    System.out.println("Pair found at index " + i + " and " + j);
                    return;
                }
            }
        }

        // we reach here if the pair is not found
        System.out.println("Pair not found");

    }


    // O(n log(n)) solution using Sorting
    static void findPairB(int[] array, int sum){

        // sort the array in ascending order
        Arrays.sort(array);

        // maintain two indices pointing to endpoints of the array
        int low = 0;
        int high = array.length - 1;

        // reduce the search space `A[low…high]` at each iteration of the loop
        // loop till the search space is exhausted
        while(low < high){

            if(array[low] + array[high] == sum){
                System.out.println("Pair found at index " + low + " and " + high);
                return;
            }

            // increment `low` index if the total is less than the desired sum;
            // decrement `high` index if the total is more than the desired sum
            if(array[low] < array[high]){
                low++;
            }else{
                high++;
            }
        }

        // we reach here if the pair is not found
        System.out.println("Pair not found");

    }

    // O(n) solution using Hashing
    static void findPair(int[] array, int sum){

        // create empty hashmap
        HashMap<Integer, Integer> store = new HashMap<>();

        for(int i = 0; i<array.length; i++){
            // get the complement of the sum/target and the current element in the array
            int complement = sum - array[i];

            // Check if the complement exist in the store(Hashmap) - if exists it means pair found
            if(store.containsKey(complement)){
                System.out.println("Pair found at index " + store.get(complement) + " and " + i);
                return;
            }

            // Continue to put the element in the array as key and index as value in the Hashmap
            store.put(array[i], i);
        }
    }


}


