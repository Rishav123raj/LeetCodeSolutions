class Solution {
    private final int OFFSET = 1000;
    private int dp[][];

    private int solve(int index, int nums[], int target){
        if(index >= nums.length) 
            return target == 0 ? 1 : 0;
        if(dp[index][target + OFFSET] != -1) 
            return dp[index][target + OFFSET];
        int ans = 0;
        ans += solve(index + 1, nums, target + nums[index]);
        ans += solve(index + 1, nums, target - nums[index]);

        return dp[index][target + OFFSET] = ans;
}

    public int findTargetSumWays(int[] nums, int target) {
      dp = new int[nums.length][3002];
      for(int row[] : dp){
        java.util.Arrays.fill(row, -1);
      }
      return solve(0, nums, target);  
    }
}