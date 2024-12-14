class Solution {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer,Integer> freqMap = new TreeMap<>();
        int left = 0, right = 0;
        long count = 0;
        int n = nums.length;

        while(right < n){
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            while(freqMap.lastEntry().getKey() - freqMap.firstEntry().getKey() > 2){
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                if(freqMap.get(nums[left]) == 0){
                    freqMap.remove(nums[left]);
                }
                left++;
            }

            count += right - left + 1;
            right++;
        }
        return count;
    }
}