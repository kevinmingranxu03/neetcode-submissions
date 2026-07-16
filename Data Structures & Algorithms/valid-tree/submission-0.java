class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

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
        dfs(graph, 0, visited);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
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
