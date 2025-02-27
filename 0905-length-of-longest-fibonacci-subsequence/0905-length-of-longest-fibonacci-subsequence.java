class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        if(arr.length <= 2) return 0;

        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();

        for(int i = 0; i < n; i++){
            indexMap.put(arr[i],i);
        }

        int maximum = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int prev = arr[j];
                int pPrev = arr[i];
                int len = 2;
                
                while(indexMap.containsKey(prev + pPrev)){
                    len++;
                    maximum = Math.max(maximum, len);
                    int temp = prev;
                    prev = prev + pPrev;
                    pPrev = temp;
                }
            }
        }

        return maximum > 2 ? maximum : 0;
    }
}