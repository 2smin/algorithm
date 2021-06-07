package algorithm_exp;

import java.util.Arrays;
//삽입정렬:  지정된 값과 그 앞의 값을 비교며 앞의 값이 작을경우 위치 바꾸기
//          앞부터 정렬이 이루어짐, 앞의 값이 클 경우 안바꾸고 넘어감
//          시간복잡도 O(n^2) 비효율정 but 앞이 어느정도 정렬되어있으면 매우 빠르다
public class insertionSort1 {

    public static void main(String[] args){

        int[] arr = {5,7,2,3,8,10,9,4,1,6};

        int tmp = 0;

        // 정렬 시작 위치값 i를 하나씩 올림
        for(int i=0; i<arr.length; i++){

            //시작되는 위치 i 부터 하나씩 내려가면서 이전값과 비교
            for(int j=i; j>0; j--){

                //앞의 값이 더 크다면 위치 바꾸기
                if(arr[j] < arr[j-1]){
                    tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                    System.out.println(Arrays.toString(arr));
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
