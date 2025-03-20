class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];
        visited[0] = true;
        canVisit(visited, rooms, 0);
        for(boolean v : visited){
            if(!v) return false;
        }
        return true;
    }

    public static void canVisit(boolean visited[], List<List<Integer>> rooms, int start){
        for(int room : rooms.get(start)){
            if(!visited[room]){
                visited[room] = true;
                canVisit(visited, rooms, room);
            }
        }
    }
}