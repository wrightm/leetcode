package queueandstack;

/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */
public class NumberOfIslands {


    public static int numIslands(char[][] grid) {
        int nRows = grid.length;
        int nColumns = grid[0].length;

        int nIslands = 0;
        /*
        {'1','0','1','0','1'},
        {'1','1','0','1','1'},
        {'1','0','1','0','1'},
        {'0','1','1','1','0'}
         */
        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nColumns; j++){
                char cell = grid[i][j];
                if(cell == '1'){

                }
            }
        }

        return nIslands;
    }

    public static void main(String[] args){
//        char[][] grid1 = {
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}
//        };
//
//        System.out.println(String.format("Expect 1 and got %s islands found.", numIslands(grid1)));
//
//        char[][] grid2 = {
//                {'1','1','0','0','0'},
//                {'1','1','0','0','0'},
//                {'0','0','1','0','0'},
//                {'0','0','0','1','1'}
//        };
//
//        System.out.println(String.format("Expected 3 and got %s islands found.", numIslands(grid2)));
//
//        char[][] grid3 = {
//                {'1','0','1','0','1'},
//                {'1','0','1','0','1'},
//                {'1','0','1','0','1'},
//                {'1','0','1','0','1'}
//        };
//
//        System.out.println(String.format("Expected 3 and got %s islands found.", numIslands(grid3)));
//
//        char[][] grid4 = {
//                {'1','0','1','0','1'},
//                {'0','1','0','1','0'},
//                {'1','0','1','0','1'},
//                {'0','1','0','1','0'}
//        };
//
//        System.out.println(String.format("Expected 10 and got %s islands found.", numIslands(grid4)));

        char[][] grid5 = {
                {'1','0','1','0','1'},
                {'1','1','0','1','1'},
                {'1','0','1','0','1'},
                {'0','1','1','1','0'}
        };

        System.out.println(String.format("Expected 4 and got %s islands found.", numIslands(grid5)));
    }
}
