package dbn.Implemetation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int until = Integer.valueOf(bf.readLine());

        int second = 0;
        int minute = 0;
        int hour = 0;

        int count = 0;

        for(int i=0; i<=until; i++){
            for(int j=0; j<=59; j++){
                for(int k=0; k<=59; k++){
                    String time = (i+"")+(j+"")+(k+"");
                    if(time.contains("3")){
                        count++;
                    }
                }
            }
        }

        System.out.println(count);

    }
}
