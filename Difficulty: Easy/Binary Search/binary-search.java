//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline
        while (t-- > 0) {
            int k = sc.nextInt();
            sc.nextLine(); // consume the newline
            String input = sc.nextLine();
            String[] strNumbers = input.split(" ");
            int[] arr = new int[strNumbers.length];
            for (int i = 0; i < strNumbers.length; i++) {
                arr[i] = Integer.parseInt(strNumbers[i]);
            }
            Solution ob = new Solution();
            int res = ob.binarysearch(arr, k);
            System.out.println(res);

            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int binarysearch(int[] arr, int target) {
        // Code Here
        int left=0;
        int right=arr.length-1;
        int result=arr.length;
        boolean flag=true;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(target==arr[mid])
            {
                flag=false;
                result=Math.min(result,mid);
                right=mid-1;
            }
            else if(target<arr[mid])
            {
                right=mid-1;
            }
            else if(target>arr[mid])
            {
                left=mid+1;
            }
        }
        if(flag==true)
        {
            return -1;
        }
        return result;
    }
}