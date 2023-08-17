package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj16953 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int from;
    static int to;
    static int count;

    public static void main(String[] args) throws IOException {

        String[] settings = bf.readLine().split(" ");

        from = Integer.valueOf(settings[0]);
        to = Integer.valueOf(settings[1]);


        calculate(to);
        System.out.println(count);
    }

    public static void calculate(int num){

        if(num == from) {
            count++;
            return;
        }

        if(num < from || (num % 10 != 1 && num % 2 != 0)){
            count = -1;
            return;
        }

        if(num%10 == 1){
            num = num/10;
        }else if(num%2 == 0){
            num = num/2;
        }

        count++;
        calculate(num);
        return;

    }
}
