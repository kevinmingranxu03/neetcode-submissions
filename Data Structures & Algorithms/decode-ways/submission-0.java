class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            char cur = s.charAt(i - 1);
            // case 1
            if (cur != '0') {
                dp[i] += dp[i - 1];
            }
            // case 2
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit <= 26 && twoDigit >= 10) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
