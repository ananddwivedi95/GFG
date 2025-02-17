//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            int a[] = new int[inputArray.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(inputArray[i]);

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}


// } Driver Code Ends
class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        // code here
        int i=0;  //for 0
        int j=0;  //for 1
        int k=arr.length-1; // for 2
        while(j<=k)
        {
            if(arr[j]==0)
            {
                swap(i ,j,arr);
                i++;
                j++;
            }
            else if(arr[j]==1)
            {
                j++;
            }
            else if(arr[j]==2)
            {
                swap(k,j,arr);
                k--;
            }
        }
    }
    static void swap(int i,int j,int[] arr)
{
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
}
}


//{ Driver Code Starts.
// } Driver Code Ends