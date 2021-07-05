package dbn.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class DFS_Q1_2 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int[][] map;

    static int height;
    static int width;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {


        String[] size = bf.readLine().split(" ");

        height = Integer.valueOf(size[0]);
        width = Integer.valueOf(size[1]);

        map = new int[height][width];

        for (int i = 0; i < height; i++) {
            String[] arr = bf.readLine().split("");
            for (int j = 0; j < arr.length; j++) {
                map[i][j] = Integer.valueOf(arr[j]);
            }
        }

        int count = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(DFS(i,j)){ count++; }
            }
        }

        System.out.println(count);

    }

    public static boolean DFS(int x, int y){

        if(x<0 || x>=height || y<0 || y>=width){ return false; }

        if(map[x][y] == 0){
            map[x][y] = 1;
            for(int i=0; i<4; i++){ DFS(x + dx[i],y + dy[i]); }
            return true;
        }
        return false;
    }
}
