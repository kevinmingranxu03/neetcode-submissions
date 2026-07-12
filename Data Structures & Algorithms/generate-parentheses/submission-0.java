class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtracking(n, 0, 0, sb, res);
        return res;
    }

    private void backtracking(int n, int open, int close, StringBuilder sb, List<String> res) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            backtracking(n, open + 1, close, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            backtracking(n, open, close + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
