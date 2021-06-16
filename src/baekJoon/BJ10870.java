package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10870 {

    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(bf.readLine());

        int sum = 0;
        sum = fibonacci(0,1);

        System.out.println(sum);

    }

    public static int fibonacci(int n1, int n2){

        int n3 = n1+n2;

        if(n-- >0){

            return fibonacci(n2, n3);
        }else{
            return n1;
        }
    }
}
