class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        int left = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (need[rightChar] > 0) {
                count--;
            }
            need[rightChar]--;

            while (count == 0) {
                int curLen = right - left + 1;
                if (curLen < minLen) {
                    minLen = curLen;
                    start = left;
                }
                char leftChar = s.charAt(left);
                need[leftChar]++;
                if (need[leftChar] > 0) {
                    count++;
                }
                left++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + minLen);
    }
}
