class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long ans[] = new long[n];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for(List<Integer> index : map.values()) {
            long sum = 0;

            for(int x : index) sum += x;

            long leftSum = 0;
            int m = index.size();

            for(int i = 0; i < m; i++) {
                long rightSum = sum - leftSum - index.get(i);

                long left = (long) index.get(i) * i - leftSum;
                long right = rightSum - (long) index.get(i) * (m - i - 1);

                ans[index.get(i)] = left + right;

                leftSum += index.get(i);
            }
        }

        return ans;
    }
}