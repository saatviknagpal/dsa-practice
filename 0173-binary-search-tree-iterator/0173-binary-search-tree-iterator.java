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
class BSTIterator {
    private Stack<TreeNode> stack;
    private TreeNode visit;
    public BSTIterator(TreeNode root) {
       visit = root;
       stack = new Stack();
    }
    
    public int next() {
        while(visit != null){
            stack.push(visit);
            visit = visit.left;
        }
        TreeNode next = stack.pop();
        visit = next.right;
        return next.val;
    }
    
    public boolean hasNext() {
        return visit != null || !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */