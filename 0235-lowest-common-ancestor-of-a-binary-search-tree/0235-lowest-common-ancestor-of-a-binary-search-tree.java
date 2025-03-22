/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return root;
        int value = root.val;
        if(p.val < value && q.val < value){
            return helper(root.left, p, q);
        }
        if(p.val > value && q.val > value){
            return helper(root.right, p, q);
        }
        return root;
    }
}