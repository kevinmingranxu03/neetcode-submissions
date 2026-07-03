class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always binary search on the shorter array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = (m + n + 1) / 2 - i;

            int nums1Left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1Right = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int nums2Left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                // Found correct partition
                int leftMax = Math.max(nums1Left, nums2Left);

                if ((m + n) % 2 == 1) {
                    return leftMax;
                }

                int rightMin = Math.min(nums1Right, nums2Right);

                return (leftMax + rightMin) / 2.0;
            } else if (nums1Left > nums2Right) {
                // nums1 takes too many elements on the left
                right = i - 1;
            } else {
                // nums1 takes too few elements on the left
                left = i + 1;
            }
        }

        return -1.0;
    }
}