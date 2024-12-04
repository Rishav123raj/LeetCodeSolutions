class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;
        while(i < str1.length() && j < str2.length()){
            char curr1 = str1.charAt(i);
            char next1 = (char)((curr1 - 'a' + 1) % 26 + 'a');
            if(curr1 == str2.charAt(j) || next1 == str2.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        if(j == str2.length()) return true;
        return false;
    }
}