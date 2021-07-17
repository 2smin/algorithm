package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1904 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static long[] arr = new long[1000001];

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());

        arr[1] = 1L;
        arr[2] = 2L;

        long num = getNum(total);
        System.out.println(num);

    }
    public static long getNum(int num){

        if(arr[num] == 0){
            arr[num] = (getNum(num-1) + getNum(num-2))%15746;
        }

        return arr[num];
    }
}
