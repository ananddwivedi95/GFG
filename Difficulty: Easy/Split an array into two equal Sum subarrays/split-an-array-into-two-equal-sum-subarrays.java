class Solution {
    public boolean canSplit(int arr[]) {
        // code here
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
        }
        if(sum%2!=0)
        {
            return false;
        }
        int currentSum=0;
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            currentSum+=arr[i];
            if(currentSum==sum/2)
            {
                count++;
                currentSum=0;
                if(count==2 && i<arr.length)
                {
                    return true;
                }
            }
        }
        return false;
    }
}