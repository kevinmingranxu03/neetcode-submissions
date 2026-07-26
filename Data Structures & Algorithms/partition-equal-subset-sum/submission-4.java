class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        } 
        int half = sum / 2;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = half; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[half];
    }
}
