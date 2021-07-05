package dbn.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q3 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] input = bf.readLine().split(" ");

        int total = Integer.valueOf(input[0]);
        int price = Integer.valueOf(input[1]);

        int[] coins = new int[total];

        //inf 초기화
        int[] count = new int[10001];

        Arrays.fill(count,10001);

        for(int i=0; i<total; i++){
            coins[i] = Integer.valueOf(bf.readLine());
            count[coins[i]] = 1;
        }

        for(int i=0; i<coins.length; i++){

            int k = coins[i];
            count[k] = 1;

            for(int j=k; j<count.length; j++){

                if(count[j-k] != 10001){
                    count[j] = Math.min(count[j],count[j-k]+1);
                }
            }
        }

        if(count[price] == 10001){
            System.out.println(-1);
        }else{
            System.out.println(count[price]);
        }

    }
}
