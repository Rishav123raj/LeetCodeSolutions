class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int xorTotal = 0;
        for(int i = 0; i < n; i++){
            xorTotal ^= derived[i];
        }
        
        return xorTotal == 0 ? true : false;
    }
}