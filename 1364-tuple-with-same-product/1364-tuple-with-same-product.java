class Solution {
    public int tupleSameProduct(int[] nums) {
       HashMap<Integer, Integer> prodCount = new HashMap<>();
       int result = 0;

       for(int i = 0; i < nums.length; i++){
        for(int j = i + 1; j < nums.length; j++){
            int product = nums[i] * nums[j];
            result += 8 * prodCount.getOrDefault(product, 0);
            prodCount.put(product, prodCount.getOrDefault(product,0) + 1);
        }
       } 
       return result;
    }
}