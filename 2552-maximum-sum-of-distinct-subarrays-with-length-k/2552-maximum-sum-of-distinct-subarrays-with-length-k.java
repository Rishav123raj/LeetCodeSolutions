class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int start = 0, end = 0;
        long max = 0, sum = 0;
        HashSet<Integer> set = new HashSet<>();
        while(end < nums.length){
            int temp = nums[end];
            while(set.contains(temp)){
                set.remove(nums[start]);
                max = max - nums[start];
                start++;
            }

            max = max + temp;
            if((end - start + 1) == k){
                sum = Math.max(max, sum);
                max = max - nums[start];
                set.remove(nums[start]);
                start++;
            }
            set.add(temp);
            end++;
        }
        return sum;
    }
}