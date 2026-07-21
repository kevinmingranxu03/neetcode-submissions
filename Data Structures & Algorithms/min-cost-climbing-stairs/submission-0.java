class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] c = new int[n + 1];
        c[0] = 0;
        c[1] = 0;
        for (int i = 2; i <= n; i++) {
            c[i] = Math.min(c[i - 1] + cost[i - 1], c[i - 2] + cost[i - 2]);
        }
        return c[n];
    }
}
