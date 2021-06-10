package algorithm_exp;

import java.util.Arrays;

public class heapSort2 {

    public static void main(String[] args) {

        int arr[] = {5, 3, 7, 1, 2, 9, 0, 8, 6, 4};
        int num = arr.length;

        for(int i=1; i<num; i++){

            int c = i;

            do{
                int root = (c-1)/2;

                if(arr[c] > arr[root]){
                    int tmp = arr[root];
                    arr[root] = arr[c];
                    arr[c] = tmp;
                }

                c = root;
            }while(c!=0);
        }

        System.out.println(Arrays.toString(arr));

        for(int i=num-1; i>=0; i--){

            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;

            int c = 1;
            int root = 0;

            do {

                c = root*2 +1;

                if(c<i-1 && arr[c] < arr[c+1]){
                    c++;
                }

                if(c<i && arr[root] < arr[c]){
                    int tmp2 = arr[c];
                    arr[c] = arr[root];
                    arr[root] = tmp2;
                }

                root = c;
            }while(c < i);

        }

        System.out.println(Arrays.toString(arr));
    }
}
