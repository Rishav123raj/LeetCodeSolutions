class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int x1 = 0, x2 = 0;
        
        if(l1 % 2!= 0){
            for(int num : nums2){
                x2 ^= num;
            }
        }

        if(l2 % 2!= 0){
            for(int num : nums1){
                x2 ^= num;
            }
        }

        return x1 ^ x2;
    }
}