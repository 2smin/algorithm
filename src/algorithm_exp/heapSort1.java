package algorithm_exp;

import java.util.Arrays;

public class heapSort1 {

    public static void main(String[] args){

        int[] arr = {5,2,3,6,8,9,0,1,4,7};

        int num = arr.length;

        //하향식 heap 구조
//        for(int i=1; i<num; i++){
//
//            int c = i;
//
//            do{
//                int root = (c-1)/2;
//                System.out.println("c: " + c + "root: " + root);
//                if(arr[root] < arr[c]){
//                    int tmp = arr[root];
//                    arr[root] = arr[c];
//                    arr[c] = tmp;
//                }
//
//                c = root;
//            }while(c != 0);
//        }

        //상향식 heap 구조how??

        System.out.println("heap :" + Arrays.toString(arr));

        for(int i=num-1; i>=0;i--){

            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;

            int root = 0;
            int c = 1;

            do{
                c = 2 * root + 1;
                System.out.println("c: " + c + ", root: " + root);
                if(c < i -1 && arr[c] < arr[c+1]){
                    c++;
                }

                if(c < i && arr[root] < arr[c]){
                    int tmp2 = arr[c];
                    arr[c] = arr[root];
                    arr[root] = tmp2;
                }
                root = c;
            }while(c<i);
        }

        System.out.println(Arrays.toString(arr));

    }
}
