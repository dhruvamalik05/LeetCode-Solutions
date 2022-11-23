class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stck = new Stack<>();
        for (int i = 0 ; i < s.length();  i++)
        {
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='[')
            {
                stck.push(c);
            }
            else if (c=='}' || c==']' || c==')')
            {
                if (stck.size()==0)
                {
                    return false;
                }
                else if(c==')'&&stck.peek()!='(')
                {
                    return false;
                }
                else if(c=='}'&&stck.peek()!='{')
                {
                    return false;
                }
                else if (c==']'&&stck.peek()!='[')
                {
                    return false;
                }
                stck.pop();
            }
        }
        
        if(stck.size()!=0)
        {
            return false;
        }
        return true;
    }
}