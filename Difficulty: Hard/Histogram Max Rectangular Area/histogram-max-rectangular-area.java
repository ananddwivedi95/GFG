class Solution {
    public static int getMaxArea(int arr[]) {
        // your code here
        int[] nextSmaller= nextSmaller(arr);
        int[] previousSmaller=previousSmaller(arr);

        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            int h=arr[i];
            int w=nextSmaller[i]-previousSmaller[i]-1;

            max=Math.max(max,(h*w));
        }
        return max;
    }
    public static int[] nextSmaller(int[] arr)
    {
        Stack<Integer> stack= new Stack<>();
        int[] nextSmaller=new int[arr.length];
   
        for(int i=arr.length-1;i>=0;i--)
        {
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                nextSmaller[i]=arr.length;
            }
            else
            {
                nextSmaller[i]=stack.peek();
            }
            stack.push(i);
        }
         return nextSmaller;
    }
    public static int[] previousSmaller(int[] arr)
    {
        Stack<Integer> stack= new Stack<>();
        int[] previousSmaller=new int[arr.length];
   
        for(int i=0;i<arr.length;i++)
        {
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                previousSmaller[i]=-1;
            }
            else
            {
                previousSmaller[i]=stack.peek();
            }
            stack.push(i);
        }
        return previousSmaller;
    }
}
