//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution sln = new Solution();
            System.out.println(sln.numberofElementsInIntersection(a, b));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int numberofElementsInIntersection(int nums1[], int nums2[]) {
        // Your code here
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int first=0;
        int second=0;
        int count=0;
        while(first<nums1.length&&second<nums2.length)
        {
            if(nums1[first]==nums2[second])
            {
                count++;
                first++;
                second++;
            }
            else if(nums1[first]>nums2[second])
            {
                second++;
            }
            else if(nums1[first]<nums2[second])
            {
                first++;
            }
        }
        
        return count;
    }
}