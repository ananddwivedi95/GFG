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
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.kokoEat(arr, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int kokoEat(int[] arr, int h) {
        // code here
        Arrays.sort(arr);
        int left=1;
        int right=arr[arr.length-1];
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(eatAllBanana(arr,mid,h))
            {
                right=mid;
            }
            else
            {
                left=mid+1;
            }
        }
        return right;
    }
    static boolean eatAllBanana(int[] arr,int mid,int h)
    {
        int totalTime=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]%mid==0)
            {
                totalTime+=arr[i]/mid;
            }
            else
            {
                if(arr[i]<=mid)
                {
                    totalTime+=1;
                }
                else
                {
                    totalTime+=arr[i]/mid;
                    totalTime+=1;
                }
            }
        }
        if(totalTime<=h)
        {
            return true;
        }
        return false;
    }
}
