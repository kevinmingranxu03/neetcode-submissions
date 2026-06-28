class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            heap.add(nums[right]);
            if (heap.size() == k) {
                res[left] = heap.peek();
                heap.remove(nums[left]);
                left++;
            }
        }
        return res;
    }
}
