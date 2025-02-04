package in.dsadec.com.GFG_DSAQuestions;


import java.util.*;
public class InsertIntervals {
    public static void main(String[] args)
    {
        int arr[][]={{1,3}, {4,5}, {6,7}, {8,10}};
        ArrayList<int[]> array=insertInterval(arr, new int[]{5, 6});
        for(int i=0;i< array.size();i++) {
            System.out.print(Arrays.toString(array.get(i)) + " ");
        }

    }
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
        ArrayList<int[]> arrayList = new ArrayList<>(Arrays.asList(intervals));
        arrayList.add(newInterval);
        return margeIntervals(arrayList.toArray(new int[0][]));
    }
    static ArrayList<int[]> margeIntervals(int intervals[][])
    {
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        ArrayList<int[]> list= new ArrayList<>();
        int n=intervals.length;
        list.add(intervals[0]);
        for(int j=1;j<n;j++)
        {
            int curr_intervals[]=list.get(list.size()-1);
            int next_intervals[]=intervals[j];

            int cs=curr_intervals[0];
            int ce=curr_intervals[1];

            int ns=next_intervals[0];
            int ne=next_intervals[1];

            if(ce>=ns)
            {
                list.remove(list.size()-1);
                list.add(new int[]{cs,Math.max(ce,ne)});
            }
            else
            {
                list.add(next_intervals);
            }
        }
        return list;
    }
}
