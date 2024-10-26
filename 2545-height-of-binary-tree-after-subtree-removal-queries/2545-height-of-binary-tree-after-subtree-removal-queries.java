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
    int pre[] = new int[100001];
    int post[] = new int[100001];
    int maxH = 0;

    private void preOrder(TreeNode root, int height){
        if(root == null) return;

        pre[root.val] = maxH;
        maxH = Math.max(maxH, height);
        preOrder(root.left, height + 1);
        preOrder(root.right, height + 1);
    }

    private void postOrder(TreeNode root, int height){
        if(root == null) return;

        post[root.val] = maxH;
        maxH = Math.max(maxH, height);
        postOrder(root.right, height + 1);
        postOrder(root.left, height + 1);
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        preOrder(root, 0);
        maxH = 0;
        postOrder(root, 0);

        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.max(pre[queries[i]], post[queries[i]]);
        }
        return res; 
    }
}