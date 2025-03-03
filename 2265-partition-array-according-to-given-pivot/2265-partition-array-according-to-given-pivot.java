class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int result[] = new int[nums.length];
        int l = 0, r = nums.length - 1;

        for(int i = 0, j = nums.length - 1; i < nums.length; i++, j--){
            if(nums[i] < pivot){
                result[l] = nums[i];
                l++;
            }
            if(nums[j] > pivot){
                result[r] = nums[j];
                r--;
            }
        }

        while(l <= r){
            result[l] = pivot;
            l++;
        }

        return result;
    }
}