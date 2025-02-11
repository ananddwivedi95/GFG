package in.dsadec.com.GFG_DSAQuestions;

public class StringsRotationsofEachOther {
    public static void main(String[] args)
    {
        System.out.println(areRotations("abcd","cdab"));
    }
    public static boolean areRotations(String s1, String s2) {
        //make this question using of kmp algorithm
        int lps[]= new int[s2.length()]; //lpd array
        findLps(lps,s2); //compute lps
        return areRotationUsingKmp(s1+s1,s2,lps); //using kmp algorithm

    }
    static boolean areRotationUsingKmp(String text,String pat,int[] lps)
    {
        int n=text.length(); //length of text
        int m=pat.length(); //length of pattern
        int i=0; //track text character
        int j=0; //track pattern character
        while(i<text.length())
        {
            if(text.charAt(i)==pat.charAt(j))
            {
                i++;
                j++;
                if(j==m)
                {
                    return true;
                }
            }
            else
            {
                if(j==0)
                {
                    i++;
                }
                else
                {
                    j=lps[j-1];
                }
            }
        }

        return false;
    }

    static void findLps(int []lps,String s2)
    {
        int p=0; //prefix
        int s=1; //suffix
        while(s<s2.length())
        {
            if(s2.charAt(p)==s2.charAt(s)) //character match
            {
                lps[s]=p+1;
                s++;
                p++;
            }
            else //character not match
            {
                if(p==0) // if p==0
                {
                    lps[s]=0;
                    s++;
                }
                else
                {
                    p=lps[p-1]; //if p!=0 then p=lps[p-1]
                }
            }
        }
    }
}
