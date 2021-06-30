package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ7576 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int width;
    static int height;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        String[] mapArr = bf.readLine().split(" ");

        width = Integer.valueOf(mapArr[0]);
        height = Integer.valueOf(mapArr[1]);

        map = new int[height][width];

        for(int i=0; i<height; i++){
            String[] arr = bf.readLine().split(" ");
            for(int j=0; j<width; j++){
                map[i][j] = Integer.valueOf(arr[j]);
            }
        }

        BFS();

        int max = 0;
        loop1: for(int[] arr : map){
            for(int num : arr){
                if(num > max){
                    max = num-1;
                }else if (num == 0){
                    max = -1;
                    break loop1;
                }
            }
        }

        System.out.println(max);
    }

    static void BFS(){

        //1.map 전체에서 1인애들을 queue에 넣는다
        //2. bfs 시작
        //3. 1보다 작거나 checked 가 true인 곳은 놔두고 count 올린다. count 값을 좌표 map에 반영
        //4. 모든 좌표 돈 다음에 map에 0 남아있는지 체크한다. 0 있으면 -1, 없으면 마지막 count값 출력

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j] > 0){
                    queue.add(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()){

            int[] position = queue.remove();
            int x = position[1];
            int y = position[0];

            for(int i=0; i<4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX<0 || width<=nextX){ continue; }
                if(nextY<0 || height<=nextY){ continue; }
                if(map[nextY][nextX] != 0){ continue; }

                queue.add(new int[]{nextY,nextX});
                map[nextY][nextX] = map[y][x] + 1;

            }
        }
    }
}
