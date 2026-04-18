class Solution {
    public int mirrorDistance(int n) {
        int copyn = 0;
        copyn = n;
        int reversen = 0;
        while(n != 0){
            reversen = (reversen * 10) + (n % 10);
            n /= 10;
        }

        return Math.abs(copyn - reversen);
    }
}