class Solution {
    public void islandsAndTreasure(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] grid, int i, int j, int dist) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1 || grid[i][j] < dist) {
            return;
        }
        
        grid[i][j] = dist;
        dfs(grid, i - 1, j, dist + 1);
        dfs(grid, i + 1, j, dist + 1);
        dfs(grid, i, j - 1, dist + 1);
        dfs(grid, i, j + 1, dist + 1);
    }
}
