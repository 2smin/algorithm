package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class boj14502 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;

    static int[][] map;
    static int[][] testMap;
    static ArrayList<int[]> virus = new ArrayList<>();

    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};

    static int max = 0;

    public static void main(String[] args) throws IOException {

        String[] settings = bf.readLine().split(" ");

        N = Integer.valueOf(settings[0]);
        M = Integer.valueOf(settings[1]);
        map = new int[N][M];
        testMap = new int[N][M];

        for(int i=0; i<N; i++){
            int[] rows = Arrays.stream(bf.readLine().split(" ")).mapToInt(str -> Integer.valueOf(str)).toArray();
            map[i] = rows;
        }

        //virus 위치 넣기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 2) virus.add(new int[]{i,j});
            }
        }


        makeWall(0,0);

        System.out.println(max);
    }

    static void makeWall(int start, int wallNum) {

        if(wallNum == 3) {
            renew();
            for(int[] virus : virus){
                dfs(virus[0],virus[1]);
            }
            getMaxSafe();
            return;
        }

        //!!!!!! 좌표 3개 구하기
        for(int i=start; i< N*M; i++) {
            int y = i/M;
            int x = i%M;

            if(map[y][x] ==0) {
                map[y][x] =1;
                makeWall(i+1, wallNum+1);
                map[y][x] =0;
            }
        }
    }

    static void dfs(int i, int j){
//        System.out.println("pos :" + i + ", " + j);
        for(int d=0; d<4; d++){
            int yy = i + dy[d];
            int xx = j + dx[d];

            if(yy >= N || yy < 0 || xx >= M || xx < 0) continue;
            if(testMap[yy][xx] == 0){
                testMap[yy][xx] = 2;
                dfs(yy,xx);
            }
        }
    }

    public static void getMaxSafe(){
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(testMap[i][j] == 0) count++;
            }
        }
        max = Math.max(max,count);
    }
    public static void renew(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                testMap[i][j] = map[i][j];
            }
        }
    }
}
