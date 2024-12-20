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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int oddLevel = 0;
        
        while(!q.isEmpty()){
            int len = q.size();
            List<TreeNode> temp = new ArrayList<>();
            while(len-- > 0){
                TreeNode node = q.poll();
                temp.add(node);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }

            if(oddLevel % 2 == 1){
                int n = temp.size();
                for(int i = 0; i < n / 2; i++){
                    int value = temp.get(i).val;
                    temp.get(i).val = temp.get(n - 1 - i).val;
                    temp.get(n - 1 - i).val = value;
                }
            }
            oddLevel++;
        }
        return root;
    }
}