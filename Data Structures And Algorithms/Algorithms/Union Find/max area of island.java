//You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

//The area of an island is the number of cells with a value 1 in the island.

//Return the maximum area of an island in grid. If there is no island, return 0.

 

//Example 1:


//Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//Output: 6
//Explanation: The answer is not 11, because the island must be connected 4-directionally.

    public int dfs(int[][] grid, int i, int j) {
        // break condition
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        else {
            // make it 0 or visited
            grid[i][j] = 0;
            return (1 + dfs(grid, i-1, j) + dfs(grid, i+1, j) + dfs(grid, i, j-1) + dfs(grid, i, j+1));
        }
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            int count = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    count = dfs(grid, i, j);
                    if(count > res) res = count;
                }
            }
        }
        return res;
    }
}

//time complexity of O(N²)