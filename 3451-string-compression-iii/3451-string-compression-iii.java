class Solution {
    public String compressedString(String word) {
        StringBuilder string = new StringBuilder();
        int count = 1;
        int n = word.length();
        int i = 1;
        while(i < n){
            if(count == 9 || word.charAt(i) != word.charAt(i - 1)){
                string.append(count).append(word.charAt(i - 1));
                count = 1;
                i++;
                continue;
            }
            if(word.charAt(i) == word.charAt(i - 1))
                count++;
                i++;
            }
        return string.append(count).append(word.charAt(n - 1)).toString();
    }
}