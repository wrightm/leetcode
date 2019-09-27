package stringAndArrays;

import java.util.Arrays;

/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.
*/
public class PlusOne {

    public static void main(String[] args){
        int[] digits = {9, 9, 9};
        int[] plusOneDigits = increment(digits, digits.length-1);
        System.out.println(Arrays.toString(plusOneDigits));
    }

    private static int[] increment(int[] digits, int index){
        int[] newArray = Arrays.copyOf(digits, digits.length);
        if(digits[index] == 9){
            if(index > 0){
                newArray[index] = 0;
                newArray = increment(newArray, index-1);
            } else {
                int[] extendArray = new int[newArray.length + 1];
                extendArray[0] = 1;
                for(int j = 1; j < newArray.length; ++j){
                    extendArray[j] = newArray[j];
                }
                newArray = extendArray;
            }
        } else {
            newArray[index] += 1;
        }
        return newArray;
    }
}
