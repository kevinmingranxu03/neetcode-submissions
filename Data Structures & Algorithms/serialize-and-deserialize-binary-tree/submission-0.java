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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder str = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                str.append("null,");
                continue;
            }
            str.append(cur.val).append(",");
            queue.add(cur.left);
            queue.add(cur.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] arr = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (i < arr.length && !arr[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.add(cur.left);
            }
            i++;
            if (i < arr.length && !arr[i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.add(cur.right);
            }
            i++;
        }
        return root;
    }
}
