class Solution {
    private int distance(String[] words, int i, int j) {
        if(words[i].length() != words[j].length()) return 2;
        int dist = 0;
        for(int k=0; k<words[i].length() && dist < 2; k++) {
            if(words[i].charAt(k) != words[j].charAt(k))
                dist++;
        }
        return dist;
    }
    private void fill(List<String> ans, int[][] dp, String[] words, int cur) {
        if(cur == dp[cur][1]) {
            ans.add(words[cur]);
            return;
        }
        fill(ans, dp, words, dp[cur][1]);
        ans.add(words[cur]);
    }
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = groups.length;
        int[][] dp = new int[n][2];
        for(int i=0; i<n; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
        }

        int iMax = 0;
        for(int i=1; i<n; i++) {
            for(int j=i-1; j>=0; j--) {
                if(groups[i] == groups[j]) continue;
                if(distance(words, i, j) == 1){
                    if(dp[i][0] < dp[j][0] + 1) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = j;

                        if(dp[i][0] > dp[iMax][0])
                            iMax = i;
                    }
                }
            }
        }
        List<String> ans = new ArrayList<>();
        fill(ans, dp, words, iMax);
        return ans;
    }
}