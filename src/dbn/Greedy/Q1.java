package dbn.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1 {

    static BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] inputs = bf.readLine().split(" ");

        int N = Integer.valueOf(inputs[0]);
        int K = Integer.valueOf(inputs[1]);
        int count = 0;

        while(N>1){

            if(N % K != 0){
                N--;
            }else{
                N /= K;
            }

            count++;
        }

        System.out.println("count: " + count);
    }
}
