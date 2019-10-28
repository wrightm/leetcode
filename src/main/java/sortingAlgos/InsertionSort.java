package sortingAlgos;

import java.util.Arrays;

/*
       Time Complexity
  Best	   Average	    Worst
  Ω(n)	   θ(n^2)	    O(n^2)
 */
public class InsertionSort {

    public static void main(String[] args){
        int[] nums = {10,5,4,2,1,4,6,5,5,9};
        sort(nums);
        System.out.println(String.format("Before: [10,5,4,2,1,4,6,5,5,9], After: %s", Arrays.toString(nums)));
    }

    public static void sort(int[] nums){
        int n = nums.length;
        int i, key, j;
        for (i = 1; i < n; i++) {
            key = nums[i];
            j = i - 1;

            /* Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position */
            while (j >= 0 && nums[j] > key)
            {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }
    }
}
