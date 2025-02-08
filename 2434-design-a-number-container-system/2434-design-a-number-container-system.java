class NumberContainers {
    private Map<Integer, PriorityQueue<Integer>> result;
    private Map<Integer, Integer> index_value;

    public NumberContainers() {
        result = new HashMap<>();
        index_value = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(index_value.containsKey(index)){
            int prevNum = index_value.get(index);
            if(prevNum == number) return;
            result.get(prevNum).remove(index);
        }

        result.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index);
        index_value.put(index, number);
    }
    
    public int find(int number) {
        PriorityQueue<Integer> pq = result.getOrDefault(number, new PriorityQueue<>());
        return pq.isEmpty() ? -1 : pq.peek();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */