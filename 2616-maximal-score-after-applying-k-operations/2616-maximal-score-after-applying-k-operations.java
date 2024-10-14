class Solution {
    public long maxKelements(int[] nums, int k) {
       PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
       for(int num : nums)
       maxHeap.add(num);
       long score = 0;
       for(int i = 0; i < k; i++){
        int largest = maxHeap.poll();
        score += largest;
        maxHeap.add((largest + 2) / 3);
       }
       return score;
    }
}