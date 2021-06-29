package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ1024 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {

        String[] input = bf.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int L = Integer.valueOf(input[1]);

        int x = -1;
        int iter = -1;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = L; i <= 100; i++) {

            int t = (i-1)*i/2;

            if((N-t)%i == 0 && (N-t)/i >= 0){
                x = (N-t)/i;
                iter = i;
                break;
            }

        }

        if(x==-1){
            System.out.println(-1);
        }else{
            for(int i=0; i<iter; i++){
                sb.append(x+i).append(" ");
            }
        }

        System.out.println(sb);
    }
}
