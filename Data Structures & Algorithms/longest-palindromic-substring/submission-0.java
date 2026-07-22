class Solution {
    private int start;
    private int maxLen;
    public String longestPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            palindromic(s, i, i);
            palindromic(s, i, i + 1);
        }
        return s.substring(start, start + maxLen);
    }

    private void palindromic(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int len = right - left - 1;
        if (len > maxLen) {
            maxLen = len;
            start = left + 1;
        }
    }
}
