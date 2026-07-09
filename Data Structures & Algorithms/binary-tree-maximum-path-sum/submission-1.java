/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxPath;
    }

    private int pathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, pathSum(root.left));
        int right = Math.max(0, pathSum(root.right));
        int sum = root.val + left + right;
        maxPath = Math.max(maxPath, sum);        
        return root.val + Math.max(left, right);
    }
}
