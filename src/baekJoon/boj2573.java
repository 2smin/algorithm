package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;

public class boj2573 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int N;
    static int M;
    static int[][] map;
    static int[][] visited;

    public static void main(String[] args) throws IOException {

        String[] settings = bf.readLine().split(" ");
        N = Integer.valueOf(settings[0]);
        M = Integer.valueOf(settings[1]);

        map = new int[N][M];
        visited = new int[N][M];
        for(int i=0; i<N; i++){
            int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(str -> Integer.valueOf(str)).toArray();
            map[i] = arr;
        }

        int count = 0;
        int sum = 0;
        int parts = 0;
        do {
            parts = sum = 0;
            count++;
            melt();
            for(int i=0; i<N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] != 0 && visited[i][j] != 1){
                        parts++;
                        visited[i][j] = 1;
                        bfs(i,j);
                        sum+=map[i][j];
//                        System.out.println("i:j = " + i + "," +j);
//                        Arrays.stream(map).forEach(inMap -> {
//                            Arrays.stream(inMap).forEach(num -> System.out.print(num));
//                            System.out.println();
//                        });
//                        System.out.println();
                    }

                    if(parts == 2){
                        System.out.println(count);
                        return;
                    }
                }
            }
        }while (sum!=0);
        System.out.println(0);
    }

    public static int[][] copiedMap(){
        int[][] copiedMap = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                copiedMap[i][j] = 0;
                visited[i][j] = 0;
            }
        }
        return copiedMap;
    }

    public static void melt(){
        int[][] copiedMap = copiedMap();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){

                int count = 0;
                for(int d=0; d<4; d++){
                    int posX = j + dx[d];
                    int posY = i + dy[d];
                    if(posX < 0 || posY < 0 || posY >= N || posX >= M) continue;

                    if(map[posY][posX] == 0){
                        count++;
                    }
                }
                copiedMap[i][j] = Math.max(map[i][j] - count,0);
            }
        }
        map = copiedMap;
    }

    public static void bfs(int x, int y){

        for(int d=0; d<4; d++){
            int posX = x + dx[d];
            int posY = y + dy[d];
            if(posX < 0 || posY < 0 || posY >= M || posX >= N) continue;
            if(map[posX][posY] == 0 || visited[posX][posY] == 1) continue;
            visited[posX][posY] = 1;


//            System.out.println("===visit===");
//            Arrays.stream(visited).forEach(inMap -> {
//                Arrays.stream(inMap).forEach(num -> System.out.print(num));
//                System.out.println();
//            });
//            System.out.println();

            bfs(posX,posY);
        }

    }
}
