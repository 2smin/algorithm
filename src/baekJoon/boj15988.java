package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj15988 {

    private static long[] dp;
    private static int N;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        N = Integer.valueOf(bf.readLine());

        dp = new long[1000001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<1000001; i++){
            dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % 1000000009;
        }
        for(int i=0; i<N; i++){

            int num = Integer.valueOf(bf.readLine());
            System.out.println(dp[num]);
        }
    }
}
