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
    public int maxDepth(TreeNode root) {
		if(root == null) return 0 ;
		Queue<TreeNode> q = new LinkedList<>() ;
		q.add(root) ;
		int ans = 0 ;
		while(!q.isEmpty()) {
			ans ++ ;
			int n = q.size() ;
			for(int i = 0;  i< n ; i++) {
				TreeNode x = q.remove() ;
				if(x.left != null) q.add(x.left) ;
				if(x.right != null) q.add(x.right) ;
			}
		}
        return ans ;
    }
}