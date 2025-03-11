//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.countSubstring(s);
            
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution {
    public static int countSubstring(String s) {
        // code here
        int i=0;
        int j=0;
        int result=0;
        int []freq= new int[3];
        int n=s.length();
        while(j<s.length())
        {
            freq[s.charAt(j)-'a']++;
            while(freq[0]>0&&freq[1]>0&&freq[2]>0)
            {
                result=result+(n-j);
                freq[s.charAt(i)-'a']--;
                i++;
            }
            j++;
        }
        return result;
    }
}
        
