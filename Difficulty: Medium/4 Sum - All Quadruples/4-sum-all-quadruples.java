//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            // String[] nk = br.readLine().trim().split(" ");
            // int n = Integer.parseInt(nk[0]);
            // int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int target = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            List<List<Integer>> ans = ans = sln.fourSum(a, target);
            Collections.sort(ans, (list1, list2) -> {
                for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
                    int cmp = list1.get(i).compareTo(list2.get(i));
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                return 0;
            });
            for (List<Integer> v : ans) {
                for (int x : v) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            if (ans.isEmpty()) {
                System.out.println(-1);
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// target : the quadruple sum required

class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        // code here
        
        Arrays.sort(arr);
        ArrayList<List<Integer>> result= new ArrayList<>();
        for(int i=0;i<arr.length-3;i++)
        {   
            if(i>0 && arr[i]==arr[i-1])
            {
                continue;
            }
            for(int j=i+1;j<arr.length-2;j++)
            {
                
                if(j>i+1 && arr[j]==arr[j-1])
                {
                    continue;
                }
                int k=j+1;
                int l=arr.length-1;
                
                while(k<l)
                {
                    ArrayList<Integer> ar= new ArrayList<>();
                    int sum=arr[i]+arr[j]+arr[k]+arr[l];
                    if(sum==target)
                    {
                       Collections.addAll(ar,arr[i],arr[j],arr[k],arr[l]);
                       result.add(ar);
                       k++;
                       l--;
                       while(k<l && arr[k]==arr[k-1])
                       {
                           k++;
                       }
                       while(k<l && arr[l]==arr[l+1])
                       {
                           l--;
                       }
                    }
                    else if(sum>target)
                    {
                        l--;
                    }
                    else if(sum<target)
                    {
                        k++;
                    }
                }
            }
        }
        return result;
    }
}