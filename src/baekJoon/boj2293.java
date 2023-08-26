package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class boj2293 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int K;
    static Queue<Integer> queue = new PriorityQueue<Integer>();
    static int[] dp;
    public static void main(String[] args) throws IOException {

        String[] settings = bf.readLine().split(" ");

        N = Integer.valueOf(settings[0]);
        K = Integer.valueOf(settings[1]);

        dp = new int[K+1];

        for(int i=0; i<N; i++){
            int num = Integer.valueOf(bf.readLine());
            queue.offer(num);
        }

        for(int i=0; i<K+1; i++){
            dp[i] = 0;
        }

        int init = queue.poll();
        for(int i=0; i<K+1; i++){
            dp[i] = i % init == 0 ? 1 : 0;
        }

        for(int coin : queue){
            for(int i=1; i<K+1; i++){
               if(coin > i){
                   dp[i] = dp[i];
               }else if (coin == i){
                   dp[i] = dp[i] + 1;
               }else{
                   dp[i] = dp[i] + dp[i-coin];
               }
            }
        }

        System.out.println(dp[dp.length-1]);


    }
}
