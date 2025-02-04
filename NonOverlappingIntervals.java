package in.dsadec.com.GFG_DSAQuestions;

import java.util.Arrays;
import java.util.Comparator;

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
}
