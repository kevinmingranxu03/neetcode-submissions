class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            set.add(num);
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        int length = 0;
        int temp = 0;
        while(min <= max) {
            if (set.contains(min)) {
                temp++;
            } else {
                length = Math.max(temp, length);
                temp = 0;
            }
            min++;
            
        }
        length = Math.max(temp, length);
        return length;
    }
}
