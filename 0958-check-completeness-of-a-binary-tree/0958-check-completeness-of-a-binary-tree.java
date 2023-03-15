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

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while (qu.peek() != null) {
            TreeNode node = qu.poll();
            qu.offer(node.left);
            qu.offer(node.right);
        }
        while (!qu.isEmpty() && qu.peek() == null) {
            qu.poll();
        }
        return qu.isEmpty();
    }
}
