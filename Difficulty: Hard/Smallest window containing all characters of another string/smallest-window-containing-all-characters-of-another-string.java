//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        scan.nextLine(); // Consume the newline character after the integer input

        while (test > 0) {
            String s1 = scan.nextLine(); // Read first string on a new line
            String s2 = scan.nextLine(); // Read second string on a new line

            Solution obj = new Solution();
            String str = obj.smallestWindow(s1, s2);

            if (str.isEmpty()) {
                System.out.println("\"\"");
            } else {
                System.out.println(str);
            }
            // System.out.println("~");
            test--;
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the smallest window in the string s consisting
    // of all the characters of string p.
    public static String smallestWindow(String s, String t) {
        // Your code here
          int n = s.length();

        if (t.length() > n)
            return "";

        Map<Character, Integer> mp = new HashMap<>();

        // store karliya
        for (char ch : t.toCharArray())
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);

        int requiredCount = t.length();
        int i = 0, j = 0;

        int minWindowSize = Integer.MAX_VALUE;
        int start_i = 0;

        // story starts
        while (j < n) {
            char ch = s.charAt(j);

            if (mp.containsKey(ch) && mp.get(ch) > 0)
                requiredCount--;

            mp.put(ch, mp.getOrDefault(ch, 0) - 1);

            while (requiredCount == 0) {
                // start shrinking the window

                int currWindowSize = j - i + 1;

                if (minWindowSize > currWindowSize) {
                    minWindowSize = currWindowSize;
                    start_i = i;
                }

                char startChar = s.charAt(i);
                mp.put(startChar, mp.getOrDefault(startChar, 0) + 1);

                if (mp.containsKey(startChar) && mp.get(startChar) > 0) {
                    requiredCount++;
                }

                i++;
            }

            j++;
        }

        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + minWindowSize);
    }
}