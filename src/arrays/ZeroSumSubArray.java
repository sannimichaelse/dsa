package arrays;

import java.util.HashSet;

/**
 *
 *
     2.

     Given an integer array, check if it contains a subarray having zero-sum

     Input:  { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 }

     Output: Subarray with zero-sum exists

     The subarrays with a sum of 0 are:

     { 3, 4, -7 }
     { 4, -7, 3 }
     { -7, 3, 1, 3 }
     { 3, 1, -4 }
     { 3, 1, 3, 1, -4, -2, -2 }
     { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 }

 *
 *
 **/

public class ZeroSumSubArray {

    public static void main(String[] args){
        int[] A = { 4, -6, 3, -1, 4, 2, 7 };
        if (hasZeroSumSubArray(A)) {
            System.out.println("Subarray exists");
        } else {
            System.out.println("Subarray does not exist");
        }
    }

    private static Boolean hasZeroSumSubArray(int[] array){

        // create an empty set to store the sum of elements of each
        // subarray `A[0…i]`, where `0 <= i < arr.length`
        HashSet<Integer> set = new HashSet<>();

        // insert 0 into the set to handle the case when subarray with
        // zero-sum starts from index 0
        set.add(0);

        int sum = 0;

        // traverse the given array
        for(int item: array){

            // sum of elements so far
            sum+= item;

            // if the sum is seen before, we have found a subarray with zero-sum
            if(set.contains(sum)){
                return true;
            }

            // insert sum so far into the set
            set.add(sum);
        }

        // we reach here when no subarray with zero-sum exists
        return false;
    }
}
