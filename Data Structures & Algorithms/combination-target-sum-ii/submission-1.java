class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtracking(candidates, target, 0, 0, combination, res);
        return res;
    }

    private void backtracking(int[] candidates, int target, int start, int sum, List<Integer> combination, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (sum + candidates[i] > target) {
                break;
            }
            combination.add(candidates[i]);
            backtracking(candidates, target, i + 1, sum + candidates[i], combination, res);
            combination.remove(combination.size() - 1);
        }
        
    }
}
