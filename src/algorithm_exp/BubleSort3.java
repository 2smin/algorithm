package algorithm_exp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubleSort3 {

    public static void main(String[] args) {

        Integer[] arr = new Integer[10];

        for(int i=0; i<10; i++){
            arr[i] = (int)(Math.random()*10);
        }

        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();

        int count = arr.length;
        int loop = 0;
        //i 를 하나씩 줄인다
        //줄이면서 2중 for문
        while(count--!= 0){
            for(int i=0; i<count; i++){

                int temp = 0;
                if(arr[i] > arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
                loop++;
            }
        }

        Arrays.stream(arr).forEach(System.out::print);
        System.out.println("loop:" + loop);
    }
}
