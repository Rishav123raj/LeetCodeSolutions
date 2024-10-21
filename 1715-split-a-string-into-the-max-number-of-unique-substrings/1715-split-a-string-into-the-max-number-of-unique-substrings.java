class Solution {
    public int maxUniqueSplit(String s) {
        return backtracking(0, s, new HashSet<>());
    }

    private int backtracking(int start, String s, HashSet<String> seen){
        if(start == s.length()) return 0;
        int maxSplits = 0;
        for(int end = start + 1; end <= s.length(); end++){
            String substring = s.substring(start, end);
            if(!seen.contains(substring)){
                seen.add(substring);
                maxSplits = Math.max(maxSplits, 1 + backtracking(end, s, seen));
                seen.remove(substring);
            }
        }
        return maxSplits;
    }
}