//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    // Function for finding maximum and value pair
    public static int Pair_minimum(int arr[]) {
        // Complete the function
        Arrays.sort(arr);
        int i=0; // left
        int j=arr.length-1; //right
        int result=0;
        int sum=0;
        while(i<j)
        {
            sum=arr[i]+arr[j];
            result=Math.max(result,sum);
            i++;
            j--;
        }
        return result;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
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
            Solution obj = new Solution();
            int ans = obj.Pair_minimum(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends