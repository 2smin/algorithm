package algorithm_exp;

import java.util.Arrays;

public class heapSort_downstrm {

    public static int[] arr = {26, 5, 37, 1, 61, 11, 59, 15, 48, 19};
    static int num = 10;

    public static void main(String[] args){

        for(int i=num/2; i>=0; i--){
            heapify(i);
        }

        System.out.println(Arrays.toString(arr));

        for(int i=num-1; i>0; i--){
            System.out.println(Arrays.toString(arr));
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;

            int c = 1;
            int root = 0;
            do{
                c = root*2 +1;

                if(c<i-1 && arr[c] < arr[c+1]){ c++;}

                if(c<i && arr[c] > arr[root]){
                    int tmp2 = arr[root];
                    arr[root] = arr[c];
                    arr[c] = tmp2;
                }

                root = c;
            }while(c<=num/2);
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void heapify(int i){

        int root = i;
        int c;

        do{
            c = root*2+1;
            if(c<num-1 && arr[c] < arr[c+1]){ c++;}

            if(c < num && arr[root] < arr[c]){
                int tmp = arr[root];
                arr[root] = arr[c];
                arr[c] = tmp;
            }

            root = c;
        }while(c<=num/2);

    }
}
