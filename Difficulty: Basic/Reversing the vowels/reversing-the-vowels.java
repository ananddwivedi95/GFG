//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
           
            Solution ob = new Solution();
            
            System.out.println(ob.modify(s));    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
     String modify(String s) {
        int i=0;
        int j=s.length()-1;
        char[] ch=s.toCharArray();
       Set<Character> vowels=Set.of('a','e','i','o','u','A','E','I','O','U');
        while(i<j)
        {
            if(vowels.contains(s.charAt(i))&&vowels.contains(s.charAt(j)))
            {
                    swap(i,j,s,ch);
                    i++;
                    j--;
            }
            else if(vowels.contains(s.charAt(i))&&(!vowels.contains(s.charAt(j))))
            {
                j--;
            }
            else if(!(vowels.contains(s.charAt(i)))&&(vowels.contains(s.charAt(j))))
            {
                i++;
            }
            else {
                i++;
                j--;
            }
        }
        return new String(ch);
    }
    static void swap(int i,int j,String s,char[] ch)
    {
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }
}