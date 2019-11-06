package searchAlgos;

import java.util.Arrays;

public class SublistSearch {
    public static void main(String[] args){
        int[] list1 = {10, 20, 30, 50, 60, 80, 100, 110, 130, 170};
        int[] subList1 = {80, 100, 110};
        System.out.println(String.format("%s found in %s with start index %s", Arrays.toString(subList1), Arrays.toString(list1), find(list1, subList1)));

        int[] list2 = {10, 20, 30, 50, 60, 80, 100, 110, 130, 170};
        int[] subList2 = {80, 100, 110, 120};
        System.out.println(String.format("%s not found in %s with start index %s", Arrays.toString(subList2), Arrays.toString(list2), find(list2, subList2)));

        int[] list3 = {10, 20, 30, 50, 60, 80, 100, 110, 130, 170};
        int[] subList3 = {170};
        System.out.println(String.format("%s found in %s with start index %s", Arrays.toString(subList3), Arrays.toString(list3), find(list3, subList3)));

        int[] list4 = {10, 20, 30, 50, 60, 80, 100, 110, 130, 170};
        int[] subList4 = {10};
        System.out.println(String.format("%s found in %s with start index %s", Arrays.toString(subList4), Arrays.toString(list4), find(list4, subList4)));
    }

    public static int find(int[] list, int[] subList){
        for(int i = 0; i < list.length; i++) {
            if (list[i] == subList[0]) {
                boolean match = true;
                int listIndex = i + 1;
                int currentSubListIndex = 1;
                while(listIndex < list.length && currentSubListIndex < subList.length){
                    if(list[listIndex] != subList[currentSubListIndex]){
                        match = false;
                        break;
                    }
                    listIndex++;
                    currentSubListIndex++;
                }
                if (match) return i;
            }
        }
        return -1;
    }
}
