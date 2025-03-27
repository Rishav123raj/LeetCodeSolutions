class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        if(grid.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> temp;

        for(int i = 0; i < grid.length; i++){
            temp = new PriorityQueue<>(Collections.reverseOrder());
            for(int j = 0; j < grid[i].length; j++){
                temp.add(grid[i][j]);
            }

            int count = 0;
            while(!temp.isEmpty() && count < limits[i]){
                pq.add(temp.poll());{
                    count++;
                }
            }
        }
        
            long ans = 0, count = 0;
            while(!pq.isEmpty() && count < k){
                ans += pq.poll();
                count++;
            }

            return ans;
    }
}