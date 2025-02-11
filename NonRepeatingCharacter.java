package in.dsadec.com.GFG_DSAQuestions;
import java.util.*;
public class NonRepeatingCharacter {
    public static void main(String[] args)
    {
        System.out.println(nonRepeatingChar("geeksforgeeks"));
    }
    static char nonRepeatingChar(String s) {
        // Your code here
        HashMap<Character,Integer> hs= new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            hs.put(s.charAt(i),hs.getOrDefault(s.charAt(i),0)+1); // getOrDefault method is used to check whether the key is present or not if not present then initinlize with key any value initilize by default 0 and increament by 1 other wise if present then simply increament by 1
        }
        for(int i=0;i<s.length();i++)
        {
            if(hs.get(s.charAt(i))==1)
            {
                return s.charAt(i);
            }
        }
        return '$';
    }
}
