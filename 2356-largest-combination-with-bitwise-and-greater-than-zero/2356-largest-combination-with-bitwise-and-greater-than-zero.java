class Solution {
    public int largestCombination(int[] candidates) {
        int result = 0;
        for(int i = 0; i < 32; i++){
            int count = 0;
            for(int candidate : candidates){
                if((candidate & (1 << i)) != 0) count++;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}