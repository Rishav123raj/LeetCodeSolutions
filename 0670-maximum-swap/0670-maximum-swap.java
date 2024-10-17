class Solution {
    public int maximumSwap(int num) {
        char numArray[] = Integer.toString(num).toCharArray();
        int n = numArray.length;
        int last[] = new int[10];
        for(int i = 0; i < n; i++){
            last[numArray[i] - '0'] = i;
        }
        for(int i = 0; i < n; i++){
            for(int d = 9; d > numArray[i] - '0'; d--){
                if(last[d] > i){
                    char temp = numArray[i];
                    numArray[i] = numArray[last[d]];
                    numArray[last[d]] = temp;
                    return Integer.parseInt(new String(numArray));
                }
            }
        }
        return num;
    }
}