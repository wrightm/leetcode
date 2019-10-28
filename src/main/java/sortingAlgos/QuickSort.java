package sortingAlgos;

import java.util.Arrays;

/*
          Time Complexity
  Best	        Average	       Worst
  Ω(n log(n))	θ(n log(n))    O(n^2)

 */
public class QuickSort {
    public static void main(String[] args){
        int[] nums = {10,5,4,2,1,4,6,5,5,9};
        int start = 0;
        int end = nums.length-1;
        sort(nums, start, end);
        System.out.println(String.format("Before: [10,5,4,2,1,4,6,5,5,9], After: %s", Arrays.toString(nums)));
    }

    public static void sort(int[] nums, int low, int high){
        while (low < high) {
            /* pi is partitioning index, arr[p] is now
           at right place */
            int pi = partition(nums, low, high);

            // If left part is smaller, then recur for left
            // part and handle right part iteratively
            if (pi - low < high - pi)
            {
                sort(nums, low, pi - 1);
                low = pi + 1;
            }
            // Else recur for right part
            else
            {
                sort(nums, pi + 1, high);
                high = pi - 1;
            }
        }
    }

    private static int partition(int[] numbs, int low, int high){

        int pivot = numbs[high];

        int i = low - 1;

        for(int j = low; j < high; j++){
            if(numbs[j] < pivot){
                i++;
                swap(numbs, i, j);
            }
        }

        swap(numbs, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] numbs, int i, int j){
        int temp = numbs[j];
        numbs[j] = numbs[i];
        numbs[i] = temp;
    }
}
