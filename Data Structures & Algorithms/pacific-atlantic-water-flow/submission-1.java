class Solution {
    private int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int col = 0; col < cols; col++) {
            dfs(heights, 0, col, pacific);
        }
        for (int row = 0; row < rows; row++) {
            dfs(heights, row, 0, pacific);
        }
        for (int col = 0; col < cols; col++) {
            dfs(heights, rows - 1, col, atlantic);
        }
        for (int row = 0; row < rows; row++) {
            dfs(heights, row, cols - 1, atlantic);
        }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int i, int j, boolean[][] visited) {
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        for (int[] dir : directions) {
            int newRow = dir[0] + i;
            int newCol = dir[1] + j;
            if (newRow < 0 || newRow >= heights.length || newCol < 0 || newCol >= heights[0].length || visited[newRow][newCol] || heights[newRow][newCol] < heights[i][j]) {
                continue;
            }
            dfs(heights, newRow, newCol, visited);
        }
    }
}
