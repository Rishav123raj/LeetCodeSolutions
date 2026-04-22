class Solution {
    boolean hasMatch(String query, String dictionary[]) {
        boolean found = false;
        for(String dict : dictionary) {
            int maxDiff = 2;
            for(int i = 0; i < dict.length(); i++) {
                if(dict.charAt(i) != query.charAt(i)) {
                    maxDiff--;
                }
                if(maxDiff < 0) break;
            }
                if(maxDiff >= 0) return true;
            }
        return found;
    }
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        for(String query : queries) {
            if(hasMatch(query, dictionary)) {
                result.add(query);
            }
        }

        return result;
    }
}