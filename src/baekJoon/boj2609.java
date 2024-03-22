package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2609 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] settings = bf.readLine().split(" ");
        int a = Integer.valueOf(settings[0]);
        int b = Integer.valueOf(settings[1]);

        int A = 0;
        int B = 0;
        if(a > b){
            A = a;
            B = b;
        }else{
            A = b;
            B = a;
        }

        int remained = A%B;
        while(remained != 0){
            A = B;
            B = remained;
            remained = A%B;
        }

        System.out.println(B);
        System.out.println(a * b / B);
    }
}
