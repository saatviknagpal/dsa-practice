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
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        
        boolean rev = false;
        
        if (root == null) return res;

        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> ans = new ArrayList<>();
            int count = q.size();
            for (int i = 0; i < count; i++) {
                if(!rev){
                    TreeNode current = q.pollFirst();
                    ans.add(current.val);
                    
                    if(current.left != null){
                        q.addLast(current.left);
                    }
                    if(current.right != null){
                        q.addLast(current.right);
                    }
                    
                } else {
                    TreeNode current = q.pollLast();
                    ans.add(current.val);
                    
                    
                    if(current.right != null){
                        q.addFirst(current.right);
                    }
                    if(current.left != null){
                        q.addFirst(current.left);
                    }
                }
                
               
            }
            rev = !rev;
            res.add(ans);
        }
        
        return res;

    }
}