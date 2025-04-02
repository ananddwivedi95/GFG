//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Array
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");
            
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(st[i]);
              
            System.out.println(new Solution().minNumber(arr,0,n-1));
        
System.out.println("~");
}
    }
    
}
// } Driver Code Ends


class Solution
{
    //Function to find the minimum element in sorted and rotated array.
    static int minNumber(int arr[], int low, int high)
    {
        // Your code here
        int left=0;
        int right=arr.length-1;
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(arr[mid]>=arr[right])
            {
                left=mid+1;
            }
            else if(arr[mid]<arr[right])
            {
                right=mid;
            }
        }
        return arr[right];
    }
}