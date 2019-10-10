package stringAndArrays;

import java.util.Arrays;

/*

Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.



Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

*/
public class Reverse {

    public static void main(String[] args) {
        int[] countTo10 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        reverse(countTo10, countTo10.length);
        System.out.println(String.format("reverse 1 to 10 = %s", Arrays.toString(countTo10)));

        char[] hello = {'h','e','l','l','o'};
        reverseString(hello);
        System.out.println(String.format("reverse Input: [\"h\",\"e\",\"l\",\"l\",\"o\"], Output: [\"o\",\"l\",\"l\",\"e\",\"h\"], Actual: %s", Arrays.toString(hello)));

        char[] hannah = {'H','a','n','n','a','h'};
        System.out.println(String.format("reverse Input: [\"H\",\"a\",\"n\",\"n\",\"a\",\"h\"], Output:  [\"h\",\"a\",\"n\",\"n\",\"a\",\"H\"], Actual: %s", Arrays.toString(hannah)));

    }


    public static void reverseString(char[] chars) {
        int startIndex = 0;
        int endIndex = chars.length - 1;

        while(startIndex < endIndex){

            char first = chars[startIndex];
            chars[startIndex] = chars[endIndex];
            chars[endIndex] = first;

            startIndex++;
            endIndex--;
        }
    }

    public static void reverse(int[] numbers, int N) {
        int startIndex = 0;
        int endIndex = N - 1;

        while(startIndex < endIndex){

            int first = numbers[startIndex];
            numbers[startIndex] = numbers[endIndex];
            numbers[endIndex] = first;

            startIndex++;
            endIndex--;
        }
    }
}