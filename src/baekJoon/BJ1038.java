package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1038 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.valueOf(bf.readLine());

        int[][] table = new int[10][10];


        for(int i=0; i<=9; i++){
            table[1][i] = 1;
        }
        int sum = 9;
loop1:  for(int i=2; i<10100; i++){
            for(int j=1; j<=9; j++){
                table[i][j] = table[i-1][j-1] + table[i][j-1];
                sum += table[i][j];

                if(sum >= N){
                    System.out.println("sum: " + sum);
                    System.out.println("i: " + i + ", j: " + j);
                    break loop1;
                }
            }
        }

        for(int[] arr : table){
            System.out.println(Arrays.toString(arr));
        }
    }
}
