class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean isTrue[] = new boolean[baskets.length];
        int unplacedCount = 0;
        for(int i = 0; i < fruits.length; i++){
            boolean placed = false;
            for(int j = 0; j < baskets.length; j++){
                if(fruits[i] <= baskets[j] && !isTrue[j]){
                    isTrue[j] = true;
                    placed = true;
                    break;
                }
            }
            if(!placed){
                unplacedCount++;
            }
        }

        return unplacedCount;
    }
}