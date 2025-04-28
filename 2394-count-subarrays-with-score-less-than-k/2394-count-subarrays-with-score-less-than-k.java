class Solution {
    public long countSubarrays(int[] nums, long k) {
        long result = 0, partialSum = 0;
        int left = 0;

        for(int right  = 0; right < nums.length; right++){
            partialSum += nums[right];
            while(partialSum * (right - left + 1) >= k){
                partialSum -= nums[left++];
            }

            result += right - left + 1;
        }

        return result;
    }
}