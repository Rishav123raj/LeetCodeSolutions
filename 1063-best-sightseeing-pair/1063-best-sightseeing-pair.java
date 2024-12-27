class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0;
        int previous = values[0];
        for(int j = 1; j < values.length; j++){
            ans = Math.max(ans, previous + values[j] - j);
            previous = Math.max(previous, values[j] + j);
        }
        return ans;
    }
}