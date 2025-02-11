package in.dsadec.com.GFG_DSAQuestions;

import java.util.Arrays;

public class MergeWithoutExtraSpace {
    public static void main(String[] args)
    {
        int a[]={2, 4, 7, 10};
        int b[]={2, 3};
        mergeArrays(a,b);
        for(int i:a)
        {
            System.out.println(i+" ");
        }
        for(int i:b)
        {
            System.out.println(i+" ");
        }
    }
    public static void mergeArrays(int a[], int b[]) {
        // code here
        int aLength=a.length-1;
        int j=0;
        while(aLength>=0&&j<b.length)
        {
            if(a[aLength]<b[j])
            {
                aLength--;
            }
            else
            {
                swap(a,b,aLength,j);
                aLength--;
                j++;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
    static void swap(int a[],int b[],int aLength,int j)
    {
        int temp=a[aLength];
        a[aLength]=b[j];
        b[j]=temp;
    }

    public static class StringsRotationsofEachOther {
        public static void main(String[] args)
        {
            System.out.println(areRotations("aab","aba"));
        }
        /*static boolean areRotations(String s1, String s2) {
            // Your code here
            StringBuilder sb= new StringBuilder(s2);


            //check right rotation
            int i=0;
            while(i<sb.length())
            {
                char ch=sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(ch);
                System.out.println(sb);
                if(s1.equals(sb.toString()))
                {
                    System.out.println("right");
                    return true;
                }
                i++;
            }
            //check left rotation
            int j=sb.length()-1;
            while(j>=0)
            {
                char ch=sb.charAt(sb.length()-1);
                sb.deleteCharAt(sb.length());
                sb.insert(0,ch);
                if(s1.equals(sb.toString()))
                {
                    System.out.println("left");
                    return true;
                }
                j--;
            }
            return false;
        }*/

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
}
