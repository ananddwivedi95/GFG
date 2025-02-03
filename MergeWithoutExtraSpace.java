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
}
