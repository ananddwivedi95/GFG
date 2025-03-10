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
            int prices[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            if (obj.checkDuplicates(prices)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean checkDuplicates(int arr[]) {
        // Code here
        HashSet<Integer> hs=new HashSet<>();
        int j=0;
        while(j<arr.length)
        {
            if(hs.contains(arr[j]))
            {
                return true;
            }
            hs.add(arr[j]);
            j++;
        }
        return false;
    }
}