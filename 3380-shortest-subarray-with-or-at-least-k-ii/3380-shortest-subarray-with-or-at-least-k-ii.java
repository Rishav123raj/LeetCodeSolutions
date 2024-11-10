class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int[] bitCount = new int[32];
        int currentOR = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            currentOR |= nums[right];
            
            // Update bit count for the current element
            for (int bit = 0; bit < 32; bit++) {
                if ((nums[right] & (1 << bit)) != 0) {
                    bitCount[bit]++;
                }
            }
            
            // Shrink the window from the left as long as the condition is met
            while (left <= right && currentOR >= k) {
                minLength = Math.min(minLength, right - left + 1);
                
                // Remove `nums[left]` influence from bitCount
                for (int bit = 0; bit < 32; bit++) {
                    if ((nums[left] & (1 << bit)) != 0) {
                        bitCount[bit]--;
                    }
                }
                
                // Recalculate `currentOR` based on updated bit counts
                int updatedOR = 0;
                for (int bit = 0; bit < 32; bit++) {
                    if (bitCount[bit] > 0) {
                        updatedOR |= (1 << bit);
                    }
                }
                currentOR = updatedOR;
                
                // Move the left pointer to shrink the window
                left++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
