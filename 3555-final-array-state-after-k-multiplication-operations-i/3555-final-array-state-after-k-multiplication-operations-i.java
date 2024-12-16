class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {

        PriorityQueue<int[]> pQueue = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]){
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        for(int i = 0; i < nums.length; i++){
            pQueue.add(new int[] {nums[i], i});
        }

        while(k-- > 0){
            int smallest[] = pQueue.poll();
            smallest[0] *= multiplier;
            pQueue.add(smallest);
        }

        while(!pQueue.isEmpty()){
            int value[] = pQueue.poll();
            nums[value[1]] = value[0];
        }

        return nums;
    }
}