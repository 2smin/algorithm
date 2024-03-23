package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1074 {


    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int r;
    static int c;
    static int count;
    public static void main(String[] args) throws IOException {


        //형렬 길이가 2배가 될떄마다 *4이다

        String[] settings = bf.readLine().split(" ");

         N = Integer.valueOf(settings[0]);
         r = Integer.valueOf(settings[1]);
         c = Integer.valueOf(settings[2]);

        find((int)Math.pow(2,N),r,c);

        System.out.println(count);
    }

    private static void find(int size, int r, int c){
        if(size == 1){
            return;
        }
        if(r < size/2 && c < size/2) {
            find(size/2,r,c);
        }else if(r < size/2 && c >= size/2){

            count += (size * size /4 ) * 1;
            find(size/2, r, c-(size/2));

        }else if(r >= size/2 && c < size/2){

            count += (size * size /4 ) * 2;
            find(size/2, r-(size/2), c);

        }else{

            count += (size * size /4 ) * 3;
            find(size/2, r-(size/2), c-(size/2));

        }
    }
}
