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
    private int ksmall = 0;
    private int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ksmall;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
    
        dfs(root.left, k);
        count++;
        if (count == k && ksmall == 0) {
            ksmall = root.val;
        }
        dfs(root.right, k);
    }
}
