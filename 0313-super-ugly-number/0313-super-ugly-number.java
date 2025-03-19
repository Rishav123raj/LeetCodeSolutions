class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long dp[] = new long[n];
        dp[0] = 1;
        int index[] = new int[primes.length];

        for(int i = 1; i < n; i++){
            long min = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++){
                min = Math.min(min, primes[j] * dp[index[j]]);
            }

            dp[i] = min;
            for(int j = 0; j < primes.length; j++){
                if(min == primes[j] * dp[index[j]]){
                    index[j]++;
                }
            }
        }

        return (int)dp[n - 1];
    }
}