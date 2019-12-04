package stringAndArrays;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {

    public static void main(String[] args){
        int[] example = {0,1,0,3,12};
        moveZeroes(example);
        System.out.println(String.format("0,1,0,3,12 to %s", Arrays.toString(example)));
        int[] example2 = {0,1,0,3,12,0,1,3,4,5,0,1,3,4,5,0};
        moveZeroes(example2);
        System.out.println(String.format("0,1,0,3,12,0,1,3,4,5,0,1,3,4,5,0 to %s", Arrays.toString(example2)));
        int[] example3 = {0,0,0,0};
        moveZeroes(example3);
        System.out.println(String.format("0,0,0,0 to %s", Arrays.toString(example3)));
        int[] example4 = {0,0,1};
        moveZeroes(example4);
        System.out.println(String.format("0,0,1 to %s", Arrays.toString(example4)));


        int[] exampl5 = {0,1,0,3,12};
        moveZeroes2(exampl5);
        System.out.println(String.format("Type 2: 0,1,0,3,12 to %s", Arrays.toString(exampl5)));
        int[] example6 = {0,1,0,3,12,0,1,3,4,5,0,1,3,4,5,0};
        moveZeroes2(example6);
        System.out.println(String.format("Type 2: 0,1,0,3,12,0,1,3,4,5,0,1,3,4,5,0 to %s", Arrays.toString(example6)));
        int[] example7 = {0,0,0,0};
        moveZeroes2(example7);
        System.out.println(String.format("Type 2: 0,0,0,0 to %s", Arrays.toString(example7)));
        int[] example8 = {0,0,1};
        moveZeroes2(example8);
        System.out.println(String.format("Type 2: 0,0,1 to %s", Arrays.toString(example8)));

        int[] exampl9 = {0,1,0,3,12};
        moveZeroes3(exampl9);
        System.out.println(String.format("Type 3: 0,1,0,3,12 to %s", Arrays.toString(exampl9)));
        int[] example10 = {0,1,0,3,12,0,1,3,4,5,0,1,3,4,5,0};
        moveZeroes3(example10);
        System.out.println(String.format("Type 3: 0,1,0,3,12,0,1,3,4,5,0,1,3,4,5,0 to %s", Arrays.toString(example10)));
        int[] example11 = {0,0,0,0};
        moveZeroes3(example11);
        System.out.println(String.format("Type 3: 0,0,0,0 to %s", Arrays.toString(example11)));
        int[] example12 = {0,0,1};
        moveZeroes3(example12);
        System.out.println(String.format("Type 3: 0,0,1 to %s", Arrays.toString(example12)));
    }

    // 0,1,0,3,12
    //
    // 1 3 0 0 12
    // 1 3

    public static void moveZeroes(int[] nums) {
        for(int i = 0; i < nums.length; i++){
           if(nums[i] == 0){
               for(int j = i+1; j < nums.length; j++){
                    if(nums[j] != 0){
                        int swap = nums[j];
                        nums[j] = nums[i];
                        nums[i] = swap;
                        break;
                    }
               }
           }
        }
    }

    public static void moveZeroes2(int[] nums) {
        int lastNonZero = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[lastNonZero++] = nums[i];
            }
        }

        for(int i = lastNonZero; i < nums.length; i++){
            nums[i] =  0;
        }
    }

    public static void moveZeroes3(int[] nums) {
        int lastNonZero = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int swap = nums[lastNonZero];
                nums[lastNonZero] = nums[i];
                nums[i] = swap;
                lastNonZero++;
            }
        }
    }
}
