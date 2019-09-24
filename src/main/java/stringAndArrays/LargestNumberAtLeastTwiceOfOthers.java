package stringAndArrays;

import java.util.Arrays;

/*
In a given integer array nums, there is always exactly one largest element.

Find whether the largest element in the array is at least twice as much as every other number in the array.

If it is, return the index of the largest element, otherwise return -1.

Example 1:

Input: nums = [3, 6, 1, 0]
Output: 1
Explanation: 6 is the largest integer, and for every other number in the array x,
6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.


Example 2:

Input: nums = [1, 2, 3, 4]
Output: -1
Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.


Note:

nums will have a length in the range [1, 50].
Every nums[i] will be an integer in the range [0, 99].

 */
public class LargestNumberAtLeastTwiceOfOthers {

    public static void main(String[] args){
        int[] a = { 3, 6, 1, 0 };
        System.out.println(dominantIndex(a));
        int[] b = { 1, 2, 3, 4 };
        System.out.println(dominantIndex(b));
        int[] c = { 1 };
        System.out.println(dominantIndex(c));
        int[] d = {1,0};
        System.out.println(dominantIndex(d));
        int[] e = {0,1};
        System.out.println(dominantIndex(e));
    }

    public static int dominantIndex2N(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i])
                return -1;
        }
        return maxIndex;
    }

    public static int dominantIndex(int[] nums) {
        if(nums.length == 1) return 0;
        int maxIndex = 0;
        int secondMaxIndex = 1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[maxIndex]) {
                if(i > 0) secondMaxIndex = maxIndex;
                maxIndex = i;
            } else if(nums[i] > nums[secondMaxIndex] && i != maxIndex){
                secondMaxIndex = i;
            }
        }
        if(nums[maxIndex] >= 2*nums[secondMaxIndex]){
            return maxIndex;
        }
        return -1;
    }
}
