package in.dsadec.com.GFG_DSAQuestions;

public class CountInversion {
    public static void main(String[] args)
    {

        int arr[]={1,3,8,58,3,5,7,9};
        System.out.println(inversionCount(arr));
    }
        static int inversionCount(int arr[]) {
            // Your Code Here
            return mergeSort(arr,0,arr.length-1);
        }
        static int mergeSort(int arr[],int start,int end)
        {
            int mid=start+(end-start)/2;
            if(start>=end)
            {
                return 0;
            }
            int countInv=0;
            countInv+= mergeSort(arr,start,mid); //left
            countInv+=mergeSort(arr,mid+1,end); //right
            countInv+= merge(arr,start,mid,end);
            return countInv;
        }
        static int merge(int arr[],int start,int mid,int end)
        {
            int left=start;
            int right=mid+1;
            int size=(end-start)+1;
            int newArr[]=new int[size];
            int countInv=0;
            int index=0;

            while(left<=mid&&right<=end)
            {
                if(arr[left]<=arr[right])
                {
                    newArr[index++]=arr[left++];
                }
                else
                {
                    newArr[index++]=arr[right++];
                    countInv+=(mid-left+1);
                }
            }

            while(left<=mid)
            {
                newArr[index++]=arr[left++];
            }

            while(right<=end)
            {
                newArr[index++]=arr[right++];
            }

            for(int i=0;i<size;i++)
            {
                arr[start+i]=newArr[i];
            }
            return countInv;
        }


}
