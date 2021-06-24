package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BJ2108 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int arr[];

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());

        arr = new int[total];
        for(int i=0; i<total; i++){
            int num = Integer.valueOf(bf.readLine());
            arr[i] = num;
        }

        qSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(average(arr));
        System.out.println(medium(arr));
        System.out.println(most(arr));

    }

    public static void qSort(int[]arr, int start, int end){

        if(start >= end){
            return;
        }
        int pivot = start;
        int m = start+1;
        int n = end;
        int tmp = 0;

        while(m<=n){

            while(m <= end && arr[m] <= arr[pivot]){m++;}
            while(n > start && arr[n] >= arr[pivot]){n--;}

            if(m>n){
                tmp = arr[n];
                arr[n] = arr[pivot];
                arr[pivot] = tmp;
            }else{
                tmp = arr[m];
                arr[m] = arr[n];
                arr[n] = tmp;

            };
        }

        qSort(arr,start,pivot-1);
        qSort(arr, pivot+1, end);
    }

    public static int average(int[] arr){
        double sum = 0;
        for(int i : arr){ sum+= i; }
        return (int)Math.round(sum/arr.length);
    }

    public static int medium(int[] arr){
        return arr[arr.length/2];
    }

    public static int most(int[] arr){

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }


        return -1;
    }

    public static int compareMap(Map<Integer,Integer> map1, )
}
