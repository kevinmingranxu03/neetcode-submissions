class Solution {
    private int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                queue.add(new int[]{0, i});
                visited[0][i] = true;
            }
            if (board[m - 1][i] == 'O') {
                queue.add(new int[]{m - 1, i});
                visited[m - 1][i] = true;
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O') {
                queue.add(new int[]{i, 0});
                visited[i][0] = true;
            }
            if (board[i][n - 1] == 'O') {
                queue.add(new int[]{i, n - 1});
                visited[i][n - 1] = true;
            }
        }

        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            for (int[] dir : directions) {
                int i = loc[0] + dir[0];
                int j = loc[1] + dir[1];
                if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] == 'X') {
                    continue;
                }
                visited[i][j] = true;
                queue.add(new int[]{i, j});
            }
        }
        
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
