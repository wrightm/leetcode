package searchAlgos;

public class ExponentialSearch {
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

        int start = 0;
        int end = nums.length;
        int stepSize = 2;
        for(int index = 1; index < nums.length; index = index * stepSize){
            if(nums[index-1] > num){
                start = (index-1) / stepSize;
                end = index-1;
                break;
            } else if(nums[index-1] == num){
                return index-1;
            }
        }

        return binarySearch(nums, start, end, num);
    }

    public static int binarySearch(int[] nums, int start, int end, int num){
        int halfWay = start + ((end - start) / 2);

        if(start > end) {
            return -1;
        }
        else if(nums[halfWay] == num){
            return halfWay;
        } else if(nums[halfWay] > num && halfWay-1 > 0){
            return binarySearch(nums, start, halfWay-1,num);
        } else if(nums[halfWay] < num && halfWay + 1 < nums.length){
            return binarySearch(nums, halfWay+1, nums.length,num);
        }
        return -1;
    }
}
