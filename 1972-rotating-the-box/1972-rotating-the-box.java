class Solution {
    public char[][] rotateTheBox(char[][] box) {

        int rows = box.length;
        int cols = box[0].length;
        char ans[][] = new char[cols][rows];

        for(char row[] : ans){
            Arrays.fill(row, '.');
        }

        for(int r = 0; r < rows; r++){
            int i = cols - 1;
            for(int c = cols - 1; c >= 0; c--){
                if(box[r][c] == '#'){
                    ans[i][rows - r - 1] = '#';
                    i--;
                }
                else if(box[r][c] == '*'){
                    ans[c][rows - r - 1] = '*';
                    i = c - 1;
                }
            }
        }
        return ans;
    }
}