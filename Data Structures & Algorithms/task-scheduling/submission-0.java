class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        
        int freq = 0;
        for (int c : count) {
            freq = Math.max(c, freq);
        }

        int maxFreqCount = 0;
        for (int c : count) {
            if (c == freq) {
                maxFreqCount++;
            }
        }
        int length = (freq - 1) * (n + 1) + maxFreqCount;
        return Math.max(length, tasks.length);
    }
}
