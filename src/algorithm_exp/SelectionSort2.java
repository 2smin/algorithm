package algorithm_exp;

import java.util.Arrays;

public class SelectionSort2 {

    public static void main(String[] args) {


        Integer[] arr = new Integer[10];
        int max = 9999;
        for(int i=0; i<10; i++){
            arr[i] = (int)(Math.random()*max);
        }

        Arrays.stream(arr).forEach(integer -> System.out.printf(integer+ " "));
        System.out.println();

        //순회하면서 최소값 찾기
        //최소값을 찾으면 그 값을 맨 앞으로 보내기
        int loop = 0;
        for(int i=0; i<arr.length; i++){
            int min = max+1;
            int pos = 0;
            int temp = 0;
            for(int j=i; j<arr.length; j++){
                if(arr[j] < min) {
                    min = arr[j];
                    pos = j;
                }
                loop++;
            }
            temp = arr[i];
            arr[i] = min;
            arr[pos] = temp;

        }

        Arrays.stream(arr).forEach(integer -> System.out.printf(integer+ " "));
        System.out.println();
        System.out.println("loop:" + loop);
    }
}
