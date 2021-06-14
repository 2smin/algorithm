package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ1012 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static BufferedReader bf;
    public static void main(String[] args) throws IOException {

        bf = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.valueOf(bf.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<total; i++){

            String[] input = bf.readLine().split(" ");
            int m = Integer.valueOf(input[0]);
            int n = Integer.valueOf(input[1]);
            int posNum = Integer.valueOf(input[2]);

            int count = bfs(m,n,posNum);
            sb.append(count).append("\n");

        }

        System.out.println(sb);
    }

    public static int[][] mapMaker(int m, int n, int posNum) throws IOException{

        int[][] map = new int[m][n];

        while(posNum-- > 0){
            String[] mapInput = bf.readLine().split(" ");
            map[Integer.valueOf(mapInput[0])][Integer.valueOf(mapInput[1])] = 1;
        }

        return map;
    }

    public static int bfs(int width, int height, int posNum) throws IOException{

        int[][] map = mapMaker(width,height,posNum);
        boolean[][] checked = new boolean[width][height];

        Queue<int[]> queue = new LinkedList<>();

        int count = 0;

        for(int m=0; m<width; m++){
            for(int n=0; n<height; n++){

                if(!checked[m][n] && map[m][n] == 1){
                    queue.add(new int[]{m,n});
                    count++;
                }

                while(!queue.isEmpty()){
                    int[] remove = queue.remove();

                    int x = remove[0];
                    int y = remove[1];

                    for(int i=0; i<4; i++){

                        int newX = x + dx[i];
                        int newY = y + dy[i];

                        if(0 <= newX && newX < width && 0 <= newY && newY < height){

                            if(!checked[newX][newY] && map[newX][newY] == 1){
                                queue.add(new int[]{newX,newY});
                            }
                            checked[newX][newY] = true;
                        }

                    }
                }

            }
        }

        return count;
    }
}
