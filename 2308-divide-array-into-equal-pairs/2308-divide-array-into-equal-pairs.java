class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> freqCount = new HashMap<>();
        for(int num : nums){
            freqCount.put(num, freqCount.getOrDefault(num, 0) + 1);
        }

        for(int freq : freqCount.values()){
            if(freq % 2 != 0){
                return false;
            }
        }
        return true;
    }
}