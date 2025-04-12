class Solution {
    List<String> palindroms;

    public long countGoodIntegers(int n, int k) {
        palindroms = new ArrayList<>();
        
        // step 1 : generate all the permutations of 4 digits. 
        palindrom(n, 0, new char[n]);
        // but multiple palindroms can share the same digit set

        // step 2 : check uniqueness of the permutation 
        long total = 0l;
        Set<String> seen = new HashSet<>();
        for (String p : palindroms) {
            long val = Long.parseLong(p);
            if (val % k != 0) continue;

            // Step 3: Count how many unique permutations of digits can form this palindrome
            int[] freq = new int[10];
            for (char c : p.toCharArray()) {
                freq[c - '0']++;
            }

            String sig = buildSignature(freq);
            if (seen.contains(sig)) continue;
            seen.add(sig);


            long count = countPermutations(freq, n);
            total += count;
        }

        return total;
    }

    private String buildSignature(int[] freq) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            if (freq[i] > 0) sb.append(i).append('x').append(freq[i]).append('_');
        }
        return sb.toString();
    }

    // Step 3: Count how many valid n-digit numbers can be formed using the digits
    private long countPermutations(int[] freq, int n) {
        long totalPerms = factorial(n);
        for (int f : freq) {
            totalPerms /= factorial(f);
        }

        // Remove permutations starting with zero
        if (freq[0] == 0) return totalPerms;

        // Count invalid permutations (starting with 0)
        freq[0]--;
        long invalid = factorial(n - 1);
        for (int f : freq) {
            invalid /= factorial(f);
        }
        freq[0]++; // restore

        return totalPerms - invalid;
    }

    private long factorial(int x) {
        long res = 1;
        for (int i = 2; i <= x; i++) res *= i;
        return res;
    }

    private void palindrom(int n, int idx, char[] temp){
        if(idx >= (n+1)/2){
            // capture 
            palindroms.add(new String(temp)); return;
        }

        for(int i=0; i<=9; i++){
            if(i ==0 && idx ==0) continue;  // skip leading zeros

            char ch = (char) (i+'0');
            temp[idx] = ch;
            temp[n-1-idx] = ch;
            palindrom(n, idx+1, temp);
        }
    }

}