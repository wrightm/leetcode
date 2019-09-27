package stringAndArrays;

import java.util.Arrays;

/*
 Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

  1  2  3  4
  5  6  7  8
  9  10 11 12
  13 14 15 16

 */
public class FindDiagonalOrder {

    public static void main(String[] args){
        // [[1,2],[3,4],[5,6],[7,8]]
        int[][] matrix = new int[4][2];
        int[] rowOne   = {1,2};
        int[] rowTwo   = {3,4};
        int[] rowThree = {5,6};
        int[] rowFour  = {7,8};
        matrix[0] = rowOne;
        matrix[1] = rowTwo;
        matrix[2] = rowThree;
        matrix[3] = rowFour;

        int[] diagonalOrder = findDiagonalOrder(matrix);

        System.out.println(Arrays.toString(diagonalOrder));
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new int[0];
        }
        int nRows = matrix.length;
        int nColumns = matrix[0].length;
        int nElements = nRows * nColumns;
        int direction = 1;
        int[] diagonalOrder = new int[nRows * nColumns];
        int row = 0;
        int column = 0;
        int currentElement = 0;
        while(nElements != currentElement){
            diagonalOrder[currentElement] = matrix[row][column];

            if(direction == -1){
                if(column - 1 >= 0 && row + 1 <= nRows - 1){
                    column -= 1;
                    row += 1;
                } else if(row + 1 <= nRows - 1){
                    row += 1;
                    direction = -direction;
                } else if(column + 1 <= nColumns -1){
                    column += 1;
                    direction = -direction;
                }
            } else {
                if(column + 1 <= nColumns - 1 && row - 1 >= 0){
                    column += 1;
                    row -= 1;
                } else if(column + 1 <= nColumns - 1){
                    column += 1;
                    direction = -direction;
                } else if(row + 1 <= nRows - 1){
                    row += 1;
                    direction = -direction;
                }
            }
            currentElement += 1;
        }
        return diagonalOrder;
    }
}
