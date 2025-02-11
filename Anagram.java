package in.dsadec.com.GFG_DSAQuestions;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args)
    {
        System.out.println(areAnagrams("geeks","kseeg"));
    }
     static boolean areAnagrams(String s1, String s2) {

        // Your code here
        char[] ch1=s1.toCharArray();
        char[] ch2=s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        if(Arrays.equals(ch1,ch2))
        {
            return true;
        }
        return false;
    }
}
