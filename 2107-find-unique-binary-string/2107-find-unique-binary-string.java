class Solution {
    public String findDifferentBinaryString(String[] nums) {
       StringBuilder res=new StringBuilder();
       for(int i=0;i<nums.length;i++){
           char ch=nums[i].charAt(i);
           res.append((ch=='1')?"0":"1");
       }
       return res.toString();
    }
}