class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];
            graph.get(b).add(a);
            indegree[a]++;
        }
        int count = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                count++;
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}
