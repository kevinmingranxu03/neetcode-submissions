class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] content = new int[26];
        for (char c : s1.toCharArray()) {
            content[c - 'a']++;
        }
        
        int right = 0;
        int[] target = new int[26];
        while (right < s2.length()) {
            target[s2.charAt(right) - 'a']++;
            if (right >= s1.length()) {
                char leftChar = s2.charAt(right - s1.length());
                target[leftChar - 'a']--;
            }
            
            if (Arrays.equals(content, target)) {
                return true;
            }
            
            right++;
        }
        return false;
    }
}
