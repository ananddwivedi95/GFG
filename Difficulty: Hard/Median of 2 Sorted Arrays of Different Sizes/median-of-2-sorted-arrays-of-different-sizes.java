//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driver {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String arr1[] = br.readLine().split(" ");
            int[] a = new int[arr1.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);

            String arr2[] = br.readLine().split(" ");
            int[] b = new int[arr2.length];

            for (int i = 0; i < arr2.length; i++) b[i] = Integer.parseInt(arr2[i]);

            if (b.length == 1 && b[0] == 0) {
                b = new int[0];
            }
            double res = new Solution().medianOf2(a, b);

            if (res == (int)res)
                System.out.println((int)res);
            else
                System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public double medianOf2(int arr[], int arrr[]) {
        // Your Code Here
        int[] result=new int[arr.length+arrr.length];
      int i=0;
      int j=0;
      int index=0;
      while(i<arr.length&&j<arrr.length)
      {
         if(arr[i]<=arrr[j])
         {
            result[index++]=arr[i];
            i++;
         }
         else
         {
            result[index++]=arrr[j];
            j++;
         }
      }
      if(i<arr.length)
      {
        while(i<arr.length)
        {
        result[index++]=arr[i];
        i++;
        }
      }
      if(j<arrr.length)
      {
        while(j<arrr.length)
        {
            result[index++]=arrr[j];
            j++;
        }
      }
      double finalResult=0;
      if(result.length%2==0)
      {
        finalResult=(result[result.length/2]+result[(result.length/2)-1])/2.0;
        return finalResult;    
      }
      finalResult=result[result.length/2];
    return finalResult;
    }
}