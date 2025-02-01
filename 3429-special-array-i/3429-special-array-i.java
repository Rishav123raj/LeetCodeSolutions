class Solution {
    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) return true;
        
        int temp[] = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            if(isEven(nums[i])){
                temp[i] = 1;
            }
            else{
                temp[i] = 0;
            }
        }

        for(int i = 0; i < temp.length - 1; i++){
            if(temp[i] == temp[i + 1]){
                return false;
            }
        }
        return true;
    }

    private boolean isEven(int n){
        return n % 2 == 0;
    }
}