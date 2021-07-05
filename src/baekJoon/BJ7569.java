package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ7569 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int boxX;
    static int boxY;
    static int boxZ;

    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static int[][][] map;

    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        String[] mapArr = bf.readLine().split(" ");

        boxX = Integer.valueOf(mapArr[0]);
        boxY = Integer.valueOf(mapArr[1]);
        boxZ = Integer.valueOf(mapArr[2]);

        map = new int[boxZ][boxY][boxX];

        for(int k=0; k<boxZ; k++){

            for(int i = 0; i< boxY; i++){
                String[] arr = bf.readLine().split(" ");
                for(int j = 0; j< boxX; j++){
                    map[k][i][j] = Integer.valueOf(arr[j]);
                }
            }
        }

        BFS();

        int max = 0;
        loop1: for(int[][] arr : map){
            for(int[] arr2 : arr){
                for(int num : arr2){

                    if(num > max){
                        max = num-1;
                    }else if (num == 0){
                        max = -1;
                        break loop1;
                    }
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
        for(int k=0; k<map.length; k++){
            for(int i=0; i<map[k].length; i++){
                for(int j=0; j<map[k][i].length; j++){
                    if(map[k][i][j] > 0){
                        queue.add(new int[]{k,i,j});
                    }
                }
            }
        }

        while(!queue.isEmpty()){

            int[] position = queue.remove();
            int x = position[2];
            int y = position[1];
            int z = position[0];

            for(int i=0; i<6; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                int nextZ = z + dz[i];

                if(nextX<0 || boxX <=nextX){ continue; }
                if(nextY<0 || boxY <=nextY){ continue; }
                if(nextZ<0 || boxZ <=nextZ){ continue; }
                if(map[nextZ][nextY][nextX] != 0){ continue; }

                queue.add(new int[]{nextZ,nextY,nextX});
                map[nextZ][nextY][nextX] = map[z][y][x] + 1;

            }
        }
    }
}
