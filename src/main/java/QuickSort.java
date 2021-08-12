import java.sql.SQLOutput;
import java.util.Arrays;

public class QuickSort {
    //10, 80, 30, 90, 40, 50, 70
    //60, 90, 80 , 70
    //l-5, r-8
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];;
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int[] arr, int l, int r){
        int pivot = arr[r];
        int i= l-1;
        int j  = l;
        while(j<r){
            if(arr[j]<=pivot){
                i++;
                swap(arr, i, j);
            }
            j++;
        }
        swap(arr, i+1, r);
        return i+1;
    }
    void sort(int[] arr, int l, int r){
        if(l<r){
            int p = partition(arr, l, r);

            sort(arr, l, p-1);
            sort(arr, p+1, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        QuickSort quickSort = new QuickSort()   ;
        quickSort.sort(arr,0, arr.length-1);

    }
}
