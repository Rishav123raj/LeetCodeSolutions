class Solution {
    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public int maxVowels(String s, int k) {
        int ans = 0;

        for(int i = 0; i < k; i++){
            if(isVowel(s.charAt(i))){
                ans++;
            }
        }

        int maxLen = ans;

        for(int i = k; i < s.length(); i++){
            if(isVowel(s.charAt(i - k))){
                ans--;
            }
            if(isVowel(s.charAt(i))){
                ans++;
            }
            maxLen = Math.max(maxLen, ans);
        }

        return maxLen;
    }
}