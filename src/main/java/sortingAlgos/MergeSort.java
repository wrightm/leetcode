package sortingAlgos;

import java.util.Arrays;

/*
             Time Complexity
  Best	        Average	       Worst
  Ω(n log(n))	θ(n log(n))	   O(n log(n))
 */
public class MergeSort {
    public static void main(String[] args){
        // int[] nums = {10,5,4,2,1,4,6,5,5,9};
        int[] nums = {4, 3, 2, 5, 1};
        int start = 0;
        int end = nums.length-1;
        sort(nums, start, end);
        System.out.println(String.format("Before: [10,5,4,2,1,4,6,5,5,9], After: %s", Arrays.toString(nums)));
    }

    public static void sort(int[] nums, int left, int right){
        if (left < right)
        {
            // Find the middle point
            int middle = (left+right)/2;

            System.out.println(String.format("Sort: left = %s, middle = %s, right = %s  ... nums = %s", left, middle, right, Arrays.toString(nums)));


            // Sort first and second halves
            sort(nums, left, middle);
            sort(nums , middle+1, right);

            System.out.println(String.format("Before: left = %s, middle = %s, right = %s  ... nums = %s", left, middle, right, Arrays.toString(nums)));
            // Merge the sorted halves
            merge(nums, left, middle, right);
            System.out.println(String.format("After: left = %s, middle = %s, right = %s  ... nums = %s", left, middle, right, Arrays.toString(nums)));
        }
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    private static void merge(int[] numbs, int left, int middle, int right){
        // Find sizes of two subarrays to be merged
        int nLeft = middle - left + 1;
        int nRight = right - middle;

        /* Create temp arrays */
        int[] L = new int [nLeft];
        int[] R = new int [nRight];

        /*Copy data to temp arrays*/
        for (int i=0; i<nLeft; ++i)
            L[i] = numbs[left + i];
        for (int j=0; j<nRight; ++j)
            R[j] = numbs[middle + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = left;
        while (i < nLeft && j < nRight)
        {
            if (L[i] <= R[j])
            {
                numbs[k] = L[i];
                i++;
            }
            else
            {
                numbs[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < nLeft)
        {
            numbs[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < nRight)
        {
            numbs[k] = R[j];
            j++;
            k++;
        }

    }

    private static void swap(int[] numbs, int i, int j){
        int temp = numbs[j];
        numbs[j] = numbs[i];
        numbs[i] = temp;
    }
}
