class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, 0, 0, target, combination, res);
        return res;
    }

    private void backtracking(int[] nums, int start, int sum, int target, List<Integer> combination, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(combination));
        }
        if (sum > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (sum + nums[i] > target) {
                return;
            }
            combination.add(nums[i]);
            backtracking(nums, i, sum + nums[i], target, combination, res);
            combination.remove(combination.size() - 1);
        }
    }
}
