package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ3009 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[2][3];


        for (int i = 0; i < 3; i++) {

            String[] input = bf.readLine().split(" ");
            arr[0][i] = Integer.valueOf(input[0]);
            arr[1][i] = Integer.valueOf(input[1]);

        }
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<arr.length; i++){

            int[] counted = new int[1001];
            for(int j=0; j<arr[i].length; j++){
                counted[arr[i][j]]++;
            }

            for(int j=0; j<counted.length; j++){
                if(counted[j] == 1){
                    sb.append(j).append(" ");
                    break;
                }
            }
        }

        System.out.println(sb);

    }
}