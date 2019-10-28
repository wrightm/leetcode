package stringAndArrays;

import java.util.Arrays;

/*
Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].

0
0 1
1
2 3
2
4 5
3
6 7
4
8 9
5
10 11

1,2,3,4,5,
6,7,8,9,10

9 + 7 + 5 + 3 + 1
3

1,4,3,2,10,
23,41,11,10,5

41,23,11,10,10,5,4,3,2,1

23 + 10 + 5 + 3 + 1
 */
public class ArrayPartitionI {

    public static void main(String[] args){
        int[] nums = {1,4,3,2};
        System.out.println(String.format("Input: [1,4,3,2], Expected: 4 and Output: %d", arrayPairSum(nums)));
        int[] biggerNums = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(String.format("Input: [1,2,3,4,5,6,7,8,9,10]], Expected: 25 and Output: %d", arrayPairSum(biggerNums)));
    }

    // Solution uses count sort O(n+k) time complexity
    public static int arrayPairSum(int[] nums) {
        if(nums.length % 2 != 0) return -1;

        int max = -10000;
        int min = 10000;
        for(int i = 0; i < nums.length; i++){
            if(max <= nums[i]){
                max = nums[i];
            }
            if(min >= nums[i]){
                min = nums[i];
            }
        }
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            output[count[nums[i] - min] - 1] = nums[i];
            count[nums[i] - min]--;
        }

        int sum = 0;
        for(int index = 0; index < nums.length; index++){
            int startIndex = 2 * index;
            if(startIndex + 1 < nums.length ){
                if(output[startIndex] <= output[startIndex + 1]){
                    sum += output[startIndex];
                } else {
                    sum += output[startIndex + 1];
                }
            }
        }
        return sum;
    }
}
