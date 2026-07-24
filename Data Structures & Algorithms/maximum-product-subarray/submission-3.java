class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxDp = nums[0];
        int minDp = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            int prevMax = maxDp;
            int prevMin = minDp;
            maxDp = Math.max(num, Math.max(prevMax * num, prevMin * num));
            minDp = Math.min(num, Math.min(prevMin * num, prevMax * num));
            res = Math.max(maxDp, res);
        }
        return res;
    }
}
