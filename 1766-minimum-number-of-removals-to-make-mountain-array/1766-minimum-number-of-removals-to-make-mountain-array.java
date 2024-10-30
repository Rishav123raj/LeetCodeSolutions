class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int longIn[] = new int[nums.length];
        int longDec[] = new int[nums.length];
        Arrays.fill(longIn, 1);
        Arrays.fill(longDec, 1);
        
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j] && longIn[j] + 1 > longIn[i]){
                    longIn[i] = longIn[j] + 1;
                }
            }
        }

        int maxSub = 0;
        for(int i = nums.length - 2; i >= 0; i--){
            for(int j = nums.length - 1; j > i; j--){
                if(nums[i] > nums[j] && longDec[j] + 1 > longDec[i]){
                    longDec[i] = longDec[j] + 1;
                }
            }

            if(longIn[i] > 1 && longDec[i] > 1){
                maxSub = Math.max(longIn[i] + longDec[i] - 1, maxSub);
            }
        }

        return nums.length - maxSub;
    }
}