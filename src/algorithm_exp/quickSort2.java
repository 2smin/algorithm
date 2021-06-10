package algorithm_exp;

import java.util.Arrays;

public class quickSort2 {

    public static void main(String[] args){

        int[] arr = {8,4,2,3,6,1,0,5,9,7};
        qSort(arr,0,9);

        System.out.println(Arrays.toString(arr));

    }

    public static void qSort(int[] arr, int start, int end){

        int pivot = start;
        int i = start+1;
        int j = end;
        int tmp = 0;
        while(i<j){

            while(arr[i]<=arr[pivot]){i++;}
            while(arr[j]>=arr[pivot] && j>start){j--;}

            if(j<i){
                tmp = arr[pivot];
                arr[pivot] = arr[j];
                arr[j] = tmp;
            }else{
                tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }

        if(start<j-1){qSort(arr, start, j-1);}
        if(end>j+1){qSort(arr, j+1, end);}
    }
}
