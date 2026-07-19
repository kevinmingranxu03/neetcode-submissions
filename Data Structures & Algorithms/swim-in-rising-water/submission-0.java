class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];
        heap.offer(new int[]{0, 0, grid[0][0]});
        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int row = cur[0];
            int col = cur[1];
            int time = cur[2];

            if (row == n - 1 && col == n - 1) {
                return time;
            }
            if (time > dist[row][col]) {
                continue;
            }
            for (int[] dir : directions) {
                int i = dir[0] + row;
                int j = dir[1] + col;
                if (i < 0 || i >= n || j < 0 || j >= n) {
                    continue;
                }
                int newTime = Math.max(time, grid[i][j]);
                if (newTime < dist[i][j]) {
                    dist[i][j] = newTime;
                    heap.offer(new int[] {i, j, newTime});
                }
            }
        }
        return -1;
    }
}
