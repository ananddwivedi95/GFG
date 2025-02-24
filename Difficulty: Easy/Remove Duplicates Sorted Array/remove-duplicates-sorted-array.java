//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String str[] = br.readLine().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            Solution obj = new Solution();
            int len = obj.removeDuplicates(arr);
            for (int i = 0; i < len; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to remove duplicates from the given array
     static int removeDuplicates(int[] nums) {
        int count = 1;
        int i = 0;
        int j = 1;
        int index = 0; // Start from 1, as first element is always unique

        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[++index]=nums[j]; // Store unique element at index
                i = j;
                j++;
                count++;
            }
        }
        return count;
    }

    static void insert(int j, int[] nums, int index) {
        nums[index] = nums[j]; // Store unique element in the correct position
    }
}
