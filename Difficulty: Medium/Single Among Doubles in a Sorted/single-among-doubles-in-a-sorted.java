//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            int A = obj.findOnce(a);
            System.out.println(A);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int findOnce(int[] arr) {
        // Complete this function
        int left=0;
        int right=arr.length-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(left==right)
            {
                return arr[left];
            }
            else if(arr[mid]==arr[mid+1])
            {
                if((right-mid)%2==0)  //presnt at right side
                {
                    left=mid+1;
                }
                else //presnt at left
                {
                    right=mid-1;
                }
            }
            else if(arr[mid]!=arr[mid+1])
            {
                if((right-mid)%2==0)  //present at left
                {
                    right=mid;
                }
                else  //present at right
                {
                    left=mid+1;
                }
            }
        }
        return 0;
    }
}