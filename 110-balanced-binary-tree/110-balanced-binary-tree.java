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

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);

        if (Math.abs(left - right) > 1) {
            return false;
        }

        boolean is_L_Balance = isBalanced(root.left);
        boolean is_R_Balance = isBalanced(root.right);
        return is_L_Balance && is_R_Balance;
    }

    public int heightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);
        return Math.max(left, right) + 1;
    }
}
