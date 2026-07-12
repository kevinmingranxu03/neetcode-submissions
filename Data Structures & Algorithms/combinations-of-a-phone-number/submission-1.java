class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<>();
        for (char d : digits.toCharArray()) {
            if (d == '2') {
                map.put(2, "abc");
            } else if (d == '3') {
                map.put(3, "def");
            } else if (d == '4') {
                map.put(4, "ghi");
            } else if (d == '5') {
                map.put(5, "jkl");
            } else if (d == '6') {
                map.put(6, "mno");
            } else if (d == '7') {
                map.put(7, "pqrs");
            } else if (d == '8') {
                map.put(8, "tuv");
            } else if (d == '9') {
                map.put(9, "wxyz");
            }
        }

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
