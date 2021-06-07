package algorithm_exp;

import java.util.Arrays;
//선택정렬:  총 길이를 하나씩 줄여가며 최소값을 찾음
//          앞에서부터 정렬 진행
//          시간복잡도 O(n^2) 비효율적임
public class selectionSort1 {

    public static void main(String[] args){

        int[] arr = {5,2,4,7,9,10,8,6,1,3};

        int min = 999; //최소값을 담는다
        int index = 0; //최솟값 인덱스를 담는다
        int temp = 0; //배열 바꾸기

        for(int i=0; i<arr.length; i++){

            min = 9999;

            for(int j=i; j< arr.length; j++){

                if(arr[j] < min){ // 현재 위치가 최솟값보다 작으면
                    min = arr[j]; // 최솟값 갱신
                    index = j;    // 최솟값 위치를 인덱스에 저장
                }
            }

            temp = arr[i];        // 한 턴 완료 후 맨 앞과 최솟값 arr[index]를 변경
            arr[i] = arr[index];
            arr[index] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
