class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int operation = 0;
        for(int i = n - 1; i >= 0; i--){
            if(nums[i] > k) {
                operation++;
            while(i > 0 && nums[i] == nums[i - 1]){
                i--;
            }
            }
            else if(nums[i] < k) return -1;
        }
        return operation;
    }
}