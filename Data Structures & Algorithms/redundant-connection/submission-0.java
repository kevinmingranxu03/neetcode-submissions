class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            boolean[] visited = new boolean[n + 1];
            if (dfs(graph, a, b, visited)) {
                return edge;
            }
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return new int[0];
    }

    private boolean dfs(List<List<Integer>> graph, int a, int b, boolean[] visited) {
        if (a == b) {
            return true;
        }
        visited[a] = true;
        for (int neighbor : graph.get(a)) {
            if (!visited[neighbor]) {
                if (dfs(graph, neighbor, b, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
