class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        heap.offer(new int[]{0, 0});
        int totalCost = 0;
        int connected = 0;
        while (connected < n) {
            int[] cur = heap.poll();
            int pointIndex = cur[0];
            int cost = cur[1];
            if (visited[pointIndex]) {
                continue;
            }
            visited[pointIndex] = true;
            totalCost += cost;
            connected++;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int dist = Math.abs(points[pointIndex][0] - points[i][0]) + Math.abs(points[pointIndex][1] - points[i][1]);
                    heap.offer(new int[]{i, dist});
                }
            }
        }
        return totalCost;
    }
}
