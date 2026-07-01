class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int right = m * n - 1;
        int left = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] < target) {
                left = mid + 1;
            } else if (matrix[row][col] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
