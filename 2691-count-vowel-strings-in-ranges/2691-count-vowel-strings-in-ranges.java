class Solution {
    public boolean isVowel(char c) {
        return c == 'a' ||  c == 'e' ||  c == 'i' ||  c == 'o' ||  c == 'u';
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        List<Integer> vowel = new ArrayList<>();
        for(String word : words){
            vowel.add(isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1)) ? 1 : 0);
        }

        int prefSum[] = new int[vowel.size()];
        prefSum[0] = vowel.get(0);
        for(int i = 1; i < vowel.size(); i++){
            prefSum[i] = prefSum[i - 1] + vowel.get(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int query[] : queries){
            int start = query[0];
            int end = query[1];
            ans.add(start == 0 ? prefSum[end] : prefSum[end] - prefSum[start - 1]);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}