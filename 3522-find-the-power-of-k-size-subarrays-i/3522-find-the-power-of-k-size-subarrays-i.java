class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int result[] = new int[n - k + 1];
        for(int i = 0; i <= n - k; i++){
            boolean isConsecutive = true;
            for(int j = 0; j < k - 1; j++){
                if(nums[i + j] + 1 != nums[i + j + 1]){
                    isConsecutive = false;
                    break;
                }
            }
            result[i] = isConsecutive ? nums[i + k - 1] : -1;
        }
        return result;
    }
}