class Solution {
    public static String invertString(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                sb.append('0');
            } else {
                sb.append('1');
            }
        }
        return sb.toString();
    }

    public static String reverseString(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public char findKthBit(int n, int k) {
        String dp[] = new String[n];
        dp[0] = "0";
        for(int i = 1; i < n; i++){
            dp[i] = dp[i - 1] + "1" + reverseString(invertString(dp[i - 1]));
        }
        
        String ans = dp[n - 1];
        return ans.charAt(k - 1);
    }
}