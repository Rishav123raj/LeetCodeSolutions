class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer> adj[] = new List[n];
        int inDeg[] = new int[n];
        List<Integer> ans = new ArrayList<>();

        for(int pair[] : prerequisites){
            int course = pair[0];
            int pre = pair[1];
            if(adj[pre] == null){
                adj[pre] = new ArrayList<>();
            }
            adj[pre].add(course);
            inDeg[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(inDeg[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int current = queue.poll();
            ans.add(current);

            if(adj[current] != null){
                for(int next : adj[current]){
                    inDeg[next]--;
                    if(inDeg[next] == 0){
                        queue.offer(next);
                    }
                }
            }
        }

        return ans.size() == n;
    }
}