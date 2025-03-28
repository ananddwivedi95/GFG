//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().search(arr, key));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    int search(int[] arr, int target) {
        // Complete this function
      int pivot=findPivot(arr);
      int find=binarySearch(arr,0,pivot-1,target);
      if(find==-1)
      {
      return binarySearch(arr,pivot,arr.length-1,target);
      }
      return find;
    }
    static int binarySearch(int []arr,int start,int stop,int target)
    {
        int left=start;
        int right=stop;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(arr[mid]==target)
            {
                return mid;
            }
            else if(arr[mid]>target)
            {
                right= mid-1;
            }
            else if(arr[mid]<target)
            {
                left=mid+1;
            }
        }
        return -1;
    }
    static int findPivot(int[] arr)
    {
        int left=0;
        int right=arr.length-1;
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(arr[mid]>arr[right])
            {
                left=mid+1;
            }
            else
            {
                right=mid;
            }
        }
        return right;
    }
}