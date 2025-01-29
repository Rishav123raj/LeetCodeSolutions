class Solution {
    private int parent[];
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];

        for(int i = 1; i <= n; i++) parent[i] = i;

        for(int edge[] : edges){
            if(!union(edge[0], edge[1])){
                return edge;
            }
        }
        return new int[0];
    }

    private int find(int node){
        if(parent[node] != node){
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    private boolean union(int u, int v){
        int pru = find(u);
        int prv = find(v);

        if(pru == prv) return false;
        parent[pru] = prv;
        return true;
    }
}