class Solution {
    public int[][] generateMatrix(int n) {
        int matrix[][]=new int[n][n];
        int stRow=0,stCol=0,endRow=n-1,endCol=n-1;
        int a=1;
        while((stRow<=endRow)&&(stCol<=endCol)){
        for(int i=stCol;i<=endCol;i++){
            matrix[stRow][i]=a;
            a++;
        }
        stRow++;
        for(int i=stRow;i<=endRow;i++){
            matrix[i][endCol]=a;
            a++;
        }
        endCol--;
        if(stRow<=endRow){
        for(int i=endCol;i>=stCol;i--){
            matrix[endRow][i]=a;
            a++;
        }
        endRow--;
        }
        if(stCol<=endCol){
        for(int i=endRow;i>=stRow;i--){
            matrix[i][stCol]=a;
            a++;
        }
        stCol++;
    }
        }
    return matrix;
}
}