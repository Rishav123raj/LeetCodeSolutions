class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int bad=-1 , min=-1 , max=-1 , n=nums.length;
        long ans=0;
        for(int i=0;i<n;i++){
            if(nums[i]<minK || nums[i]>maxK)
            bad=i;
            if(nums[i]==minK)
            min=i;
            if(nums[i]==maxK)
            max=i;
            ans+=Math.max(0,Math.min(min,max)-bad);
        }
        return ans;
    }
}