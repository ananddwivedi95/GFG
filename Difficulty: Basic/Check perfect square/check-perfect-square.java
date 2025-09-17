// User function Template for Java
class Solution {
    static long isPerfectSquare(long n) {
        // code here
        if(n==1)
        {
            return 1;
        }
         long left=1;
         long right=n;
         while(left<=right)
         {
             long mid=left+(right-left)/2;
             long squrt=mid*mid;
             if(squrt==n)
             {
                 return 1;
             }
             else if(squrt>n)
             {
                 right=mid-1;
             }
             else
             {
                 left=mid+1;
             }
         }
        return 0;
    }
}