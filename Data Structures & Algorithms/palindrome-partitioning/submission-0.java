class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();

        backtracking(s, 0, part, res);
        return res;
    }

    private void backtracking(String s, int index, List<String> part, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(part));
        }

        for (int i = index; i < s.length(); i++) {
            if (!check(s, index, i)) {
                continue;
            }
            part.add(s.substring(index, i + 1));
            backtracking(s, i + 1, part, res);
            part.remove(part.size() - 1);
        }
    }

    private boolean check(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

