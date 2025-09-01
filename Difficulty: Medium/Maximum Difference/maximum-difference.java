class Solution {
    public int findMaxDiff(int[] arr) {
        // code here
        
        int[] leftArr=new int[arr.length];
        int[] rightArr=new int[arr.length];
        
        Stack<Integer> stack1= new Stack<>();
        for(int i=0;i<arr.length;i++)
        {
            while(!stack1.isEmpty()&&stack1.peek()>=arr[i])
            {
                stack1.pop();
            }
            if(stack1.isEmpty())
            {
                leftArr[i]=0;
            }
            else if(stack1.peek()<arr[i])
            {
                leftArr[i]=stack1.peek();
            }
            stack1.push(arr[i]);
        }
        
        Stack<Integer> stack2= new Stack<>();
        for(int i=arr.length-1;i>=0;i--)
        {
            while(!stack2.isEmpty()&&stack2.peek()>=arr[i])
            {
                stack2.pop();
            }
            if(stack2.isEmpty())
            {
                rightArr[i]=0;
            }
            else if(stack2.peek()<arr[i])
            {
                rightArr[i]=stack2.peek();
            }
            stack2.push(arr[i]);
        }
        
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            max=Math.max(max,Math.abs(leftArr[i]-rightArr[i]));
        }
        
        return max;
    }
}