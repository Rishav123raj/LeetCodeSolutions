class Solution {
    private int[] freqDigit(int n){
        int freq[] = new int[10];
        while(n > 0){
            freq[n % 10]++;
            n /= 10;
        }
        return freq;
    }

    private boolean freqEqual(int a[], int b[]){
        for(int i = 0; i < 10; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

    public boolean reorderedPowerOf2(int n) {
        int target[] = freqDigit(n);

        for(int i = 0; i <= 30; i++){
            int powerOfTwo = (int) Math.pow(2, i);
            if(freqEqual(target, freqDigit(powerOfTwo))){
                return true;
            }
        }
        return false;
    }
}