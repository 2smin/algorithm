package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BJ10026 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int size;
    static String[][] map;
    static boolean[][] checked;
    static Queue<int[]> q;
    static int count;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {

        size = Integer.valueOf(bf.readLine());
        map = new String[size+1][size+1];

        for(int i=1; i<size+1; i++){

            String[] arr = bf.readLine().split("");

            for(int j=1; j<arr.length+1; j++){

                map[i][j] = arr[j-1];

            }
        }

        //일반인 체크
        getAreaCount();

        //색맹 체크
        for(int i=1; i<map.length; i++){
            for(int j=1; j< map.length; j++){
                if(map[i][j].equals("R")){
                    map[i][j] = "G";
                }
            }
        }

        getAreaCount();

        System.out.println(sb);

    }

    public static void getAreaCount(){

        count = 0;
        checked = new boolean[size+1][size+1];
        q = new LinkedList<>();

        for(int i = 1; i< map.length; i++){
            for(int j = 1; j< map.length; j++){
                if(!checked[i][j]){
                    q.offer(new int[]{i,j});
                    BFS();
                }
            }
        }

        sb.append(count).append(" ");
    }

    public static void BFS(){

        while(!q.isEmpty()){

            int[] removed = q.remove();

            int x = removed[1];
            int y = removed[0];

            String color = map[y][x];

            for(int i=0; i<4; i++){

                int newX = x + dx[i];
                int newY = y + dy[i];

                boolean isTrue = true;

                if(newX <= 0 || newX >= map.length) isTrue = false;
                if(isTrue && newY <= 0 || newY >= map.length) isTrue = false;
                if(isTrue && !map[newY][newX].equals(color)) isTrue = false;
                if(isTrue && checked[newY][newX]) isTrue = false;

                if(isTrue){
                    checked[newY][newX] = true;
                    q.offer(new int[]{newY,newX});
                }
            }
        }

        count++;

    }
}
