class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int resIndex = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!deque.isEmpty() && deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }
            // maintain decreasing oder, delete all indices with small num
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }
            deque.offerLast(right);
            if (right >= k - 1) {
                res[resIndex] = nums[deque.peekFirst()];
                resIndex++;
            }
        }
        
        return res;
    }
}
