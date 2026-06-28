class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] content = new int[26];
        for (char c : s1.toCharArray()) {
            content[c - 'a']++;
        }
        int left = 0;
        int right = s1.length() - 1;
        
        while (right < s2.length()) {
            int[] target = new int[26];
            for (int i = left; i <= right; i++) {
                target[s2.charAt(i) - 'a']++;
            }
            
            if (Arrays.equals(content, target)) {
                return true;
            }
            
            left++;
            right++;
        }
        return false;
    }
}
