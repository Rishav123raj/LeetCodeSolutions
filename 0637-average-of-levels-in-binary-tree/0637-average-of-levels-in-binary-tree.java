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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            double sum = 0;
            int length = queue.size();
            for(int i = 0; i < length; i++){
                TreeNode ele = queue.poll();
                sum += ele.val;
                if(ele.left != null) queue.add(ele.left);
                if(ele.right != null) queue.add(ele.right);
            }
            ans.add(sum / length);
        }
        return ans;
    }
}