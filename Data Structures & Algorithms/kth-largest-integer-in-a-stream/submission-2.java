class KthLargest {
    private int k;
    private List<Integer> sortedNums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        sortedNums = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length == 0) {
            return;
        }
        for (int i = nums.length - 1; i >= Math.max(0, nums.length - k - 1); i--) {
            sortedNums.add(nums[i]);
        }
    }
    
    public int add(int val) {    
        if (sortedNums.size() == 0) {
            sortedNums.add(val);
        } else {
            for (int i = 0; i < sortedNums.size(); i++) {
                if (val >= sortedNums.get(i)) {
                    sortedNums.add(i, val);
                    break;
                }
            }
        }
        if (sortedNums.size() != k) {
            sortedNums.remove(k);
        }

        return sortedNums.get(k - 1);
    }
}
