package stringAndArrays;

import java.util.Arrays;

/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSum {

    public static void main(String[] args){
        int[] numbers = { 2, 7, 11, 15};
        System.out.println(String.format("The sum %s from %s is found in indexes %s", 9, Arrays.toString(numbers), Arrays.toString(twoSum(numbers, 9))));
        System.out.println(String.format("The sum %s from %s is found in indexes %s", 22, Arrays.toString(numbers), Arrays.toString(twoSum(numbers, 22))));
        System.out.println(String.format("The sum %s from %s is found in indexes %s", 1, Arrays.toString(numbers), Arrays.toString(twoSum(numbers, 1))));
        System.out.println(String.format("The sum %s from %s is found in indexes %s", 25, Arrays.toString(numbers), Arrays.toString(twoSum(numbers, 25))));
        System.out.println(String.format("The sum %s from %s is found in indexes %s", 200, Arrays.toString(new int[]{3,24,50,79,88,150,345}), Arrays.toString(twoSum(new int[]{3,24,50,79,88,150,345}, 200))));
    }

    public static int[] twoSum(int[] numbers, int target){
        for(int i = 0 , j = numbers.length - 1, sum = 0 ; i < numbers.length ;)
        {
            if(i < 0 || i > numbers.length-1 || j < 0 || j > numbers.length -1){
                return null;
            }
            sum = numbers[i] + numbers[j];
            if(sum == target)
                return new int[]{i+1,j+1};
            if(sum < target)
                ++i;
            else
                --j;
        }
        return null;
    }

    public static int[] twoSum2(int[] numbers, int target) {
            for(int i = 0; i < numbers.length; i++){
                if(numbers[i] > target){
                    return new int[]{-1, -1};
                }
                int x = target - numbers[i];
                int j = binarySearch(numbers, x);

                if(j != -1){
                    return new int[]{i+1, j+1};
                }
            }
            return new int[]{-1, -1};
    }

    public static int binarySearch(int[] numbers, int num){
        return find(numbers, 0,  numbers.length, num);
    }

    public static int find(int[] nums, int start, int end, int num){
        int halfWay = start + ((end - start) / 2);

        if(start > end) {
            return -1;
        }
        else if(nums[halfWay] == num){
            return halfWay;
        } else if(nums[halfWay] > num && halfWay-1 > 0){
            return find(nums, start, halfWay-1,num);
        } else if(nums[halfWay] < num && halfWay + 1 < nums.length){
            return find(nums, halfWay+1, nums.length,num);
        }
        return -1;
    }
}
