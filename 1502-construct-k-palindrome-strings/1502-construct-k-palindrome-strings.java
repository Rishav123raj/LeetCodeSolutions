class Solution {
    public boolean canConstruct(String s, int k) { 
        Map<Character, Integer> map = new HashMap<>();
        int odd = 0;
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int freq : map.values()){
            if(freq % 2 == 1){
                odd++;
            }
        }

        return odd <= k && k <= s.length();
    }
}