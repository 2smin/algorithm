package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2156 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int[] wines;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        int n = Integer.valueOf(bf.readLine());
        wines = new int[n];
        dp = new int[n];

        for(int i=0; i<n; i++){
            wines[i] = Integer.valueOf(bf.readLine());
        }

        if(wines.length < 3){
            System.out.println(Arrays.stream(wines).sum());
            return;
        }
        dp[0] = wines[0];
        dp[1] = wines[0] + wines[1];
        dp[2] = Math.max(Math.max(wines[0] + wines[2], wines[1] + wines[2]),wines[0]+wines[1]);

        for(int i=3; i<dp.length; i++){
            int case1 = dp[i-3] + wines[i-1] + wines[i];
            int case2 = dp[i-2] + wines[i];
            int case3 = dp[i-1];

            int max = Math.max(case1,case2);
            max = Math.max(max,case3);
            dp[i] = max;
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());

    }
}
