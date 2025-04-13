class Solution {
    static final long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;

        long pow5 = modPow(5, even, MOD);
        long pow4 = modPow(4, odd, MOD);

        return (int)((pow5 * pow4) % MOD);
    }

    private long modPow(long base, long exp, long mod){
        long result = 1;
        base %= mod;
        while(exp > 0){
            if(exp % 2 == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }
}