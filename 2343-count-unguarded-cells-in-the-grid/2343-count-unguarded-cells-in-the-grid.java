class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int grid[][] = new int[m][n];
        for(int g[] : guards){
            grid[g[0]][g[1]] = 7;
        }
        for(int w[] : walls){
            grid[w[0]][w[1]] = 23;
        }
        for(int val[] : guards){
            int row = val[0];
            int col = val[1];

            for(int i = row + 1; i < m; i++){
                if(grid[i][col] == 7 || grid[i][col] == 23) break;
                grid[i][col] = 1;
            }

            for(int i = row - 1; i >= 0; i--){
                if(grid[i][col] == 7 || grid[i][col] == 23) break;
                grid[i][col] = 1;
            }

            for(int i = col + 1; i < n; i++){
                if(grid[row][i] == 7 || grid[row][i] == 23) break;
                grid[row][i] = 1;
            }

            for(int i = col - 1; i >= 0; i--){
                if(grid[row][i] == 7 || grid[row][i] == 23) break;
                grid[row][i] = 1;
            }
        }

        int unguardedCells = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    unguardedCells++;
                }
            }
        }
        return unguardedCells;
    }
}