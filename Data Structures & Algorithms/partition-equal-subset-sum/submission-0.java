class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        } 
        int half = sum / 2;
        boolean[] dp = new boolean[half];
        int cur = 0;
        for (int i = n - 1; i >= 0; i--) {
            cur += nums[i];
            if (cur > half) {
                cur -= nums[i];
            }
            if (cur == half) {
                return true;
            }
        }
        return false;
    }
}
