package dbn.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] inputs = bf.readLine().split("");

        int sum = 0;

        for(int i=0; i<inputs.length; i++){

            int num = Integer.valueOf(inputs[i]);

            if((num <= 1) || (sum <= 1)){
                sum += num;
            }else{
                sum *= num;
            }
        }

        System.out.println(sum);

    }
}
