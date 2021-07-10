package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ13305 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());

        String[] roadInput = bf.readLine().split(" ");
        int[] roads = new int[total-1];
        for(int i=0; i<roads.length; i++){
            roads[i] = Integer.valueOf(roadInput[i]);
        }

        String[] priceInput = bf.readLine().split(" ");
        int[] prices = new int[total];
        for(int i=0; i<prices.length; i++){
            prices[i] = Integer.valueOf(priceInput[i]);
        }

        int i=0;
        //가장 싼 주유가격
        int min = 1000000001;
        //현재까지 주유비용
        double sum = 0;
        //가격을 보고 가격을 min에 넣은 후 도로 길이만큼 산다
        //다음가격을 보고 min이 더 싸면 다음 도로 길이만큼 산다

        while(i<roads.length){

            if(prices[i] < min){
                min = prices[i];
            }

            sum += (double)min * (double)roads[i];

            i++;

        }

        System.out.println((int)sum);
    }
}
