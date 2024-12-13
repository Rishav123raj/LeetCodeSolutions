class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][2];

        for(int i = 0; i < n; i++){
            dp[i][0] = nums[i];
            dp[i][1] = i;
        }

        Arrays.sort(dp, (a, b) -> a[0] - b[0]);

        boolean visited[] = new boolean[n];
        long result = 0;
        for(int arr[] : dp){
            int value= arr[0];
            int index = arr[1];

            if(!visited[index]){
                result += value;

                visited[index] = true;
                if(index > 0) visited[index - 1] = true;
                if(index < n - 1) visited[index + 1] = true;
            }
        }

        return result;
    }
}