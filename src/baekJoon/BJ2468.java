package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2468 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int[][] map;
    static int[][] checked;

    static Queue<int[]> q;
    static ArrayList<int[]> positions = new ArrayList<>();

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static int size;
    static int count;

    public static void main(String[] args) throws IOException {

        size = Integer.valueOf(bf.readLine());
        map = new int[size][size];

        int max = 1;
        for(int i=0; i<size; i++){

            String[] arr = bf.readLine().split(" ");

            for(int j=0; j<size; j++){

                positions.add(new int[]{i,j});
                int num = Integer.valueOf(arr[j]);
                map[i][j] = num;

                if(max < num) max = num;

            }
        }

        int output = 0;

        for(int i=0; i<=max; i++){

            checked = new int[size][size];
            count = 0;
            q = new LinkedList<>();

            for(int[] pos : positions){

                if(map[pos[0]][pos[1]] <= i){
                    checked[pos[0]][pos[1]] = 2;
                }else if(map[pos[0]][pos[1]] > i && checked[pos[0]][pos[1]] == 0){

                    checked[pos[0]][pos[1]] = 1;
                    q.offer(pos);
                    BFS(i);

                }

            }

            if(output < count) output = count;

        }

        System.out.println(output);

    }

    static void BFS(int depth){

        while(!q.isEmpty()){

            int[] removed = q.remove();

            int y = removed[0];
            int x = removed[1];

            if(map[y][x] <= depth){
                checked[y][x] = 2;
                continue;
            }

            for(int i=0; i<4; i++){

                int newX = x + dx[i];
                int newY = y + dy[i];

                boolean isTrue = true;

                if(newX < 0 || size <= newX) isTrue = false;
                if(newY < 0 || size <= newY) isTrue = false;
                if(isTrue && checked[newY][newX] > 0) isTrue = false;

                if(isTrue){

                    checked[newY][newX] = 1;
                    q.offer(new int[]{newY,newX});

                }
            }
        }

        count++;
    }

}
