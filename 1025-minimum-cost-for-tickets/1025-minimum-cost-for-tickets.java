class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int left7 = 0, left30 = 0;
        int dp[] = new int[n];

        for(int i = 0; i < n; i++){
            while(days[i] - days[left7] >= 7) left7++;
            while(days[i] - days[left30] >= 30) left30++;
            
            int cost1 = (i > 0 ? dp[i - 1] : 0) + costs[0];
            int cost7 = (left7 > 0 ? dp[left7 - 1] : 0) + costs[1];
            int cost30 = (left30 > 0 ? dp[left30 - 1] : 0) + costs[2];

            dp[i] = Math.min(Math.min(cost1, cost7), cost30);
        }

        return dp[n - 1];
    }
}