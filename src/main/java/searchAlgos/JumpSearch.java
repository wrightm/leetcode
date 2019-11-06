package searchAlgos;

import static java.lang.Math.sqrt;

public class JumpSearch {
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
        int halfWay = (int) sqrt(nums.length);

        if(halfWay == 0) halfWay = 1;

        for(int index = halfWay; index < nums.length; index += halfWay){
            if(nums[index] == num){
                return  index;
            } else if(nums[index] > num){
                for(int j = index - halfWay; j < index; j++){
                    if(nums[j] == num){
                        return j;
                    }
                }
                return -1;
            }
        }
        return -1;
    }
}
