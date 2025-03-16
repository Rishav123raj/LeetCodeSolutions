class Solution {
    public boolean timeSuff(int ranks[], int cars, long minTime){
        long carsDone = 0;
        for(int r : ranks){
            long c2 = minTime / r;
            long c = (long) Math.sqrt(c2);
            carsDone += c;
        }
        return carsDone >= cars;
    }
    public long repairCars(int[] ranks, int cars) {
        long l = 1, r = (long) 1e14;
        while(l < r){
            long mid = (l + r) / 2;
            if(timeSuff(ranks, cars, mid)){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return l;
    }
}