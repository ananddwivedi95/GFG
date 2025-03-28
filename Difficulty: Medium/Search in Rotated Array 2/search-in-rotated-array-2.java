//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public static boolean Search(int[] arr, int target) {
        // code here
        // it is similer as the search in rotated array 1
        
        //find pivot
        int pivot=findPivot(arr);
        boolean result=binarySearch(arr,0,pivot-1,target);
        if(result==false)
        {
            return binarySearch(arr,pivot,arr.length-1,target);
        }
        return result;
        
    }
    static boolean binarySearch(int[] arr,int start,int stop,int target)
    {
        
        int left=start;
        int right=stop;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(arr[mid]==target)
            {
                return true;
            }
            else if(arr[mid]>target)
            {
                right=mid-1;
            }
            else if(arr[mid]<target)
            {
                left=mid+1;
            }
        }
        return false;
    }
    static int findPivot(int [] arr)
    {
        int left=0;
        int right=arr.length-1;
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(arr[mid]>arr[right])
            {
                left=mid+1;
                while(left<right && arr[left]==arr[left+1])
                {
                    left++;
                }
            }
            else 
            {
                right=mid;
                while(left<right && arr[right]==arr[right-1])
                {
                    right--;
                }
            }
        }
        return right;
    }
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
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
            boolean res = obj.Search(arr, k);
            if (res)
                System.out.println("true");
            else
                System.out.println("false");

            // System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends