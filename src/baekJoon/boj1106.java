package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;

public class boj1106 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int goal;
    static int cityNum;

    static int[][] cityArr;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        String[] settings = bf.readLine().split(" ");
        goal = Integer.valueOf(settings[0]);
        cityNum = Integer.valueOf(settings[1]);
        cityArr = new int[cityNum][2];
        dp = new int[goal + 101];

        for(int i=0; i<cityNum; i++){
            cityArr[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(str -> Integer.valueOf(str)).toArray();
        }

        for(int i=0; i<dp.length; i++){
            dp[i] = 100 * 1000 + 1;
        }
        dp[0] = 0;

        for(int[] city  : cityArr){
            for(int i=city[1]; i<goal + 100; i++){
                dp[i] = Math.min(dp[i-city[1]] + city[0],dp[i]);
            }
        }

        int answer = dp[goal];
        for(int i=goal+1; i<dp.length; i++){
            answer = Math.min(answer,dp[i]);
        }

        System.out.println(answer);

    }
}
