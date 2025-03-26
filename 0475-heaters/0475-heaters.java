class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        if(houses == null || heaters == null || houses.length == 0 || heaters.length == 0){
            return 0;
        }

        Arrays.sort(houses);
        Arrays.sort(heaters);

        int n = houses.length;
        int m = heaters.length;

        int i = 0;
        int j = 0;
        int ans = 0;

        while(i < n && j < m){
            int d1 = Math.abs(heaters[j] - houses[i]);
            int d2 = Integer.MAX_VALUE;
            if(j + 1 < m){
                d2 = Math.abs(heaters[j + 1] - houses[i]);
            }
            if(d1 < d2){
                ans = Math.max(ans, d1);
                i++;
            }
            else{
                j++;
            }
        }
        return ans;
    }
}