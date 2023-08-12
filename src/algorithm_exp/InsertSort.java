package algorithm_exp;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {


        Integer[] arr = new Integer[10];
        int max = 100;
        for(int i=0; i<10; i++){
            arr[i] = (int)(Math.random()*max);
        }

        Arrays.stream(arr).forEach(integer -> System.out.printf(integer+ " "));
        System.out.println();

        int loop = 0;

        for(int i=0; i<arr.length; i++){
            for(int j=i; j>0; j--){
                int temp = 0;
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                loop++;
            }
        }

        Arrays.stream(arr).forEach(integer -> System.out.printf(integer+ " "));
        System.out.println();
        System.out.println("loop: " + loop);
    }
}
