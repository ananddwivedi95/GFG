//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class GFG {
    ArrayList<Integer> find(int arr[], int target) {
        // code here
        int lb=lowerBound(arr,target);
        int ub =upperBound(arr,target);
        ArrayList<Integer> result= new ArrayList<>();
        if (lb == arr.length || arr[lb] != target) { 
            Collections.addAll(result,-1,-1);
           return result;
           }
        result.add(0,lb);
        result.add(1,ub-1);
        return result;
    }
    static int upperBound(int[] arr,int target)
    {
        int left=0;
        int right=arr.length-1;
        int result=arr.length;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(target<arr[mid])
            {
                result=Math.min(result,mid);
                right=mid-1;
            }
            else if(target>=arr[mid])
            {
                left=mid+1;
            }
        }
        return result;
    }
    static int lowerBound(int[] arr,int target)
    {
        int left=0;
        int right=arr.length-1;
        int result=arr.length;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(target<=arr[mid])
            {
                result=Math.min(result,mid);
                right=mid-1;
            }
            else if(target>arr[mid])
            {
                left=mid+1;
            }
        }
        return result;
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {

            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            int x = Integer.parseInt(br.readLine());
            GFG ob = new GFG();
            ArrayList<Integer> ans = ob.find(arr, x);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends