import java.awt.image.Kernel;

public class MergeSort {
    //divide -> sort -> merge

    static void merge(int[] arr, int l, int m, int r){
        int s1 = m-l+1;
        int s2 = r-m;
        int[] l1 = new int[s1];
        int[] l2 = new int[s2];

        for(int i=0; i<s1; i++){
            l1[i] = arr[l+i];
        }

        for(int i=0; i<s2; i++){
            l2[i] = arr[m+1+i];
        }

        int k = l;
        int i=0, j=0;
        while(i<s1 && j<s2){
            if(l1[i]<=l2[j]){
                arr[k] = l1[i];
                i++;
            }else{
                arr[k] = l2[j];
                j++;
            }
            k++;
        }
        while (i<s1){
            arr[k] = l1[i];
            i++; k++;
        }
        while (j<s2){
            arr[k] = l2[j];
            j++; k++;
        }
     }

    void sort(int[] arr, int l, int r){
        if(l<r){
            int mid = l+(r-l)/2;
            //divide and recur
            sort(arr, l, mid);
            sort(arr, mid+1, r);
            //sort & merge
            merge(arr, l, mid, r);
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] a = {12, 11, 13, 5, 6, 7};
        mergeSort.sort(a, 0, 5);
        System.out.println(a);
    }
}
