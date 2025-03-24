//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // public int maxWater(int arr[]) {
        
    // // using 2 pointer approch
    //   int left=0; // for left track element
    //   int right=arr.length-1;  //for right track element
    //   int leftMax=0;
    //   int rightMax=0;
    //   int sum=0;
    //   while(left<=right)
    //   {
    //     if(arr[left]<=arr[right]) //left track
    //     {
    //          if(arr[left]>=leftMax)
    //          {
    //             leftMax=arr[left];
    //          }
    //          else
    //          {
    //             sum=sum+(leftMax-arr[left]);
    //          }
    //          left++;
    //     }
    //     else  //right track
    //     {
    //       if(arr[right]>=rightMax)
    //       {
    //         rightMax=arr[right];
    //       }
    //       else
    //       {
    //         sum=sum+(rightMax-arr[right]);
    //       }
    //       right--;
    //     }
    //   }
    //   return sum;
    // }
    
    public int maxWater(int arr[])
    {
        int leftmax=0;
        int rightmax=0;
        int left=0;
        int right=arr.length-1;
        int sum=0;
        
        
        while(left<=right){
        
        if(arr[left]<=arr[right])
        {
            if(arr[left]>=leftmax)
            {
                leftmax=arr[left];
            }
            else
            {
                sum=sum+(leftmax-arr[left]);
            }
            left++;
        }
        else
        {
            if(arr[right]>=rightmax)
            {
                rightmax=arr[right];
            }
            else
            {
                sum=sum+(rightmax-arr[right]);
            }
            right--;
        }
      }
      
      return sum;
    }
}
