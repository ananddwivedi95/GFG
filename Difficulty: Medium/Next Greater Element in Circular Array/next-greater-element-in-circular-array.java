class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        
        Stack<Integer> stack = new Stack<>();
        int[] duplicate= new int[arr.length*2];
        
        ArrayList<Integer> list= new ArrayList<>();
        int index=0;
        for(int i=0;i<arr.length;i++)
        {
            duplicate[index++]=arr[i];
        }
        for(int i=0;i<arr.length;i++)
        {
            duplicate[index++]=arr[i];
        }
        
        for(int i=duplicate.length-1;i>=0;i--)
        {
            while(!stack.isEmpty()&&duplicate[i]>=stack.peek())
            {
                stack.pop();
            }
            if(i<=arr.length-1)
            {
                if(stack.isEmpty())
                {
                    list.add(0,-1);
                }
                else
                {
                    list.add(0,stack.peek());
                }
            }
            stack.push(duplicate[i]);
        }
        return list;
    }
}