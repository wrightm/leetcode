package searchAlgos;

import static java.lang.Math.sqrt;

/*
// The idea of formula is to return higher value of pos
// when element to be searched is closer to arr[hi]. And
// smaller value when closer to arr[lo]
pos = lo + [ (x-arr[lo])*(hi-lo) / (arr[hi]-arr[Lo]) ]

arr[] ==> Array where elements need to be searched
x     ==> Element to be searched
lo    ==> Starting index in arr[]
hi    ==> Ending index in arr[]

Step1: In a loop, calculate the value of “pos” using the probe position formula.
Step2: If it is a match, return the index of the item, and exit.
Step3: If the item is less than arr[pos], calculate the probe position of the left sub-array. Otherwise calculate the same in the right sub-array.
Step4: Repeat until a match is found or the sub-array reduces to zero.

 */
public class InterpolationSearch {
    public static void main(String[] args){
        int[] numbs = {10, 20, 30, 50, 60, 80, 100, 110, 130, 170};
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  110 is found at index = %s", find(numbs, 110)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  99 is found at index = %s", find(numbs, 99)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  10 is found at index = %s", find(numbs, 10)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  20 is found at index = %s", find(numbs, 20)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  30 is found at index = %s", find(numbs, 30)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  50 is found at index = %s", find(numbs, 50)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  60 is found at index = %s", find(numbs, 60)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  80 is found at index = %s", find(numbs, 80)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  100 is found at index = %s", find(numbs, 100)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  110 is found at index = %s", find(numbs, 110)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  130 is found at index = %s", find(numbs, 130)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  170 is found at index = %s", find(numbs, 170)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  5 is found at index = %s", find(numbs, 5)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  175 is found at index = %s", find(numbs, 175)));
    }

    public static int find(int[] nums, int num){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high && num >= nums[low] && num <= nums[high]){
            if(low == high){
                if(nums[low] == num){
                    return low;
                } else {
                    return -1;
                }
            }
            int pos = low + ((num-nums[low])*(high-low) / (nums[high]-nums[low]));

            if(nums[pos] == num){
                return pos;
            } else if(nums[pos] > num){
                high = pos - 1;
            } else {
                low = pos + 1;
            }
        }

        return -1;
    }
}
