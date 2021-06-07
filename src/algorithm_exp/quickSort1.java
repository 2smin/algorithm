package algorithm_exp;

import java.util.Arrays;

//퀵정렬:  pivot을 설정하여 좌측은 pivot보다 작은값, 우측은 pivot보다 큰 값을 찾는다
//        좌측 우측을 찾은 후 좌우가 엇갈렸다면 작은값과 pivot 위치 변경, 바뀐 pivot 위치는 정렬 완료, 이후 양 파티션 재귀호출
//        좌우 찾은 후 좌우가 엇갈리지 않았다면 i와 j값 바꾸고 엇갈릴때까지 다시 진행
//        시간복잡도 O(n * logn) but 이미 정렬되어있는 경우는 O(n^2)으로 비효율적 <-> 삽입정렬

public class quickSort1 {

    public static void main(String[] args) {

        int[] arr = {5, 4, 7, 6, 8, 9, 10, 2, 3, 1};

       qSort(arr, 0, 9);

        System.out.println(Arrays.toString(arr));
    }

    public static void qSort(int[] arr, int start, int end){

        int i = start + 1;
        int j = end;
        int tmp = 0;
        int pivot = start;

        while(i<=j){

            while(arr[i]<=arr[pivot]){ i++; } // 좌측 -> arr[pivot]보다 큰 값을 만날때까지 i 증가

            while(arr[j]>=arr[pivot] && j > start){ j--; } // 우측 -> arr[pivot] 보다 작은 값을 만날때까지 j 감소

            if(i>j){    // i와 j가 이동하면서 엇갈렸다면 arr[pivot]과 arr[j]의 위치를 변경
                tmp = arr[pivot];
                arr[pivot] = arr[j];
                arr[j] = tmp;
            }else{      // i와 j가 엇갈리지 않았다면 arr[i] 와 arr[j]의 위치를 변경
                tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }

        if(start < j-1 ){ qSort(arr, start, j-1); } //좌측 파티션 다시 qSort 재귀호출
        if(j+1 < end){ qSort(arr, j+1, end); }      // 우측 파티션 다시 qSort 재귀호출
    }
}
