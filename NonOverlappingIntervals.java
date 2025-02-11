package in.dsadec.com.GFG_DSAQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class NonOverlappingIntervals {
    public static void main(String[] args)
    {
        int[][] arr={{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(minRemoval(arr));
    }
    static int minRemoval(int intervals[][]) {
        // code here
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        int count=0;
        int i=0;
        int n=intervals.length;
        for(int j=1;j<n;j++)
        {
            int[] curr_intervals=intervals[i];
            int[] next_intervals=intervals[j];

            int cs=curr_intervals[0];
            int ce=curr_intervals[1];

            int ns=next_intervals[0];
            int ne=next_intervals[1];

            if(ce<=ns)
            {
                i=j;
            }
            else
            {
                count++;
                if(ce>ne)
                {
                    i=j;
                }
            }
        }
        return count;
    }

    public static class NonRepeatingCharacter {
        public static void main(String[] args)
        {
            System.out.println(nonRepeatingChar("geeksforgeeks"));
        }
        static char nonRepeatingChar(String s) {
            // Your code here
            HashMap<Character,Integer> hs= new HashMap<>();
            for(int i=0;i<s.length();i++)
            {
                hs.put(s.charAt(i),hs.getOrDefault(s.charAt(i),0)+1); // getOrDefault method is used to check whether the key is present or not if not present then initialize with key any value initialize by default 0 and increment by 1 otherwise if present then simply increment by 1
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

    public static class SearchPatternKMPAlgorithm {
        public static void main(String[] args)
        {
            System.out.println(search("abcab", "ab"));
        }
     static ArrayList<Integer> search(String txt, String pat) {
            ArrayList<Integer> result = new ArrayList<>();
            int m = pat.length(), n = txt.length();

            if (m > n) return result; // Edge case: If pattern is longer than text, no match

            int[] lps = new int[m];
            computeLPSArray(pat, lps); // Compute LPS array

            int i = 0, j = 0; // i -> text index, j -> pattern index

            while (i < n) {
                if (txt.charAt(i) == pat.charAt(j)) {
                    i++;
                    j++;

                    // If full match found
                    if (j == m) {
                        result.add(i - j); // Store the starting index of match
                        j = lps[j - 1];    // Reset j using LPS to continue searching
                    }
                }

                else {
                    if (j == 0) i++;    // If j is 0, move text pointer i
                    else j = lps[j - 1]; // Reset j using LPS
                }
            }

            return result;
        }

        // 🔹 Function to compute LPS (Longest Prefix Suffix) array
        static void computeLPSArray(String pat, int[] lps) {
            int len = 0; // Length of the previous longest prefix suffix
            int i = 1;

            while (i < pat.length()) {
                if (pat.charAt(i) == pat.charAt(len)) {
                    lps[i] = len + 1;
                    len++;
                    i++;
                } else {
                    if (len == 0) {
                        lps[i] = 0;
                        i++;
                    } else {
                        len = lps[len - 1]; // Reset length using LPS
                    }
                }
            }
        }
    }
}
