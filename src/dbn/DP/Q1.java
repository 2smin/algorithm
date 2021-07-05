package dbn.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int[] capacity;

    public static void main(String[] args) throws IOException {

        String[] input  = bf.readLine().split(" ");

        int[] containers = new int[input.length];
        capacity = new int[input.length];

        for(int i=0; i<input.length; i++){
            containers[i] = Integer.valueOf(input[i]);
        }

        System.out.println(Arrays.toString(containers));

        capacity[0] = containers[0];
        capacity[1] = Math.max(containers[0], containers[1]);

        for(int i=2; i<input.length; i++){
            capacity[i] = Math.max(capacity[i-1],capacity[i-2] + containers[i]);
        }

        System.out.println(Arrays.toString(capacity));


    }
}
