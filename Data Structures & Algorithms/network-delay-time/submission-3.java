class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int t = time[2];
            graph.get(u).add(new int[]{v, t});
        }

        int[] dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {return a[1] - b[1];});
        heap.offer(new int[]{k, 0});
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int node = cur[0];
            int curDist = cur[1];
            if (curDist > dist[node]) {
                continue;
            }
            for (int[] neighbor : graph.get(node)) {
                int next = neighbor[0];
                int weight = neighbor[1];
                int newDist = curDist + weight;
                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    heap.offer(new int[]{next, newDist});
                }
            }
        }
        int answer = 0;
        for (int i = 0; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            answer = Math.max(answer, dist[i]);
        }
        return answer;
    }

}
