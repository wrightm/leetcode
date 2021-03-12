package queueandstack;

/*
Given a 2d grid map of '1's (land) and '0's (water),
count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

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
public class NumberOfIslandsDFS {

    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int nRows = grid.length;
        int nColumns = grid[0].length;

        int islandCount = 0;
        for(int i = 0; i < nColumns; i++){
            for(int j = 0; j < nRows; j++){
                if(!countedBefore(j, i, grid)){
                    islandCount++;
                    markCells(j, i, grid);
                }
            }
        }
        return islandCount;
    }

    public static boolean countedBefore(int row, int column, char[][] grid){
        return grid[row][column] == '-' || grid[row][column] == '0';
    }

    public static void markCells(int row, int column, char[][] grid) {
        int nRows = grid.length;
        int nColumns = grid[0].length;

        grid[row][column] = '-';

        if(row+1 < nRows && grid[row+1][column] == '1'){
            markCells(row+1,  column, grid);
        }
        if(column+1 < nColumns && grid[row][column+1] == '1'){
            markCells(row,  column+1, grid);
        }
        if(row-1 >= 0 && grid[row-1][column] == '1'){
            markCells(row-1,  column, grid);
        }
        if(column-1 >= 0 && grid[row][column-1] == '1'){
            markCells(row,  column-1, grid);
        }
    }

    public static void main(String[] args){
        char[][] grid1 = {
                {'1', '0', '1', '0', '1'},
                {'1', '1', '0', '1', '1'},
                {'1', '0', '1', '0', '1'},
                {'0', '1', '1', '1', '0'},
        };

        System.out.println(String.format("Expected 4 and got %s islands", numIslands(grid1)));

        char[][] grid2 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };

        System.out.println(String.format("Expected 1 and got %s islands", numIslands(grid2)));

        char[][] grid3 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1',},
        };

        System.out.println(String.format("Expected 3 and got %s islands", numIslands(grid3)));

        char[][] grid4 = {
                {'1','1','1','1','0'},
                {'1','0','0','1','0'},
                {'1','0','0','1','1'},
                {'1','0','1','0','1'},
        };

        System.out.println(String.format("Expected 2 and got %s islands", numIslands(grid4)));

        char[][] grid5 = {{}};

        System.out.println(String.format("Expected 0 and got %s islands", numIslands(grid5)));

        char[][] grid6 = {
                {'1','0','1','1','1'},
                {'1','0','1','0','1'},
                {'1','1','1','0','1'}
        };

        System.out.println(String.format("Expected 1 and got %s islands", numIslands(grid6)));
    }
}
