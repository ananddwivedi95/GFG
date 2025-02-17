//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
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

            int k = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            int ans = ob.maximumSumSubarray(arr, k);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maximumSumSubarray(int[] arr, int k) {
    if (k > arr.length) {  // Base condition
        return 0;
    }
    if (k == arr.length) {
        int sum = 0;
        for (int i = 0; i < k; i++) { // Pre-calculation of sum from index 0 to k-1
            sum += arr[i];
        }
        return sum;
    }
    
    // Calculate the sum of the first window
    int sum = 0;
    for (int i = 0; i < k; i++) {
        sum += arr[i];
    }
    
    // Initialize maxSum with the first window's sum
    int maxSum = sum;
    
    // Sliding window pointers
    int i = 0;
    int j = k;
    
    // Slide the window through the array
    while (j < arr.length) {
        sum = sum - arr[i] + arr[j];
        maxSum = Math.max(maxSum, sum);
        i++;
        j++;
    }
    
    return maxSum;
}
}