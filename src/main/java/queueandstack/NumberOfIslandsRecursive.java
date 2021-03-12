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
public class NumberOfIslandsRecursive {

    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int nRows = grid.length;
        int nColumns = grid[0].length;

        int nIslands = 0;
        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nColumns; j++){
                char cell = grid[i][j];
                if(cell == '1') {
                    if (!countedBefore(i, j, grid)) {
                        nIslands++;
                        markCells(i, j, grid);
                    }
                }
            }
        }
        return nIslands;
    }

    public static boolean countedBefore(int i, int j, char[][] grid){
        boolean counted = false;
        int nRows = grid.length;
        int nColumns = grid[0].length;
        if(i-1 >= 0 && grid[i-1][j] == '-'){
            counted = true;
        }
        if(i+1 < nRows && grid[i+1][j] == '-'){
            counted = true;
        }
        if(j-1 >= 0 && grid[i][j-1] == '-'){
            counted = true;
        }
        if(j+1 < nColumns && grid[i][j+1] == '-'){
            counted = true;
        }
        return counted;
    }

    public static void markCells(int i, int j, char[][] grid){
        int nRows = grid.length;
        int nColumns = grid[0].length;
        grid[i][j] = '-';
        if(i-1 >= 0 && grid[i-1][j] == '1'){
            markCells(i-1, j, grid);
        }
        if(i+1 < nRows && grid[i+1][j] == '1'){
            markCells(i+1, j, grid);
        }
        if(j-1 >= 0 && grid[i][j-1] == '1'){
            markCells(i, j-1, grid);
        }
        if(j+1 < nColumns && grid[i][j+1] == '1'){
            markCells(i, j+1, grid);
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
