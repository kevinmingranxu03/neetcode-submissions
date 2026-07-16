class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int[] edge : edges) {
            if (!visited[edge[0]]) {
                dfs(graph, edge[0], visited);
                count++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
            }
        }
        return count;
    }

    private void dfs(List<List<Integer>> graph, int node, boolean[] visited) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            dfs(graph, neighbor, visited);
        }
    }
}
