class Solution {
    public int countMinReversals(String s) {
        // code here
        if(s.length()%2!=0){
            return -1;
        }
        
        Stack<Character> stack= new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='{')
            {
                stack.push(ch);
            }
            else
            {
                // in case of empty stack or invalid parenthsys
                if(stack.isEmpty() || stack.peek()=='}')
                {
                    stack.push(ch);
                }
                else
                {   
                    // in case of valid parenthesis 
                    stack.pop();
                }
            }
        }
        int ans=0,open=0,close=0;
        while(!stack.isEmpty())
        {
            if(stack.pop()=='{')
            {
                open++;
            }
            else
            {
                close++;
            }
        }
        
        ans= (int)(Math.ceil(open/2.0)+Math.ceil(close/2.0));
        return ans;
    }
}