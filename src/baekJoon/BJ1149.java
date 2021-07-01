package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1149 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());

        int[][] priceMap = new int[total][3];

        for(int i=0; i<total; i++){

            String[] prices = bf.readLine().split(" ");
            priceMap[i][0] = Integer.valueOf(prices[0]);
            priceMap[i][1] = Integer.valueOf(prices[1]);
            priceMap[i][2] = Integer.valueOf(prices[2]);
        }

//        for(int[] arr : priceMap){
//            System.out.println(Arrays.toString(arr));
//        }
//
//        System.out.println();

        for(int i=1; i<priceMap.length; i++){

            for(int j=0; j< priceMap[i].length; j++){

                if(j==0){
                    priceMap[i][j] = Math.min(priceMap[i-1][j+1],priceMap[i-1][j+2]) + priceMap[i][j];
                }else if(j==1){
                    priceMap[i][j] = Math.min(priceMap[i-1][j-1],priceMap[i-1][j+1]) + priceMap[i][j];
                }else{
                    priceMap[i][j] = Math.min(priceMap[i-1][j-1],priceMap[i-1][j-2]) + priceMap[i][j];
                }
            }
        }

        int min = Math.min(Math.min(priceMap[total-1][0],priceMap[total-1][1]),priceMap[total-1][2]);

        System.out.println(min);

    }
}
