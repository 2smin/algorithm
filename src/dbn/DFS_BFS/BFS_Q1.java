package dbn.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Q1 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int height;
    static int width;
    static int[][]map;
    static int[][]count;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        String[] input = bf.readLine().split(" ");
        height = Integer.valueOf(input[0]);
        width = Integer.valueOf(input[1]);

        map = new int[height][width];
        count = new int[height][width];

        for(int i=0; i<height; i++){
            String[] arr = bf.readLine().split("");
            for(int j=0; j<width; j++){
                map[i][j] = Integer.valueOf(arr[j]);
            }
        }

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){

            }
        }

        BFS();

        System.out.println(count[height-1][width-1]);
    }

    public static void BFS(){

        queue.add(new int[]{0,0});
        count[0][0] = 1;

        while(!queue.isEmpty()){

            int[] arr = queue.remove();

            int x = arr[0];
            int y = arr[1];

            for(int i=0; i<4; i++){

                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(0<=nextX && nextX<height && 0<=nextY && nextY<width && map[nextX][nextY] != 0 && count[nextX][nextY] == 0){
                    queue.add(new int[]{nextX,nextY});
                    count[nextX][nextY] = count[x][y] + 1;
                }
            }
        }


    }
}
