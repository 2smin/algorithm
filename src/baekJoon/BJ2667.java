package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2667 {

    public static Queue<int[]> queue = new LinkedList();
    public static ArrayList<Integer> countList = new ArrayList<>();
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,1,0,-1};
    public static int width;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        width = Integer.valueOf(bf.readLine());
        map = new int[width][width];
        visited = new boolean[width][width];

        for(int total=0; total<width; total++){
            String[] input = bf.readLine().split("");
            int[] arr = new int[input.length];
            for(int i=0; i<input.length; i++){arr[i] = Integer.valueOf(input[i]);}
            map[total] = arr;
        }

        for(int m=0; m< width; m++){
            for(int n=0; n<width; n++){

                int count = 0;

                if(!visited[m][n] && map[m][n]!=0){
                    queue.add(new int[]{m,n});
                    visited[m][n] = true;
                    count+=1;
                }

                count = bfs(count);

                if(count!=0){ countList.add(count); }
            }
        }

        Collections.sort(countList);

        System.out.println(countList.size());

        for(int i=0; i<countList.size(); i++){
            System.out.println(countList.get(i));
        }
    }

    public static int bfs(int count){
        while(!queue.isEmpty()){

            int[] point = queue.remove();

            for(int i=0; i<4; i++){
                int x = point[0] + dx[i];
                int y = point[1] + dy[i];

                if(x<width && x>=0 && y<width && y>=0){

                    if(map[x][y] != 0 && !visited[x][y]) {
                        queue.add(new int[]{x, y});
                        count += 1;
                    }

                    visited[x][y] = true;
                }
            }
        }
        return count;
    }
}
