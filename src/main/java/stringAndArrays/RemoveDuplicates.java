package stringAndArrays;

import java.util.Arrays;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 *
 * Confused why the returned value is an integer but your answer is an array?
 *
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 *
 * Internally you can think of this:
 *
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 *
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 */
public class RemoveDuplicates {

    public static void main(String[] args){
        int[] example = {0,0,1,1,1,2,2,3,3,4};
        // 0,0,1,1,1,2,2,3,3,4
        // 0,1,1,1,2,2,3,3,4,0
        // 0,1,1,2,2,3,3,4,0,1
        // 0,1,2,2,3,3,4,0,1,1
        // 0,1,2,3,3,4,0,1,1,2
        // 0,1,2,3,4,0,1,1,2,3
        System.out.println(String.format("0,0,1,1,1,2,2,3,3,4 = len %s, %s", removeDuplicates2(example), Arrays.toString(example)));
        int[] example2 = {1,1};
        // 1, 1
        // 1, 1
        System.out.println(String.format("1,1 = len %s, %s", removeDuplicates2(example2), Arrays.toString(example2)));
    }

    public static int removeDuplicates(int[] nums) {
        int duplicates = 0;
        int startOfDup = nums.length;
        for(int i = 0; i < nums.length; i++){
            int current = nums[i];
            boolean first = true;
            int j = i + 1;
            int multiDupCount = j;
            while(multiDupCount < nums.length && nums[j] == current) {
                if(first){
                    first = false;
                    duplicates++;
                }
                int k = j;
                while (k + 1 < startOfDup) {
                    int swap = nums[k + 1];
                    nums[k + 1] = nums[k];
                    nums[k] = swap;
                    k++;
                }
                multiDupCount++;
                startOfDup--;
            }
        }
        return nums.length - duplicates;
    }

    // 0, 0,1,1,1,2,2,3,3,4
    // 0,0, 1,1,1,2,2,3,3,4
    // 0,1, 0,1,1,2,2,3,3,4
    // 0,1,0,1,1, 2,2,3,3,4
    // 0,1,2,1,1, 0,2,3,3,4
    // 0,1,2,1,1,0,2, 3,3,4
    // 0,1,2,3,1,0,2, 1,3,4
    // 0,1,2,3,4,0,2,1,3,1
    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
