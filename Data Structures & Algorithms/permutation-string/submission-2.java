class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] s = s1.toCharArray();
        Arrays.sort(s);
        String key = new String(s);
        int length = s1.length();
        int left = 0;
        for (int right = length; right <= s2.length(); right++) {
            String sub = s2.substring(left, right);
            char[] arr = sub.toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);
            System.out.println(str);
            if (key.equals(str)) {
                return true;
            }
            left++;
        }
        return false;
    }
}
