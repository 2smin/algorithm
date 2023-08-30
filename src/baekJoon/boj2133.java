package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2133 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    public static void main(String[] args) throws IOException {

        N = Integer.valueOf(bf.readLine());

        if(N % 2 == 1){
            System.out.println(0);
            return;
        }
        System.out.println(dp(N));
    }

    public static int dp(int N){
        if(N >= 4){
            int n = N;
            int sum =0;
            while(n >= 0){
                n = n - 2;
                if(n <0) break;
                if(n == N-2){
                    sum += (dp(n) * 3);
                }else{
                    sum += (dp(n) * 2);
                }
            }
            return sum;
        }else if(N == 2){
            return 3;
        }else{
            return 1;
        }
    }
}
