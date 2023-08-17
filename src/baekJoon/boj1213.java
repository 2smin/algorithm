package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1213 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int[] countArr = new int[50];

    public static void main(String[] args) throws IOException {

        String[] nameArr = bf.readLine().split("");

        for(int i=0; i< nameArr.length; i++){
            char alphabet = nameArr[i].charAt(0);

            countArr[alphabet-65]++;
        }

        StringBuilder palin = new StringBuilder();
        char last = 0;
        for(int i=0; i<countArr.length; i++){
            int count = countArr[i];

            while(count > 0){

                if(count == 1) {
                    if(last != 0){
                        System.out.println("I'm Sorry Hansoo");
                        return;
                    }else{
                        last = (char)(i + 65);
                        break;
                    }
                }

                if(count == 0) break;
                palin.append((char)(i + 65));
                count -= 2;
            }
        }

        StringBuilder counter = new StringBuilder(palin).reverse();
        if(last != 0) palin.append(last);
        palin.append(counter);

        System.out.println(palin);
    }
}
