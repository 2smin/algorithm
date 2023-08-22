package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1912 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int num;
    static int[] arr;
    static int[] dp;
    static int max = -2001;
    public static void main(String[] args) throws IOException {

        num = Integer.valueOf(bf.readLine());

        arr = new int[num+1];
        dp = new int[num+1];

        StringBuilder data = new StringBuilder();
        data.append(bf.readLine());
        String str = "0 " + data;
        String[] strs = str.split(" ");
        for(int i=0; i<num+1; i++){
            if(i==0){
                arr[i] = 0;
                dp[i] = 0;
            }else{
                arr[i] = Integer.valueOf(strs[i]);
            }
        }

        dp();
        System.out.println(max);
    }

    public static void dp(){
        for(int i=1; i<arr.length; i++){
            dp[i] = arr[i];
            dp[i] = Math.max(dp[i] + dp[i-1], dp[i]);
            max = Math.max(max,dp[i]);
        }
    }
}
