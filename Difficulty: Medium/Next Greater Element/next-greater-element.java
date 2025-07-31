class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        
        Stack<Integer> stack= new Stack<>();
        ArrayList<Integer> list= new ArrayList<Integer>();
       
       
       for(int i=arr.length-1;i>=0;i--)
       {
           while(!stack.isEmpty()&&stack.peek()<=arr[i])
           {
               stack.pop();
           }
           if(stack.isEmpty())
           {
               list.add(0,-1);
           }
           else
           {
               list.add(0,stack.peek());
           }
           stack.push(arr[i]);
       }
        return list;
    }
}