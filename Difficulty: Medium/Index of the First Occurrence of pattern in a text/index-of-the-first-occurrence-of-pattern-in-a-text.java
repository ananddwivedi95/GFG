//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String text = sc.next();
            String pat = sc.next();
            Solution obj = new Solution();
            int res = obj.findMatching(text, pat);
            System.out.println(res);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findMatching(String haystack, String needle) {
    int lps[]= new int[needle.length()];
        lpsFind(lps,needle);
        int first=0;
        int second=0;
        while(first<haystack.length()&&second<needle.length())
        {
            if(haystack.charAt(first)==needle.charAt(second))
            {
                first++;
                second++;
            }
            else
            {
                if(second==0)
                {
                    first++;
                }
                else
                {
                    second=lps[second-1];
                }
            }
        }
        if(second==needle.length())
        {
        return first-second;
        }
        return -1;
    }
    static void lpsFind(int lps[],String needle)
    {
        int p=0;
        int s=1;
        while(s<needle.length())
        {
            if(needle.charAt(p)==needle.charAt(s))
            {
                lps[s]=p+1;
                p++;
                s++;
            }
            else
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
    }
}
