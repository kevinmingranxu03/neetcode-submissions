class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] <= nums[right]) {
            return nums[left];
        }
        if (nums.length == 2) {
            return nums[right];
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid - 1;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            if (mid >= 1 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
        }
        return -1;
    }
}
