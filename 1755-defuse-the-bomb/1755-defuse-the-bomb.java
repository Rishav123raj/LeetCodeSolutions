class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int ans[] = new int[n];
        int start = 1, end = k, sum = 0;
        
        if(k == 0) return ans;

        if( k < 0){
            k = -k;
            start = n - k;
            end = n - 1;
        }
        
        for(int i = start; i <= end; i++){
            sum += code[i % n];
        }

        for(int i = 0; i < n; i++){
            ans[i] = sum;
            sum -= code[start % n];
            sum += code[(end + 1) % n];
            start++;
            end++;
        }

        return ans;
    }
}