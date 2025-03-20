class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        int m = prerequisites.length;
        for(int i = 0; i < m; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int inDeg[] = new int[n];

        for(int i = 0; i < n; i++){
            for(int e : adj.get(i)){
                inDeg[e]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int order[] = new int[n];
        int index = 0;
        for(int i = 0; i < n; i++){
            if(inDeg[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            order[index++] = node;
            for(int e : adj.get(node)){
                inDeg[e]--;
                if(inDeg[e] == 0){
                    queue.add(e);
                }
            }
        }

        if(n == index) return order;
        int ans[] = {};
        return ans;
    }
}