class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] suffix = new int[nums.length];
        pre[0] = 1;
        suffix[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
            suffix[nums.length - 1 - i] = suffix[nums.length - i] * nums[nums.length - i];
        }
        for (int i = 0; i < pre.length; i++) {
            pre[i] *= suffix[i];
        }
        return pre;
    }
}  
