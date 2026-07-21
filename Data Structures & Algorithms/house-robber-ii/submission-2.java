class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int n = nums.length;
        int[] rob = new int[n - 1];
        rob[0] = nums[0];
        rob[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            rob[i] = Math.max(rob[i - 1], rob[i - 2] + nums[i]);
        }
        int[] rob2 = new int[n];
        rob2[1] = nums[1];
        rob2[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < n; i++) {
            rob2[i] = Math.max(rob2[i - 1], rob2[i - 2] + nums[i]);
        } 
        return Math.max(rob2[n - 1], rob[n - 2]);
    }
}
