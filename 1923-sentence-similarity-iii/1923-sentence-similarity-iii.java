class Solution {
    private List<String> covertString(String sentence){
        sentence += " ";
        List<String> ans = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for(int i = 0; i < sentence.length(); i++){
            if(sentence.charAt(i) == ' '){
                ans.add(word.toString());
                word.setLength(0);
            }
            else{
                word.append(sentence.charAt(i));
            }
        }
        return ans;
    }
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.length() < sentence2.length()){
            String temp = sentence1;
            sentence1 = sentence2;
            sentence2 = temp;
        }

        List<String> convX = covertString(sentence1);
        List<String> convY = covertString(sentence2);

        int l = 0;
        for(int i = 0; i < convY.size(); i++){
            if(convX.get(i).equals(convY.get(i))){
                l++;
            }
            else{
                break;
            }
        }

        int ind = convX.size() - 1, r = convY.size();
        for(int i = convY.size() - 1; i >= 0; i--){
            if(convY.get(i).equals(convX.get(ind))){
                ind--;
                r = i;
            }
            else{
                break;
            }
        }
        return r <= l;
    }
}