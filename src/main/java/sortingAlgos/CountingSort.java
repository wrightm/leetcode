package sortingAlgos;

import java.util.Arrays;




public class CountingSort {


    public static void main(String[] args){
        int[] nums = {10,5,4,2,1,4,6,5,5,9};
        sort(nums);
        System.out.println(String.format("Before: [10,5,4,2,1,4,6,5,5,9], After: %s", Arrays.toString(nums)));
    }

    public static void sort(int[] nums){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(max <= nums[i]){
                max = nums[i];
            } else if(min >= nums[i]){
                min = nums[i];
            }
        }
        // Keep a count of all indexes
        int range = max - min + 1;
        int[] count = new int[range];
        for(int i = 0; i < nums.length; i++){
            count[nums[i]-min]++;
        }

        System.out.println(Arrays.toString(count));
        System.out.println(Arrays.toString(nums));

        // Keep a cumulative count
        for(int i = 1; i < count.length; i++){
            count[i] += count[i - 1];
        }

        // iterate backwards through array. This keeps the relative ordering (stable sort)
        int[] output = new int[nums.length];
        for(int i = nums.length -1; i >= 0; i--){
            output[count[nums[i] - min] - 1] = nums[i];
            count[nums[i]-min]--;
        }

        // update ordered nums
        for (int i = 0; i < nums.length; i++) {
            nums[i] = output[i];
        }
    }
}
