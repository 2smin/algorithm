package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj2589 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int h;
    static int w;
    static String[][] map;
    static int[][] visited;
    static Queue<int[]> bfQueue = new LinkedList<>();

    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,1,-1};

    static int max = 0;

    public static void main(String[] args) throws IOException {

        String[] settings = bf.readLine().split(" ");
        h = Integer.valueOf(settings[0]);
        w = Integer.valueOf(settings[1]);
        map = new String[h][w];
        visited = new int[h][w];

        for(int i=0; i<h; i++){
            String[] rows = bf.readLine().split("");
            map[i] = rows;
        }


//
//        Arrays.stream(map).forEach(strs -> { Arrays.stream(strs).forEach(System.out::print);
//            System.out.println();});
//
//
//        Arrays.stream(visited).forEach(strs -> { Arrays.stream(strs).forEach(System.out::print);
//            System.out.println();});

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                renew();
                if(map[i][j].equals("L")){

                    visited[i][j] = 1;
                    bfQueue.offer(new int[]{i,j});

                    while(!bfQueue.isEmpty()){
                        int[] nextNode = bfQueue.poll();
                        bfs(nextNode[0],nextNode[1]);
                    }

//                    Arrays.stream(visited).forEach(strs -> { Arrays.stream(strs).forEach(System.out::print);
//                        System.out.println();});
//                    System.out.println();

                }
            }
        }

        System.out.println(max-1);

    }

    public static void renew(){
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                visited[i][j] = 0;
            }
        }
    }

    public static void bfs(int i, int j){

//        System.out.println("current : " + i + ", " + j);
//        visited[i][j] = count;
//        max = Math.max(max,count);
        for(int d=0; d<4; d++){
            int yy = i + dy[d];
            int xx = j + dx[d];

            if(yy >= h || yy < 0 || xx >= w || xx < 0) continue;
            if(map[yy][xx].equals("W")) continue;
            if(visited[yy][xx] != 0) continue;

            visited[yy][xx] = visited[i][j]+1;

            max = Math.max(max,visited[yy][xx]);
            bfQueue.offer(new int[]{yy,xx});
        }
    }


}
