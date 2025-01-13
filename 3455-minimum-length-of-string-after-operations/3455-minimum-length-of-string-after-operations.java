class Solution {
    public int minimumLength(String s) {
        int freqCount[] = new int[26];
        int minLen = 0;
        
        for(char c : s.toCharArray()){
            freqCount[c - 'a']++;
        }

        for(int freq : freqCount){
            if(freq == 0) continue;
            minLen += (freq % 2 ==0) ? 2 : 1;
        }
        return minLen;
    }
}