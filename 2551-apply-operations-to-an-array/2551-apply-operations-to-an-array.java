class Solution {
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
            nums[i]=nums[i]*2;
            nums[i+1]=0;
        }
        }
        int i=0,j=0;
        while(j<n){
            if(nums[j]!=0){
            nums[i++]=nums[j];
            }
            j++;
        }
        while(i<n){
            nums[i++]=0;
        }
        return nums;
    }
}