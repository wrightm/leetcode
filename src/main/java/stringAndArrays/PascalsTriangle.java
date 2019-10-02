package stringAndArrays;

import java.util.ArrayList;
import java.util.List;

/**
 Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


 In Pascal's triangle, each number is the sum of the two numbers directly above it.

 Example:

 Input: 5
 Output:
 [
      [1],
     [1,1],
    [1,2,1],
   [1,3,3,1],
  [1,4,6,4,1]
 ]
 */
public class PascalsTriangle {

    public static void main(String[] args){
        System.out.println(generate(10));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>(numRows);
        for(int row = 0; row < numRows; row++){
            List<Integer> columns = new ArrayList<>(numRows);
            for(int column = 0; column <= row; column++){
                if(column == 0 || column == row){
                    columns.add(1);
                    continue;
                }
                List<Integer> previousRow = rows.get(row - 1);
                Integer columnValue = previousRow.get(column - 1) + previousRow.get(column);
                columns.add(columnValue);
            }
            rows.add(columns);
        }
        return rows;
    }
}
