package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2750 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int[] sorted;

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());

        int[] list = new int[total];
        sorted = new int[total];

        for(int i=0; i<total; i++){
            int num = Integer.valueOf(bf.readLine());
            list[i] = num;
        }

        merge(list,0,list.length-1);

        for(int i=0; i<list.length; i++){
            System.out.println(list[i]);
        }

    }

    public static void merge(int[] arr, int start, int end){

        if(start!=end){
            int middle = (start + end)/2;
            merge(arr,start,middle);
            merge(arr,middle+1,end);

            mSort(arr,start,end,middle);
        }
    }

    public static void mSort(int[] arr, int start, int end, int middle){

        int i = start;
        int j = middle+1;
        int k = start;

        while(i <= middle && j<=end){

            if(arr[i] >= arr[j]){
                sorted[k] = arr[j];
                j++;
            }else{
                sorted[k] = arr[i];
                i++;
            }
            k++;
        }

        if(i>middle){
            for(int m=j; m<=end; m++){
                sorted[k] = arr[m];
                k++;
            }
        }else{
            for(int m=i; m<=middle; m++){
                sorted[k] = arr[m];
                k++;
            }
        }

        for(int m=start; m<=end; m++){
            arr[m] = sorted[m];
        }
    }
}
