package strings;

import java.util.Arrays;

/*
*
*
    82.
    Problem Statement: Given a set of strings, find the longest common prefix.

    Examples:

    Input: {"geeksforgeeks", "geeks", "geek", "geezer"}
    Output: "gee"

    Input: {"apple", "ape", "april"}
    Output: "ap"
*
*
* */
public class LongestCommonPrefix {

    public static void main(String[] args){
        String[] input = {"techie delight", "tech", "techie",
                "technology", "technical"};
        System.out.println( "The Longest Common Prefix is : " +
                longestCommonPrefix(input));

        System.out.println( "The Longest Common Prefix is : " +
                findLCP(input));
    }

    // Using sorting
    private static String longestCommonPrefix(String[] a){

        int size = a.length;

        /* if size is 0, return empty string */
        if(size == 0){
            return "";
        }

        if(size == 1){
            return a[0];
        }

        /* sort the array of strings */
        Arrays.sort(a);

        /* find the minimum length from first and last string */
        int end = Math.min(a[0].length(), a[size - 1].length());

        /* find the common prefix between the first and
           last string */
        int i = 0;
        while (i < end && a[0].charAt(i) == a[size-1].charAt(i)){
            i++;
        }

        String prefix =  a[0].substring(0, i);

        return prefix;
    }

    // Looping and comparing first string with other ones;
    public static String LCP(String firstString, String currentString){

        int i = 0, j = 0;

        while (i < firstString.length() && j < currentString.length()){
            if(firstString.charAt(i) == currentString.charAt(i)){
                i++;
                j++;
            }
        }

        String prefix = firstString.substring(0, i);
        return prefix;
    }

    public static String findLCP(String[] a){

        String prefix = a[0];
        for( String current: a){
            prefix = LCP(prefix, current);
        }

        return prefix;
    }


}
