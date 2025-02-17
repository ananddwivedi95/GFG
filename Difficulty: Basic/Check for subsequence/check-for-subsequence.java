//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            
            String a = sc.next();
            String b = sc.next();
            Solution ob = new Solution();
            if(ob.isSubSequence(a,b))
            System.out.println(1);
            else
            System.out.println(0);
 		
        
System.out.println("~");
}
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    boolean isSubSequence(String st1, String st2){
        
      int i=0;  //for A
      int j=0;  //for B
      while(j<st2.length())
      { 
          if(i==st1.length())
          {
              return true;
          }
          if(st1.charAt(i)==st2.charAt(j))
          {
            i++;
            j++;
          }
          else{
              j++;
          }
          
      }
      if(i==st1.length())
          {
              return true;
          }
    return false;
    }
}