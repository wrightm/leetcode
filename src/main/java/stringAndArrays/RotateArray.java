package stringAndArrays;

import java.util.Arrays;

/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 */
public class RotateArray {

    public static void main(String[] args){
        int[] nums1 = {1,2,3,4,5,6,7};
        rotate(nums1, 3);
        System.out.println(String.format("Input: [1,2,3,4,5,6,7] and k = 3, Output: %s", Arrays.toString(nums1)));
        int[] nums2 = {-1,-100,3,99};
        rotate(nums2, 2);
        System.out.println(String.format("[-1,-100,3,99] and k = 2, Output: %s", Arrays.toString(nums2)));
        int[] numbs3 = {1,2};
        rotate(numbs3, 3);
        System.out.println(String.format("[1, 2] and k = 3, Output: %s", Arrays.toString(numbs3)));
        int[] numbs4 = { -1 };
        rotate(numbs4, 2);
        System.out.println(String.format("[-1 ] and k = 2, Output: %s", Arrays.toString(numbs4)));
        int[] numbs5 = { 1, 2, 3 };
        rotate(numbs5, 4);
        System.out.println(String.format("[1, 2, 3] and k = 4, Output: %s", Arrays.toString(numbs5)));

        int[] nums6 = {1,2,3,4,5,6,7};
        rotateInplace(nums6, 3);
        System.out.println(String.format("Inplace - Input: [1,2,3,4,5,6,7] and k = 3, Output: %s", Arrays.toString(nums6)));
        int[] nums7 = {-1,-100,3,99};
        rotateInplace(nums7, 2);
        System.out.println(String.format("Inplace - [-1,-100,3,99] and k = 2, Output: %s", Arrays.toString(nums7)));
        int[] numbs8 = {1,2};
        rotateInplace(numbs8, 3);
        System.out.println(String.format("Inplace - [ - 1, 2] and k = 3, Output: %s", Arrays.toString(numbs8)));
        int[] numbs9 = { -1 };
        rotateInplace(numbs9, 2);
        System.out.println(String.format("Inplace - [-1 ] and k = 2, Output: %s", Arrays.toString(numbs9)));
        int[] numbs10 = { 1, 2, 3 };
        rotateInplace(numbs10, 4);
        System.out.println(String.format("Inplace - [1, 2, 3] and k = 4, Output: %s", Arrays.toString(numbs10)));
        int[] numbs11 = { 1, 2, 3 };
        rotateInplace(numbs11, 2);
        System.out.println(String.format("Inplace - [1, 2, 3] and k = 2, Output: %s", Arrays.toString(numbs11)));
        int[] numbs12 = { 1, 2, 3, 4, 5, 6 };
        rotateInplace(numbs12, 1);
        System.out.println(String.format("Inplace - [1, 2, 3, 4, 5, 6] and k = 1, Output: %s", Arrays.toString(numbs12)));
    }

    public static void rotate(int[] nums, int k) {
        int multiple = k / nums.length + ((k % nums.length == 0) ? 0 : 1);
        int rotateStart = (multiple * nums.length) - k;
        int start = 0;
        int endOfRotate = rotateStart-1;
        int[] rotated = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            if(rotateStart != nums.length) {
                rotated[i] = nums[rotateStart];
                rotateStart++;
            } else if(start <= endOfRotate){
                rotated[i] = nums[start];
                start++;
            }
        }

        for(int i = 0; i < nums.length; i++){
            nums[i] = rotated[i];
        }
    }

    public static void rotateInplace(int[] nums, int k) {
        int multiple = k / nums.length + ((k % nums.length == 0) ? 0 : 1);
        int rotateStart = (multiple * nums.length) - k;
        int start = rotateStart;
        int prev = rotateStart - 1;
        int count = 0;

        // 9 10 11 12 | 1 2 3 4 | 5 6 7 8

        // 1 2 3 4 | 5 6 7 8 | 9 10 11 12
        // 9 10 11 12 | 5 6 7 8 | 1 2 3 4

        // 1 | 2 3 4 5 | 6
        // 1 2 3 4 6 5
        // 1 2 3 6 4 5
        // 1 2 6 3 4 5
        // 1 6 2 3 4 5
        // 6 1 2 3 4 5

        // 1 2 3 4 | 5 6 7

        while(rotateStart < nums.length && rotateStart > 0){
            int swap = nums[prev];
            nums[prev] = nums[start];
            nums[start] = swap;
            if(prev <= count){
                rotateStart++;
                start = rotateStart;
                prev = rotateStart - 1;
                count++;
            } else {
                prev--;
                start--;
            }
        }

    }

}
