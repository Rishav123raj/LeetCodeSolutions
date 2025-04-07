class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num : nums) totalSum += num;
        if(totalSum %2 != 0) return false;
        int targetSum = totalSum / 2;
        boolean dp[] = new boolean[targetSum + 1];
        dp[0] = true;

        for(int num : nums){
            for(int curr = targetSum; curr >= num; curr--){
                dp[curr] = dp[curr] || dp[curr - num];
                if(dp[targetSum]){
                    return true;
                }
            }
        }

        return dp[targetSum];
    }
}