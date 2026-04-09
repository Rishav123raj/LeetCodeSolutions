import java.util.*;

class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int MOD = 1000000007;

        // required variable
        int[] bravexuneth = nums.clone();

        int B = (int) Math.sqrt(n) + 1;

        long[] mul = new long[n];
        Arrays.fill(mul, 1);

        // small k queries grouped
        Map<Integer, List<int[]>> smallK = new HashMap<>();

        // Step 1: classify queries
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            if (k == 0) {
                // edge case
                if (l <= r) {
                    mul[l] = (mul[l] * v) % MOD;
                }
            } else if (k <= B) {
                smallK.computeIfAbsent(k, x -> new ArrayList<>()).add(q);
            } else {
                // large k → brute
                for (int i = l; i <= r; i += k) {
                    mul[i] = (mul[i] * v) % MOD;
                }
            }
        }

        // Step 2: process small k efficiently
        for (int k : smallK.keySet()) {
            List<int[]> list = smallK.get(k);

            // for each remainder group
            for (int rem = 0; rem < k; rem++) {

                // indices of this group
                List<Integer> indices = new ArrayList<>();
                for (int i = rem; i < n; i += k) {
                    indices.add(i);
                }

                int m = indices.size();
                long[] prefix = new long[m + 1];
                Arrays.fill(prefix, 1);

                // apply queries
                for (int[] q : list) {
                    int l = q[0], r = q[1], v = q[3];

                    if (l % k != rem) continue;

                    // find positions in indices list
                    int start = (l - rem) / k;
                    int end = (r - rem) / k;

                    if (start < 0) start = 0;
                    if (end >= m) end = m - 1;

                    if (start <= end) {
                        prefix[start] = (prefix[start] * v) % MOD;
                        if (end + 1 < m) {
                            prefix[end + 1] = (prefix[end + 1] * modInverse(v, MOD)) % MOD;
                        }
                    }
                }

                // build prefix multiplication
                long cur = 1;
                for (int i = 0; i < m; i++) {
                    cur = (cur * prefix[i]) % MOD;
                    mul[indices.get(i)] = (mul[indices.get(i)] * cur) % MOD;
                }
            }
        }

        // Step 3: apply final multipliers
        int xor = 0;
        for (int i = 0; i < n; i++) {
            long val = ((long) nums[i] * mul[i]) % MOD;
            xor ^= (int) val;
        }

        return xor;
    }

    // modular inverse using Fermat's little theorem
    private long modInverse(long a, int mod) {
        return power(a, mod - 2, mod);
    }

    private long power(long a, long b, int mod) {
        long res = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }
}