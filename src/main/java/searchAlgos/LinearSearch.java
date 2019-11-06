package searchAlgos;

/*
Linear Search
Problem: Given an array arr[] of n elements, write a function to search a given element x in arr[].

Examples :

Input : arr[] = {10, 20, 80, 30, 60, 50,
                     110, 100, 130, 170}
          x = 110;
Output : 6
Element x is present at index 6

Input : arr[] = {10, 20, 80, 30, 60, 50,
                     110, 100, 130, 170}
           x = 175;
Output : -1
Element x is not present in arr[].
 */
public class LinearSearch {

    public static void main(String[] args){
        int[] numbs = {10, 20, 80, 30, 60, 50, 110, 100, 130, 170};
        System.out.println(String.format("For array [10, 20, 80, 30, 60, 50, 110, 100, 130, 170]------  110 is found at index = %s", find(numbs, 110)));
        System.out.println(String.format("For array [10, 20, 80, 30, 60, 50, 110, 100, 130, 170]------  99 is found at index = %s", find(numbs, 110)));
    }

    public static int find(int[] nums, int num){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == num){
                return i;
            }
        }
        return -1;
    }
}
