//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        //make a count array to store the frequency of pattern
        int [] count= new int[26];
         //store the frequency
        for(char ch:pat.toCharArray())
        {
           count[ch-'a']++;   
        }
        int i=0;
        int j=0;
        int n=txt.length();
        int k=pat.length();
        int result=0;
        while(j<n)
        {
            int jfreq=txt.charAt(j)-'a';
            count[jfreq]--;
            
            if(j-i+1==k)
            {
                if(allZero(count))
                {
                    result++;
                }
                count[txt.charAt(i)-'a']++;
                i++;
            }
            j++;
        }
        return result;
    }
    static boolean allZero(int[] count) {
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}