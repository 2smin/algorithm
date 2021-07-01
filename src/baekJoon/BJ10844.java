package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ10844 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int size = Integer.valueOf(bf.readLine());
        int mod = 1000000000;
        long[][] arr = new long[size][10];

        for(int i=1; i<10; i++){
            arr[0][i] = 1L;
        }

        for(int i=1; i<size; i++){
            for(int j=0; j<10; j++){
                if(j==0){
                    arr[i][j] = arr[i-1][1] %mod;
                }else if(j==9){
                    arr[i][j] = arr[i-1][8] %mod;
                }else{
                    arr[i][j] = (arr[i-1][j-1] %mod) + (arr[i-1][j+1] %mod);
                }
            }
        }

        long sum = 0;
        for(int i=0; i<10; i++){
            sum+= arr[size-1][i];
        }

//        for(double[] subArr : arr){
//            System.out.println(Arrays.toString(subArr));
//        }

        System.out.println(sum%mod);
    }
}
