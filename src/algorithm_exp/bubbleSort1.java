package algorithm_exp;

import java.util.Arrays;
//버블정렬:  지정값과 그 다음값을 비교하면서 위치 변경
//          뒤쪽부터 정렬이 이루어진다
//          시간복잡도 O(n^2) 선택정렬보다 느림
public class bubbleSort1 {

    public static void main(String[] args){

        int[] arr = {5,4,7,6,8,9,10,2,3,1};

        int tmp = 0; //배열 위치 변경용

        //뒤에서 하나씩 길이를 줄여가는 용도
        for(int i=0; i<arr.length; i++){

            //실제 비교가 수행될 j값 (j+1)연산하므로 arr.length-1이 기본
            for(int j=0; j<arr.length-1-i; j++){

                if(arr[j] > arr[j+1]){  // 옆의 값과 비교해서 앞이 크면 교환
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
