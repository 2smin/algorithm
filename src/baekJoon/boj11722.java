package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11722 {

    private static int N;
    private static int[] arr;
    private static int[] num;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        N = Integer.valueOf(bf.readLine());
        arr = new int[N];
        num = new int[N];

        String[] strArr = bf.readLine().split(" ");

        for(int i=0; i<strArr.length; i++){
            arr[i] = Integer.valueOf(strArr[i]);
        }

        for(int i=0; i<arr.length; i++){
            num[i] = 1;
            for(int j=0; j<i; j++){
                //j가 i 보다 크면 i값을 j+1로
                if(arr[j] > arr[i] && num[j] >= num[i]) num[i] = num[j]+1;
            }
        }

        int max = 0;
        for(int i=0; i<num.length; i++){
            max = Math.max(num[i],max);
        }

        System.out.println(max);

    }
}
