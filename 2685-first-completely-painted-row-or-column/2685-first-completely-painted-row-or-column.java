class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        Map<Integer, int[]> locMap = new HashMap<>();
        int rowCount[] = new int[row];
        int colCount[] = new int[col];
        Arrays.fill(rowCount, col);
        Arrays.fill(colCount, row);
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                locMap.put(mat[r][c], new int[]{r, c});
            }
        }
        for(int i = 0; i < arr.length; i++){
            int loc[] = locMap.get(arr[i]);
            if(--rowCount[loc[0]] == 0 || --colCount[loc[1]] == 0){
                return i;
            }
        }
        return -1;
    }
}