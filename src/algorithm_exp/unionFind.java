package algorithm_exp;

import java.util.Arrays;

public class unionFind {

    public static void main(String[] args) {

        int[] arr = new int[10];

        for(int i=0; i<arr.length; i++){
            arr[i] = i;
        }

        System.out.println(Arrays.toString(arr));

        unionParent(arr, 1, 2);
        unionParent(arr, 1, 4);
        unionParent(arr, 2,3);
        unionParent(arr, 5,6);
        unionParent(arr,7,8);
        unionParent(arr,8,6);
        unionParent(arr,7,1);

        System.out.println(findParent(arr,8,1));
    }

    public static int getParent(int[] arr, int x){

        if(arr[x] == x){return x; }

        return arr[x] = getParent(arr, arr[x]);
    }

    public static void unionParent(int[] arr, int a, int b){

        a = getParent(arr, a);
        b= getParent(arr, b);

        if(a<b) { arr[b] = a; }else{ arr[a] = b; }

    }

    static int findParent(int[] arr, int a, int b){

        System.out.println(a +" 와 " + b + "는 연결되어있나요?");
        a = getParent(arr, a);
        b = getParent(arr, b);

        if(a==b) {
            return 1;
        }else{
            return 0;
        }
    }

}
