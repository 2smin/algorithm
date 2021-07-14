package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ3020 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] arr = bf.readLine().split(" ");
        int N = Integer.valueOf(arr[0]);
        int H = Integer.valueOf(arr[1]);

        int[] map = new int[N];

        for(int i=0; i<N; i++){

            if(i%2 == 0) {
               map[i] = Integer.valueOf(bf.readLine());
            }else{
                map[i] = H - Integer.valueOf(bf.readLine());
            }
        }

        System.out.println(Arrays.toString(map));

        int start = 1;
        int end = H;

        while()


    }
}
