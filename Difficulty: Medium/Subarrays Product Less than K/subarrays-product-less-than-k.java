// User function Template for Java

class Solution {

    public long countSubArrayProductLessThanK(long arr[], int n, long k) {
        if(k<=1)
        {
            return 0;
        }
        int start=0;
        int end=0;
        long prod=1;
        long count=0;
        while(end<arr.length)
        {
            prod=prod*arr[end];
            while(prod>=k)
            {
                prod=prod/arr[start];
                start++;
            }
            count=count+(end-start+1);
            end++;
        }
        return count;
    }
}