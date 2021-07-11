package algorithm_exp;

import java.util.Arrays;

public class heapSort_upstrm {

    public static void main(String[] args){

        int[] arr = {10, 26, 5, 37, 1, 61, 11, 59, 15, 48, 19};
        int num = 11;

        for(int i=1; i<num; i++){

            int c = i;

            do{
                int root = (c-1)/2;

                if(arr[root] < arr[c]){
                    int tmp = arr[root];
                    arr[root] = arr[c];
                    arr[c] = tmp;
                }

                c = root;
            }while(c!=0);
        }

        System.out.println(Arrays.toString(arr));

        for(int i=num-1; i>0; i--){

            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;

            int root = 0;
            int c = 1;

            do{
                c = root*2 +1;
                if(c<i-1 && arr[c] < arr[c+1]){ c++;}

                //c<i == 최대값 지정 넘어가지 않게
                if(c<i && arr[c] > arr[root]){
                    int tmp2 = arr[root];
                    arr[root] = arr[c];
                    arr[c] = tmp2;
                }

                root = c;
            }while(c<i/2);
        }

        System.out.println(Arrays.toString(arr));
    }
}
