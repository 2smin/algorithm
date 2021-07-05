package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11047 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] arr = bf.readLine().split(" ");

        int total = Integer.valueOf(arr[0]);
        int price = Integer.valueOf(arr[1]);

        int[] coin = new int[total];

        for(int i=0; i<total; i++){
            coin[i] = Integer.valueOf(bf.readLine());
        }

        int count = 0;

        for(int i=total-1; i>=0; i--){
            count += (price / coin[i]);
            price %= coin[i];
        }

        System.out.println(count);
    }
}
