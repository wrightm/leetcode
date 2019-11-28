package stringAndArrays;

import java.util.Arrays;

/*
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example:

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args){
        System.out.println(String.format("the smallest subarray we can get from 2,3,1,2,0,0 when the sum = 7 is %s", minSubArrayLen2(7, new int[]{2,3,1,2,0,0})));
        // 2, 3, 1, 2
        // 3, 1, 2, 0, 0
        System.out.println(String.format("the smallest subarray we can get from 2,3,1,2,4,3 when the sum = 7 is %s", minSubArrayLen2(7, new int[]{2,3,1,2,4,3})));
        // 2, 3, 1, 2
        // 3, 1, 2, 4
        // 1, 2, 4, 3
        // 2, 4, 3
        // 4, 3
        System.out.println(String.format("the smallest subarray we can get from 2,4,1,5,4,3 when the sum = 7 is %s", minSubArrayLen2(7, new int[]{2,4,1,5,4,3})));
        // 2, 4, 1
        // 4, 1, 5,
        // 1, 5, 4
        // 5, 4
        // 4, 3
        System.out.println(String.format("the smallest subarray we can get from 2,3,8,2,4,3 when the sum = 7 is %s", minSubArrayLen2(7, new int[]{2,3,8,2,4,3})));
        // 2, 3, 8,
        // 2, 3, 8
        // 3, 8
        // 8
        System.out.println(String.format("the smallest subarray we can get from 2,3,6,2,4,1 when the sum = 20 is %s", minSubArrayLen2(20, new int[]{2,3,6,2,4,1})));
        // 2, 3,
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int smallestSize = 0;
        for(int i = 0; i < nums.length; i++){
            int count = nums[i];
            int size = 1;
            if(count >= s){
                return size;
            }
            for(int j = i+1; j < nums.length; j++){
                count += nums[j];
                size++;
                if(count >= s && (smallestSize > size || smallestSize == 0)){
                    smallestSize = size;
                    if (smallestSize >= nums.length-1-i){
                        return smallestSize;
                    }
                }
            }
        }
        return smallestSize;
    }

    public static int minSubArrayLen2(int s, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            while(sum >= s){
                ans = Math.min(ans, i + 1 - left);
                if(ans == 1){
                    return 1;
                }
                sum -= nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


}
