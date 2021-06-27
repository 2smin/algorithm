package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2751 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[] arr;
    static int[] sorted;

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());
        arr = new int[total];
        sorted = new int[total];

        for(int i=0; i<total; i++){
            arr[i] = Integer.valueOf(bf.readLine());
        }

        mergeSort(arr,0,total-1);

        for(int num : arr){
            sb.append(num).append("\n");
        }

        System.out.println(sb);

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
