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
    private int count = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return count;
    }

    private void dfs(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.val >= max) {
                count++;
                return;
            }
        }
        max = Math.max(max, root.val);
        dfs(root.left, max);
        dfs(root.right, max);
        if (root.val >= max) {
            count++;
            System.out.println(root.val);
        }
    }
}
