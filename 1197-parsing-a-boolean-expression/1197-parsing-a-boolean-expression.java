class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for(char c : expression.toCharArray()){
            if(c != ')' && c != ',') stack.push(c);
            else if(c == ')'){
                ArrayList<Boolean> exp = new ArrayList<>();
                while(!stack.isEmpty() && stack.peek() != '('){
                    char t = stack.pop();
                    if(t == 't') exp.add(true);
                    else exp.add(false);
                }
                stack.pop();
                if(!stack.isEmpty()){
                    char t = stack.pop();
                    boolean v = exp.get(0);
                    if(t == '&'){
                        for(boolean b : exp) v &= b;
                    }
                    else if(t == '|'){
                        for(boolean b : exp) v |= b;
                    }
                    else{
                        v = !v;
                    }
                    if(v) stack.push('t');
                    else stack.push('f');
                }
            }
        }
        return stack.peek() == 't';
    }
}