package in.dsadec.com.GFG_DSAQuestions;

import java.util.*;

public class OverlappingIntervals {
    public static void main(String[] args) {
        int arr[][] = {{1, 3}, {2, 4}, {6, 8}, {9, 10}};
        List<int[]> list = mergeOverlap(arr);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(Arrays.toString(list.get(i)) + " ");
        }
    }

    static List<int[]> mergeOverlap(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0])); // Sort based on start time

        List<int[]> ll = new ArrayList<>();
        ll.add(arr[0]); // Add the first interval

        for (int j = 1; j < arr.length; j++) {
            int[] curr_Intervals = ll.get(ll.size() - 1); // Last interval in ll
            int[] next_intervals = arr[j];

            int cs = curr_Intervals[0];
            int ce = curr_Intervals[1];

            int ns = next_intervals[0];
            int ne = next_intervals[1];

            if (ce >= ns) { // Overlapping case
                ll.remove(ll.size()-1);
                ll.add(new int[]{cs,Math.max(ce,ne)}) ;// Merge in place (no remove needed)
            } else {
                ll.add(next_intervals); // Add non-overlapping interval
            }
        }
        return ll;
    }

    public static interface MinCharstoAddforPalindrome {
        public static void main(String[] args)
        {
            System.out.println(minChar("aacecaaaa"));
        }
        public static int minChar(String s) {
            // Write your code here

            int n=s.length();
           String rev= new StringBuilder(s).reverse().toString();
           s=s+"$"+rev;
           int [] lps= new int[s.length()];
           return n-lps(lps,s);
        }
        static int lps(int [] lps,String string)
        {
            int p=0;
            int s=1;
            while(s<string.length())
            {
                if(string.charAt(s)==string.charAt(p))
                {
                    lps[s]=p+1;
                    s++;
                    p++;
                }
                else {
                    if(p==0)
                    {
                        lps[s]=0;
                        s++;
                    }
                    else {
                        p=lps[p-1];
                    }
                }
            }
            return lps[lps.length-1];
        }
    }
}
