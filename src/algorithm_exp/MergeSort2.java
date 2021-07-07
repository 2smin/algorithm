package algorithm_exp;

import java.util.Arrays;

public class MergeSort2 {

    static int[] sorted = new int[10];

    public static void main(String[] args){

        int[] arr = {8,4,2,3,6,1,0,5,9,7};
        mergeSort(arr,0,9);

        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int m, int n){

        if(m!=n){
            int middle = (m+n)/2;
            mergeSort(arr,m,middle);
            mergeSort(arr,middle+1,n);
            merge(arr, m,middle,n);
        }
    }

    public static void merge(int[] arr, int m, int middle, int n){

        int i = m;
        int j = middle+1;
        int k = m;
        while(i<=middle && j<=n){

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

}
