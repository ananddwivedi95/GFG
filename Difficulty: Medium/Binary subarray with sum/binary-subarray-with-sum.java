//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline character after reading the integer

        while (t-- > 0) {
            String input = sc.nextLine();
            String[] inputArray = input.split(" ");
            int[] arr = new int[inputArray.length];

            for (int i = 0; i < inputArray.length; i++) {
                arr[i] = Integer.parseInt(inputArray[i]);
            }

            int target = sc.nextInt();
            if (sc.hasNextLine())
                sc.nextLine(); // consume the newline after reading target

            Solution obj = new Solution();
            System.out.println(obj.numberOfSubarrays(arr, target));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int numberOfSubarrays(int[] arr, int target) {
        // code here
        
        int j=0;
        int sum=0;
        int result=0;
        HashMap<Integer,Integer> hs= new HashMap<>();
        hs.put(0,1);
        while(j<arr.length)
        {
            sum+=arr[j];
            int required=sum-target;
            if(hs.containsKey(required))
            {
                result+=hs.get(required);
            }
            hs.put(sum,hs.getOrDefault(sum,0)+1);
            j++;
        }
        return result;
    }
}