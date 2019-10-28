package sortingAlgos;

import java.util.Arrays;

/*
       Time Complexity
  Best	   Average	    Worst
  Ω(n)	   θ(n^2)	    O(n^2)
 */
public class BubbleSort {

    public static void main(String[] args){
        int[] nums = {10,5,4,2,1,4,6,5,5,9};
        sort(nums);
        System.out.println(String.format("Before: [10,5,4,2,1,4,6,5,5,9], After: %s", Arrays.toString(nums)));
    }

    public static void sort(int[] nums){
        for(int i=0; i < nums.length-1; i++) {
            for(int j=0; j < nums.length-i-1; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}
