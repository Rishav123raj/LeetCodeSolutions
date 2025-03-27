class Solution {
    public long findMaximumScore(List<Integer> nums) {
        long ans = 0;
        int n = nums.size(), j = 0;

        for(int i = 1; i < n; i++){
            if(nums.get(i) > nums.get(j)){
                ans += (long)(i - j) * nums.get(j);
                j = i;
            }
        }

        return ans + (long)(n - 1 - j) * nums.get(j);
    }
}