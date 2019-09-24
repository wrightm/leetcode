package stringAndArrays;

import java.util.Arrays;

public class PivotIndex {

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(String.format("nums pivot index: %s", pivotIndex(nums)));
        System.out.println(String.format("nums pivot index 2: %s", pivotIndex2(nums)));
        int[] noPivot = {1, 2, 3};
        System.out.println(String.format("noPivot pivot index: %s", pivotIndex(noPivot)));
        System.out.println(String.format("noPivot pivot index 2: %s", pivotIndex2(noPivot)));
        int[] negativeNumbers = {-1,-1,-1,0,1,1};
        System.out.println(String.format("negativeNumbers pivot index: %s", pivotIndex(negativeNumbers)));
        System.out.println(String.format("negativeNumbers pivot index 2: %s", pivotIndex2(negativeNumbers)));
        int[] negative1 = {-1,-1,0,1,0,-1};
        System.out.println(String.format("negative1 pivot index: %s", pivotIndex(negative1)));
        System.out.println(String.format("negative1 pivot index 2: %s", pivotIndex2(negative1)));

    }

    public static int pivotIndex(int[] nums) {
        int length = nums.length;
        if (length > 10000) {
            return -1;
        }
        for (int pivotIndex = 0; pivotIndex < length; pivotIndex++) {
            int[] numsLeftOfPivot = Arrays.copyOfRange(nums, 0, pivotIndex);
            int[] numsRightOfPivot = Arrays.copyOfRange(nums, pivotIndex + 1, length);
            if (sum(numsLeftOfPivot) == sum(numsRightOfPivot)) {
                return pivotIndex;
            }
        }
        return -1;
    }

    public static int pivotIndex2(int[] nums) {
        int length = nums.length;
        int total = sum(nums);
        int leftSumn = 0;


        for (int pivotIndex = 0; pivotIndex < length; pivotIndex++) {
            if (2*leftSumn == total - nums[pivotIndex]) return pivotIndex;
            leftSumn += nums[pivotIndex];
        }
        return -1;
    }

    private static int sum(int[] nums) {
        int total = 0;
        for (int element : nums) {
            total += element;
        }
        return total;
    }
}
