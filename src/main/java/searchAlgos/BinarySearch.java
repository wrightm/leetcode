package searchAlgos;

public class BinarySearch {
    public static void main(String[] args){
        int[] numbs = {10, 20, 30, 50, 60, 80, 100, 110, 130, 170};
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  110 is found at index = %s", find(numbs, 0, numbs.length, 110)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  99 is found at index = %s", find(numbs, 0, numbs.length, 99)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  10 is found at index = %s", find(numbs, 0, numbs.length, 10)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  20 is found at index = %s", find(numbs, 0, numbs.length, 20)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  30 is found at index = %s", find(numbs, 0, numbs.length, 30)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  50 is found at index = %s", find(numbs, 0, numbs.length, 50)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  60 is found at index = %s", find(numbs, 0, numbs.length, 60)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  80 is found at index = %s", find(numbs, 0, numbs.length, 80)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  100 is found at index = %s", find(numbs, 0, numbs.length, 100)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  110 is found at index = %s", find(numbs, 0, numbs.length, 110)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  130 is found at index = %s", find(numbs, 0, numbs.length, 130)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  170 is found at index = %s", find(numbs, 0, numbs.length, 170)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  5 is found at index = %s", find(numbs, 0, numbs.length, 5)));
        System.out.println(String.format("For array [10, 20, 30, 50, 60, 80, 100, 110, 130, 170]------  175 is found at index = %s", find(numbs, 0, numbs.length, 175)));
    }

    public static int find(int[] nums, int start, int end, int num){
        int halfWay = start + ((end - start) / 2);

        if(start > end) {
            return -1;
        }
        else if(nums[halfWay] == num){
            return halfWay;
        } else if(nums[halfWay] > num && halfWay-1 > 0){
            return find(nums, start, halfWay-1,num);
        } else if(nums[halfWay] < num && halfWay + 1 < nums.length){
            return find(nums, halfWay+1, nums.length,num);
        }
        return -1;
    }
}
