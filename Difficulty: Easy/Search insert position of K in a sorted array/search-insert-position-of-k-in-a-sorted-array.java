//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.searchInsertK(Arr, N, k));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int searchInsertK(int arr[], int n, int target)
    {
        // code here
        int left=0;
        int right=arr.length-1;
        int result=n;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(target<=arr[mid])
            {
                result=Math.min(result,mid);
                right=mid-1;
            }
            else if(target>arr[mid])
            {
                left=mid+1;
            }
        }
        return result;
        
    }
}