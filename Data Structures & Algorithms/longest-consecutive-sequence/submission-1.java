class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for(int num : set) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int length = 1;
                while (set.contains(cur + 1)) {
                    length++;
                    cur++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
