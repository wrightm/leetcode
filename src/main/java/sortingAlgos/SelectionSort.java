package sortingAlgos;

// 	    Time Complexity
// Best	    Average	    Worst
// Ω(n^2)	 θ(n^2)	    O(n^2)
public class SelectionSort {
    public static void sort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int lowestIndex = i;
            for (int j = i + 1; j < nums.length; j++ ){
                if(nums[lowestIndex] > nums[j]){
                    lowestIndex = j;
                }
            }
            int current = nums[i];
            nums[i] = nums[lowestIndex];
            nums[lowestIndex] = current;
        }
    }
}
