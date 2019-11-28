package stringAndArrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII {

    public static void main(String[] args){
        System.out.println(String.format("Row 0 = %s", getRow(0)));
        System.out.println(String.format("Row 1 = %s", getRow(1)));
        System.out.println(String.format("Row 2 = %s", getRow(2)));
        System.out.println(String.format("Row 3 = %s", getRow(3)));
        System.out.println(String.format("Row 4 = %s", getRow(4)));
        System.out.println(String.format("Row 5 = %s", getRow(5)));
        System.out.println(String.format("Row 6 = %s", getRow(6)));
    }

    // 1
    // 1 1
    // 1 2 1
    // 1 3 3 1
    // 1 4 6 4 1
    // 1 5 10 10 5 1
    // 1 6 15 20 15 6 1

    // [i -1, j -1] + [i-1, j]
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            int value = (int)((long)ans.get(i - 1) * (rowIndex - i + 1) / i);
            ans.add(value);
        }

        return ans;
    }
}
