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
    private int result = 0;
    private int target;

    public int kthSmallest(TreeNode root, int k) {
        target = k;
        inorder(root);
        return result;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);

        count++;
        if (count == target){
            result = root.val;

            return;
        }

        inorder(root.right);

    }

}