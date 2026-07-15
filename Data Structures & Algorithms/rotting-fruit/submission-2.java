class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int count = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rr = queue.poll();
                if (rr[0] - 1 >= 0 && grid[rr[0] - 1][rr[1]] == 1) {
                    queue.add(new int[]{rr[0] - 1, rr[1]});
                    grid[rr[0] - 1][rr[1]] = 2;
                }
                if (rr[0] + 1 < grid.length && grid[rr[0] + 1][rr[1]] == 1) {
                    queue.add(new int[]{rr[0] + 1, rr[1]});
                    grid[rr[0] + 1][rr[1]] = 2;
                }
                if (rr[1] + 1 < grid[0].length && grid[rr[0]][rr[1] + 1] == 1) {
                    queue.add(new int[]{rr[0], rr[1] + 1});
                    grid[rr[0]][rr[1] + 1] = 2;
                }
                if (rr[1] - 1 >= 0 && grid[rr[0]][rr[1] - 1] == 1) {
                    queue.add(new int[]{rr[0], rr[1] - 1});
                    grid[rr[0]][rr[1] - 1] = 2;
                }
            }
            count++;
        }
        for (int [] row : grid) {
            for (int o : row) {
                if (o == 1) {
                    return -1;
                }
            }
        }
        if (count == -1) {
            return 0;
        }
        return count;
    }
}
