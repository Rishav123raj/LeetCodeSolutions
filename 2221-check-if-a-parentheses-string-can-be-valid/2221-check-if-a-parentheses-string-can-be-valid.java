class Solution {
    public boolean canBeValid(String s, String locked) {
        int length = s.length();
        if(length % 2 == 1) return false;

        Stack<Integer> openIndex = new Stack<>();
        Stack<Integer> unlockedIndex = new Stack<>();
        for(int i = 0; i < length; i++){
            if(locked.charAt(i) == '0'){
                unlockedIndex.push(i);
            }
            else if(s.charAt(i) == '('){
                openIndex.push(i);
            }
            else if(s.charAt(i) == ')'){
                if(!openIndex.isEmpty()){
                    openIndex.pop();
                }
                else if(!unlockedIndex.isEmpty()){
                    unlockedIndex.pop();
                }
                else{
                    return false;
                }
            }
        }

        while(!openIndex.isEmpty() && !unlockedIndex.isEmpty() && openIndex.peek() < unlockedIndex.peek()){
            openIndex.pop();
            unlockedIndex.pop();
        }

        if(openIndex.isEmpty() && !unlockedIndex.isEmpty()){
            return unlockedIndex.size() % 2 == 0;
        }
        return openIndex.isEmpty();
    }
}