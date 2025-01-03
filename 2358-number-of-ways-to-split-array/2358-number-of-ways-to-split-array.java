class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long totalSum = 0;
        long currSum = 0;
        int count = 0;

        for(int i = 0; i < n; i++){
            totalSum += nums[i];
        }

        for(int i = 0; i < n - 1; i++){
            currSum += nums[i];
            if(currSum >= totalSum - currSum){
                count++;
            }
        }

        return count;
    }
}