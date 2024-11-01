class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        result.append(s.charAt(0));
        int n = s.length(), count = 1;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == result.charAt(result.length() - 1)){
                count++;
                if(count <3){
                    result.append(s.charAt(i));
                }
            }
            else{
                count = 1;
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}