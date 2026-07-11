class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used, permutation, res);
        return res;
    }

    private void backtracking(int[] nums, boolean[] used, List<Integer> permutation, List<List<Integer>> res) {
        if (permutation.size() == nums.length) {
            res.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            permutation.add(nums[i]);
            backtracking(nums, used, permutation, res);
            permutation.remove(permutation.size() - 1);
            used[i] = false;
        }

    }
}
