class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        int l = 0, r = n - 1;
        int firstSum = skill[0] + skill[n - 1];
        for(int i = 1; i < (n / 2); i++){
            int pairSum = skill[i] + skill[n - 1 - i];
            if(pairSum != firstSum){
                return -1;
            }
        }

        long chemistry = 0;
        while(l < r){
            chemistry += (long) skill[l] * skill[r];
            l++;
            r--;
        }
        return chemistry;
    }
}