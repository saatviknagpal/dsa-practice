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
        if (root == null || (root.left == null && root.right == null))
            return true;
        int leftSubtree = dfs(root.left);
        int rightSubtree = dfs(root.right);

        return Math.abs(leftSubtree - rightSubtree) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        return Math.max(left, right) + 1;
    }
}