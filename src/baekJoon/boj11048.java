package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj11048 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int[][] map;
    public static void main(String[] args) throws IOException {

        String[] settings = bf.readLine().split(" ");
        N = Integer.valueOf(settings[0]);
        M = Integer.valueOf(settings[1]);
        map = new int[N][M];
        for(int i=0; i<N; i++){
            int[] datas = Arrays.stream(bf.readLine().split(" ")).mapToInt(str ->Integer.valueOf(str)).toArray();
            map[i] = datas;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                dp(i,j);
            }
        }
        System.out.println(map[N-1][M-1]);
    }

    private static void dp(int n, int m){

        int top = 0;
        if(n > 0){
            top = map[n-1][m];
        }

        int left = 0;
        if(m > 0){
            left = map[n][m-1];
        }

       map[n][m] =  map[n][m] + Math.max(top,left);

    }

}
