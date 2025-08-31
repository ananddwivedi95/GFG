class Solution {
    public boolean canSplit(int arr[]) {
        
        // using prefix sum concept
        int[] prefix= new int[arr.length];
        prefix[0]=arr[0];
        
        //total sum
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
               sum+=arr[i];
        }
        if(prefix[0]==sum-prefix[0])
        {
            return true;
        }
        for(int i=1;i<arr.length;i++)
        {
            prefix[i]=prefix[i-1]+arr[i];
            
            if(prefix[i]==sum-prefix[i])
            {
                return true;
            }
        }
        return false;
    }
}