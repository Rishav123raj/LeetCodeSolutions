class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {

        int distances[] = new int[n];

        for(int i = 0; i < n; i++) distances[i] = n - 1 - i;

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for(int i = 0; i + 1 < n; i++) graph.get(i + 1).add(i);

        int answer[] = new int[queries.length];
        int indQuery = 0;
        
        for(int query[] : queries){
            int src = query[0];
            int tar = query[1];

            graph.get(tar).add(src);
            distances[src] = Math.min(distances[src], distances[tar] + 1);
            distanceUpdate(graph, src, distances);

            answer[indQuery++] = distances[0];
        }

        return answer;
    }

    private void distanceUpdate(List<List<Integer>> graph, int curr, int distances[]){
        int newDist = distances[curr] + 1;
        for(int neighbor : graph.get(curr)){
            if(distances[neighbor] <= newDist) continue;
            distances[neighbor] = newDist;
            distanceUpdate(graph, neighbor, distances);
        }
    }
}