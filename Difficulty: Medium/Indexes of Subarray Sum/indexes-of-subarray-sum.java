
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int left=0;
        int right=0;
        int currentSum=0;
        while(left<arr.length)
        {
            currentSum+=arr[left];
            while(currentSum>target)
            {
                currentSum-=arr[right];
                right++;
            }
            if(currentSum==target)
            {
                return new ArrayList<>(Arrays.asList(right+1,left+1));
            }
            left++;
        }
        return new ArrayList<>(Arrays.asList(-1));
    }
}
