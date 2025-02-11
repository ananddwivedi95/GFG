package in.dsadec.com.GFG_DSAQuestions;

public class MinCharstoAddforPalindrome {
    public static void main(String[] args)
    {
        System.out.println(minChar("abc"));
    }
    public static int minChar(String s) {
        // Write your code here
        int n=s.length();
        String rev=new StringBuilder(s).reverse().toString();
        s=s+"$"+rev;
        int []lps= new int[s.length()];
        int lpsLastIndex=lpsCompute(lps,s);
        return n-lpsLastIndex;
    }
    static int lpsCompute(int []lps,String string)
    {
        int p=0;
        int s=1;
        while(s<string.length())
        {
            if(string.charAt(p)==string.charAt(s))
            {
                lps[s]=p+1;
                s++;
                p++;
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
        return lps[lps.length-1];
    }
}
