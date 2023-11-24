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

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode root, long lowerBound, long upperBound) {
        if (root == null) {
            return true;
        }

        int val = root.val;

        if (val <= lowerBound || val >= upperBound) {
            return false;
        }

        return isValidBSTHelper(root.left, lowerBound, val) && isValidBSTHelper(root.right, val, upperBound);
    }
}
