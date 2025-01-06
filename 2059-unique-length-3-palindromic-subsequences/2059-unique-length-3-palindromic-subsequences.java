class Solution {
    public int countPalindromicSubsequence(String s) {
        int min[]=new int[26];
        int max[]=new int[26];
        for(int i=0;i<26;i++){
            min[i]=Integer.MAX_VALUE;
            max[i]=Integer.MIN_VALUE;
        }
        for(int i=0;i<s.length();i++){
            int charIn=s.charAt(i)-'a';
            min[charIn]=Math.min(min[charIn],i);
            max[charIn]=Math.max(max[charIn],i);
        }
        int unique=0;
        for(int i=0;i<26;i++){
            if(min[i]==Integer.MAX_VALUE || max[i]==Integer.MIN_VALUE)
            continue;
            HashSet<Character> between=new HashSet<>();
            for(int j=min[i]+1;j<max[i];j++)
            between.add(s.charAt(j));
            unique+=between.size();
        }
        return unique;
    }
}