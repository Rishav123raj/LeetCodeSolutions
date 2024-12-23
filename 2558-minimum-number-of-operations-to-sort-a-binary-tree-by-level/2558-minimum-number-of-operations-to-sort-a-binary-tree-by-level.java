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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int ans = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            int arr[] = temp.stream().mapToInt(Integer::intValue).toArray();
            ans += minimumSwaps(arr);
        }

        return ans;
    }

    private int minimumSwaps(int arr[]){
        Map<Integer, Integer> map = new HashMap<>();
        int temp[] = arr.clone();
        Arrays.sort(temp);
        for(int i = 0; i < arr.length; i++){
            map.put(temp[i], i);
        }
        int ans = 0;
        for(int i = 0; i < arr.length;){
            int ind = map.get(arr[i]);
            if(ind == i) i++;
            else {
                int tmp = arr[i];
                arr[i] = arr[ind];
                arr[ind] = tmp;
                ans++;
            }
        }
        return ans;
    }
}