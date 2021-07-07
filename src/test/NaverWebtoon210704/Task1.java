package test.NaverWebtoon210704;

import java.util.Arrays;
import java.util.Collections;

public class Task1 {

    public static void main(String[] args) {

        solution(new int[]{50000, 25000, 1000, 10000}, new int[]{40, 20, 60, 30});
    }

    public static void solution(int[] prices, int[] discounts){


        Integer[] priceArr = arrMaker(prices);
        Integer[] discntArr = arrMaker(discounts);

        Arrays.sort(priceArr,Collections.reverseOrder());
        Arrays.sort(discntArr,Collections.reverseOrder());

        System.out.println(Arrays.toString(priceArr));
        System.out.println(Arrays.toString(discntArr));

        int length = Math.min(priceArr.length,discntArr.length);

        int sum = 0;
        for(int i=0; i<length; i++){
            int disprc = (priceArr[i]/100) * (100-discntArr[i]);

            System.out.println(disprc);
            sum += disprc;
        }

        if(discntArr.length == length){
            for(int i=length; i<priceArr.length; i++){
                sum += priceArr[i];
            }
        }

        System.out.println("sum: " + sum);

    }

    public static Integer[] arrMaker(int[] arr){

        Integer[] integerArr = new Integer[arr.length];

        for(int i=0; i<arr.length; i++){
            integerArr[i] = arr[i];
        }

        return integerArr;
    }
}
