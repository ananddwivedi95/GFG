// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // code here
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<asteroids.length;i++)
        {
            int value=asteroids[i];
            if(stack.isEmpty() ||value>0)
            {
                stack.push(value);
            }
            else
            {
                while(!stack.isEmpty())
                {
                    int top=stack.peek();
                    
                    if(top<0)
                    {
                        stack.push(value);
                        break;
                    }
                    int absValue=Math.abs(value);
                    if(top==absValue)
                    {
                        stack.pop();
                        break;
                    }
                    else if(top>absValue)
                    {
                        break;
                    }
                    else if(top<absValue)
                    {
                        stack.pop();
                        if(stack.isEmpty())
                        {
                            stack.push(value);
                            break;
                        }
                    }
                }
            }
        }
        int[] result= new int[stack.size()];
        for(int i=result.length-1;i>=0;i--)
        {
            result[i]=stack.pop();
        }
        return result;
    }
}
