package sortingAlgos;

import java.util.Arrays;

/*
          Time Complexity
  Best	        Average	       Worst
  Ω(nk)	        θ(nk)	       O(nk)

 */
public class RadixSort {
    public static void main(String[] args){
        int[] nums = {10,5,4,2,1,4,6,5,5,9};
        int end = nums.length;
        sort(nums, end);
        System.out.println(String.format("Before: [10,5,4,2,1,4,6,5,5,9], After: %s", Arrays.toString(nums)));
    }

    // A utility function to get maximum value in arr[]
    static int getMax(int[] nums, int n)
    {
        int mx = nums[0];
        for (int i = 1; i < n; i++)
            if (nums[i] > mx)
                mx = nums[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int[] nums, int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ (nums[i]/exp)%10 ]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (nums[i]/exp)%10 ] - 1] = nums[i];
            count[ (nums[i]/exp)%10 ]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            nums[i] = output[i];
    }

    // The main function to that sorts nums[] of size n using
    // Radix Sort
    static void sort(int nums[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(nums, n);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(nums, n, exp);
    }
}
