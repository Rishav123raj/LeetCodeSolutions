class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] > 0) right = mid - 1;
            else left = mid + 1;
        }

        int posCount = n - left; // left is the index of first positive element

        left = 0;
        right = n - 1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] < 0) left = mid + 1;
            else right = mid - 1;
        }

        int negCount = right + 1;

        return Math.max(posCount, negCount);
    }
}