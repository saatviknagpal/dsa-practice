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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        boolean flag = false;
        q.add(root);

        while (!q.isEmpty()) {
            LinkedList<Integer> ans = new LinkedList<>(); //initialized a linkedlist because addFirst & addLast method works in it only.
            int count = q.size();
            for (int i = 0; i < count; i++) {
                if (q.peek().left != null) {
                    q.add(q.peek().left);
                }
                if (q.peek().right != null) {
                    q.add(q.peek().right);
                }
                if (flag) {
                    ans.addFirst(q.poll().val); //addFirst method adds the elements at the beginning of the list
                } else {
                    ans.addLast(q.poll().val); //the addLast method adds the elements at the end
                }
            }
            flag = !flag;
            res.add(ans);
        }
        return res;
    }
}
