import java.util.ArrayList;

public class QuickSort {
    //存放最大的k个数
    public ArrayList<Integer> result = new ArrayList<Integer>();

    public int partition(int[] a,int low,int high){
        int privotKey = a[low];
        while (low < high){
            while (low < high && a[high] >= privotKey){
                high --;
            }
//            swap(a[high],a[low]);
            int temp = a[high];
            a[high] = a[low];
            a[low] = temp;

            while (low < high && a[low] <= privotKey ){
                low ++;
            }
//            swap(a[low],a[high]);
            temp = a[low];
            a[low] = a[high];
            a[high] = temp;
        }
//        for (int b:a) {
//            System.out.print(b + " ");
//        }
//        System.out.println("");
        //此时，low = high
        // low的位置是基准数的下标
        return low;
    }

    //快排
    public void quickSort(int[] a,int low,int high){
        if (low < high){
            int privotLoc = partition(a,low,high);
            quickSort(a,low,privotLoc - 1);
            quickSort(a,privotLoc + 1,high);
        }
    }


    //找第k个最大的元素
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length - 1);
    }

    // 快速选择找第k个最大的元素
    public int quickSelect(int[] arr, int k, int left, int right) {
//        if (left == right) return arr[right];
        int index = partition(arr, left, right);
        if (right - index + 1 > k){
            return quickSelect(arr, k, index + 1, right);
        }
        else if (right - index + 1 == k){
            for (int i = index; i <= arr.length - 1; i++) {
                result.add(arr[i]);
            }
            return arr[index];
        }
        else{
            return quickSelect(arr, k - right + index - 1, left, index - 1);
        }
    }

    public static void main(String[] args){
        int [] a ={47,25,16,24,15,23,1548,255,445,47,54,0,99999,2312213,1223123123,2};
        QuickSort quickSort = new QuickSort();
        int num = quickSort.findKthLargest(a,3);
//        System.out.println(num);
        for (Integer i:quickSort.result) {
            System.out.println(i);
        }
    }
}
