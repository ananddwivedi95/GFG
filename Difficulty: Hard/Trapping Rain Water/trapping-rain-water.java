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
    public int maxWater(int a[]) {
        
    int r=a.length-1;
    int l=0;
    int leftMax=0;
    int rightMax=0;
    int sum=0;
    while(l<=r)
    {
        if(a[l]<=a[r])
        {
            if(a[l]>=leftMax)
            {
                leftMax=a[l];
            }
            else
            {
              sum=sum+(leftMax-a[l]);  
            }
            l++;
        }
        else
        {
            if(a[r]>=rightMax)
            {
                rightMax=a[r];
            }
            else
            {
                sum=sum+(rightMax-a[r]);
            }
            r--;
        }
       
    }
     return sum;
    }
}
