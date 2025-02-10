//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestPrefixSuffix(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int longestPrefixSuffix(String string) {
        // code here
        int lps[]= new int[string.length()];
        int p=0;
        int s=1;
        while(s<string.length())
        {
            //match
            if(string.charAt(p)==string.charAt(s))
            {
                lps[s]=p+1;
                p++;
                s++;
            }
            else  //notmatch
            {
                if(p==0)
                {
                    lps[s]=0;
                    s++;
                }
                else
                {
                    p=lps[p-1];
                }
            }
            
        }
        return lps[string.length()-1];
    }
}