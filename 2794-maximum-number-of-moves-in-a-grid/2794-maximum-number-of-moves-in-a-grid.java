class Solution {
    public int maxMoves(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int maxMovDp[][] = new int[r][c];

        for(int i = 0; i < r; i++){
            maxMovDp[i][0] = 1;
        }

        int maxMoves = 0;
        for(int i = 1; i < c; i++){
            for(int j = 0; j < r; j++){
                int left = (grid[j][i - 1] < grid[j][i] && maxMovDp[j][i - 1] > 0) ? maxMovDp[j][i - 1] + 1 : 0;
                int leftUp = (j - 1 >= 0 && grid[j - 1][i - 1] < grid[j][i] && maxMovDp[j - 1][i - 1] > 0) ? maxMovDp[j - 1][i - 1] + 1 : 0;
                int leftDown = (j + 1 < r && grid[j + 1][i - 1] < grid[j][i] && maxMovDp[j + 1][i - 1] > 0) ? maxMovDp[j + 1][i - 1] + 1 : 0;

                maxMovDp[j][i] = Math.max(left, Math.max(leftUp, leftDown));
                maxMoves = Math.max(maxMoves, maxMovDp[j][i] - 1);
            }
        }
        return maxMoves;
    }
}