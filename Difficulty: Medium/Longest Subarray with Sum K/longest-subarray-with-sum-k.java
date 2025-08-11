// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
      int maxLen=0;
      int sum=0;
      HashMap<Integer,Integer> map= new HashMap<>();
      map.put(0,-1);
      for(int i=0;i<arr.length;i++)
      {
          sum+=arr[i];
          int rem=sum-k;
          if(map.containsKey(rem))
          {
              int max=i-map.get(rem);
              maxLen=Math.max(maxLen,max);
          }
          if(!map.containsKey(sum))
          {
              map.put(sum,i);
          }
      }
      return maxLen;
    }
}
