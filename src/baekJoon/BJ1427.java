package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1427 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[] sorted;
    static int[] numArr;

    public static void main(String[] args) throws IOException {

        String[] input = bf.readLine().split("");
        numArr = new int[input.length];

        for(int i=0; i< input.length; i++){
            numArr[i] = Integer.valueOf(input[i]);
        }

        sorted = new int[numArr.length];
        merge(numArr,0,numArr.length-1);

        for(int i=0; i< numArr.length; i++){
            sb.append(numArr[i]);
        }

        System.out.println(sb);

    }



    static void merge(int[] arr, int start, int end){

        if(start<end){

            int middle = (start+end) / 2;
            merge(arr,start, middle);
            merge(arr, middle+1, end);

            mergeSort(arr,start,middle,end);
        }
    }

    static void mergeSort(int[] arr, int start, int middle, int end){

        int m = start;
        int n = middle+1;
        int k = start;

        while(m <= middle && n <= end){

            if(arr[m] >= arr[n]){
                sorted[k] = arr[m];
                m++;
            }else{
                sorted[k] = arr[n];
                n++;
            }

            k++;
        }

        if(m > middle){
            for(int i=n; i<=end; i++){
                sorted[k] = arr[i];
                k++;
            }
        }else if (n > end){
            for(int i=m; i<=middle; i++){
                sorted[k] = arr[i];
                k++;
            }
        }

        for(int i=start; i<=end; i++){
            arr[i] = sorted[i];
        }
    }
}
