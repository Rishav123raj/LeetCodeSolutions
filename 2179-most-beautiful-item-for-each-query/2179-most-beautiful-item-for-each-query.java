class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int n = items.length;
        int maxBeauty[] = new int[n];
        maxBeauty[0] = items[0][1];

        for(int i = 1; i < n; i++){
            maxBeauty[i] = Math.max(maxBeauty[i - 1], items[i][1]);
        }

        int ans[] = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int query = queries[i];
            int left = 0, right = n- 1;
            while(left <= right){
                int mid = (left + right) / 2;
                if(items[mid][0] <= query)
                left = mid + 1;
                else
                right = mid - 1;
            }
            ans[i] = right >= 0 ? maxBeauty[right] : 0;
        }
        return ans;
    }
}