//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T > 0) {
            int x = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

            Solution solution = new Solution();
            System.out.println(solution.smallestSubWithSum(x, arr));

            T--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    public static int smallestSubWithSum(int k, int[] arr) {
    int i = 0, j = 0, sum = 0;
    int minLength = Integer.MAX_VALUE;

    while (j < arr.length) {
        sum += arr[j]; // Expand the window
        j++;

        // Shrink the window as much as possible while sum is >= k
        while (sum > k) {
            minLength = Math.min(minLength, j - i);
            sum -= arr[i]; // Remove the leftmost element
            i++;
        }
    }

    // If minLength is still MAX_VALUE, no valid subarray was found
    return (minLength == Integer.MAX_VALUE) ? 0 : minLength;


    }
}
