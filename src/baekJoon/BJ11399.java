package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ11399 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());

        int[] arr = new int[total];

        String[] input = bf.readLine().split(" ");

        for(int i=0; i<total; i++){
            arr[i] = Integer.valueOf(input[i]);
        }

        Arrays.sort(arr);

        int sum = 0;
        int time = 0;
        for(int i=0; i<arr.length; i++){
            time += arr[i];
            sum += time;
        }

        System.out.println(sum);
    }
}
