package algorithm_exp;

import java.util.Arrays;

public class MergeSort1 {

    public static int[] sorted = new int[11];

    public static void getSorted(int length){sorted = new int[length];}

    public static void main(String[] args){

        int[] arr = {0,9,8,7,6,5,4,3,2,1};
        getSorted(arr.length);
        mergeSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    public static void merge(int[] arr, int m, int middle, int n){

        int i = m;
        int j = middle+1;
        int k = m;

        while(i <= middle && j <= n){

            if(arr[i] <= arr[j]){
                sorted[k] = arr[i];
                i++;
            }else{
                sorted[k] = arr[j];
                j++;
            }

            k++;
        }

        if(i>middle){
            for(int t=j; t<=n; t++){
                sorted[k] = arr[t];
                k++;
            }
        }else{
            for(int t=i; t<=middle; t++){
                sorted[k] = arr[t];
                k++;
            }
        }

        for(int t=m; t<=n; t++){
            arr[t] = sorted[t];
        }
    }

    public static void mergeSort(int[] arr, int m, int n){

        if(m!=n){
            int middle = (m+n)/2;

            mergeSort(arr, m, middle);
            mergeSort(arr, middle+1, n);
            merge(arr, m, middle, n);
        }
    }
}
