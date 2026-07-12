class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");        

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (digits.length() == 0) {
            return res;
        }
        backtracking(digits, 0, sb, res, map);
        return res;
    }

    private void backtracking(String digits, int index, StringBuilder sb, List<String> res, Map<Integer, String> map) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String options = map.get(digits.charAt(index) - '0');

        for (int i = 0; i < options.length(); i++) {
            sb.append(options.charAt(i));
            backtracking(digits, index + 1, sb, res, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
