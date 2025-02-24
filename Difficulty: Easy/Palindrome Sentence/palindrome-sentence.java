//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t > 0) {
            String s = sc.nextLine();
            Solution ob = new Solution();
            if (ob.sentencePalindrome(s))
                System.out.println("true");
            else
                System.out.println("false");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {

    public boolean sentencePalindrome(String s) {
        // code here
        s=s.replaceAll("[^a-zA-Z0-9]","");
        s=s.toLowerCase();
        int i=0;
        int j=s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i++;
                j--;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}