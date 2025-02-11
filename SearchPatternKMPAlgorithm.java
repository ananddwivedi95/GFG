package in.dsadec.com.GFG_DSAQuestions;
import java.util.*;
public class SearchPatternKMPAlgorithm {
    public static void main(String[] args)
    {
        System.out.println(search("ab","abcab"));
    }
    static ArrayList<Integer> search(String pat, String txt) {
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
