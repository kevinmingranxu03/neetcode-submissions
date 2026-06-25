class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left <= right) {
            if (!Character.isLetter(s.charAt(left)) && !Character.isDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetter(s.charAt(right)) && !Character.isDigit(s.charAt(right))) {
                right--;
            } else {
                if (s.toLowerCase().charAt(left) != s.toLowerCase().charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
