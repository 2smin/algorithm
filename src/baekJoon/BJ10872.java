package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10872 {

    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(bf.readLine());

        int output = 1;
        if(n>0){ output = factorial(n); }

        System.out.println(output);

    }


    public static int factorial(int n){

        int num = n-1;
        if(num != 0) {
            return n*factorial(num);
        }else{
            return 1;
        }
    }
}
