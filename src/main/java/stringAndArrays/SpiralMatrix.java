package stringAndArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {

    public static void main(String[] args){
        int[][] matrix = new int[4][4];
        int[] rowOne = {1,2,3,4};
        int[] rowTwo = {5,6,7,8};
        int[] rowThree = {9,10,11,12};
        int[] rowFour = {13,14,15,16};
        matrix[0] = rowOne;
        matrix[1] = rowTwo;
        matrix[2] = rowThree;
        matrix[3] = rowFour;

        System.out.println(String.format("spiralOrder: %s", spiralOrder(matrix)));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0){
            return new ArrayList<>();
        }

        int nRows = matrix.length;
        int nColumns = matrix[0].length;
        int nElements = nRows * nColumns;
        int currentElement = 0;
        List<Integer> spiralAccount = new ArrayList<>();
        int currentDirection = 0;
        int row = 0;
        int column = 0;
        int marker = -9999;
        while (nElements != currentElement){

            spiralAccount.add(matrix[row][column]);
            matrix[row][column] = marker;

            // Move right
            if(currentDirection == 0){
                // End of column, move down one row
                if(column+1 > nColumns-1 && row+1 <= nRows-1 && matrix[row+1][column] != marker){
                    row += 1;
                    currentDirection = 1;
                }
                // If column already visited move to next row if possible
                else if (row+1 <= nRows-1 && column+1 <= nColumns-1 && matrix[row][column+1] == marker){
                    row += 1;
                    currentDirection = 1;
                }
                else {
                    column += 1;
                }
            }
            // Move down
            else if(currentDirection == 1){
                // End of row, move left
                if(row+1 > nRows-1 && column-1 >= 0 && matrix[row][column-1] != marker){
                    column -= 1;
                    currentDirection = 2;
                }
                // If row already visited move to next column if possible
                else if (column-1 >= 0 && row+1 <= nRows-1 && matrix[row+1][column] == marker){
                    column -= 1;
                    currentDirection = 2;
                }
                else {
                    row += 1;
                }
            }
            // Move left
            else if(currentDirection == 2){
                // End of column, move up one row
                if(column-1 < 0 && row-1 >= 0 && matrix[row-1][column] != marker){
                    row -= 1;
                    currentDirection = 3;
                }
                // If column already visited move to next row if possible
                else if(row-1 >= 0 && column-1 >= 0 && matrix[row][column-1] == marker){
                    row -= 1;
                    currentDirection = 3;
                }
                else {
                    column -= 1;
                }
            }
            // Move up
            else if(currentDirection == 3){
                // Top of row, move right
                if(row-1 < 0 && column+1 <= nColumns -1 && matrix[row][column+1] != marker){
                    column += 1;
                    currentDirection = 0;
                }
                // If row already visited move to next column if possible
                else if(column+1 <= nColumns -1 && row-1 >= 0 && matrix[row-1][column] == marker) {
                    column += 1;
                    currentDirection = 0;
                }
                else {
                    row -= 1;
                }
            }
            currentElement++;
        }
        return spiralAccount;
    }
}
