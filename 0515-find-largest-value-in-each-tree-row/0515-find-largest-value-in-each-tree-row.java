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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<Integer> res=new ArrayList<>();
        queue.offer(root);
        if(root==null)
        return res;
        while(!queue.isEmpty()){
            int l=queue.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<l;i++){
                TreeNode tmp=queue.poll();
                if(tmp.left!=null){
                    queue.offer(tmp.left);
                }
                if(tmp.right!=null){
                    queue.offer(tmp.right);
                }
                max=Math.max(max,tmp.val);
            }
            res.add(max);
        }
        return res;
    }
}