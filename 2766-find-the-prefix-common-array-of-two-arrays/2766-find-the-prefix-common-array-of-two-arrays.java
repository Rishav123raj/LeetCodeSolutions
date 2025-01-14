class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int freq[] = new int[A.length];
        int ans[] = new int[A.length];
        int temp = 0;

        for(int i = 0; i < A.length; i++){
            freq[A[i] - 1]++;
            if(freq[A[i] - 1] == 2) temp++;
            freq[B[i] - 1]++;
            if(freq[B[i] - 1] == 2) temp++;
            ans[i] = temp;
        }
        return ans;
    }
}