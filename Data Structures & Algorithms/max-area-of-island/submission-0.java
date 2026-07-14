class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, area(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int area(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 + area(grid, i + 1, j) + area(grid, i - 1, j) + area(grid, i, j + 1) + area(grid, i, j - 1);
    }
}
