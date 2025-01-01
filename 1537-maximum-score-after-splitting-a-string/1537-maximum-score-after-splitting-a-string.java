class Solution {
    public int maxScore(String s) {
        int totalZero = 0;
        for(char c : s.toCharArray()){
            if(c == '0') totalZero++;
        }

        int ans = -1, visitedZero = 0, n = s.length();
        for(int i = 1; i < n; i++){
            if(s.charAt(i - 1) == '0'){
                visitedZero++;
                totalZero--;
            }
            ans = Math.max(ans, visitedZero + (n - totalZero -i));
        }
        return ans;
    }
}