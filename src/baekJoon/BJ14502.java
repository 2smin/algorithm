package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BJ14502 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int[][] map ;
    static boolean[][] checked;
    static Queue<int[]> virus = new LinkedList<>();
    static Queue<int[]> wallQ = new LinkedList<>();

    static int length;
    static int height;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};

    public static void main(String[] args) throws IOException {

        String[] arr = bf.readLine().split(" ");
        int length = Integer.valueOf(arr[1]);
        int height = Integer.valueOf(arr[0]);

        map = new int[height+1][length+1];
        checked = new boolean[height+1][length+1];

        for(int i=1; i<=height; i++){
            String[] positions = bf.readLine().split(" ");
            for(int j=1; j<=length; j++){
                map[i][j] = Integer.valueOf(positions[j-1]);
                if(Integer.valueOf(positions[j-1]) == 2){
                    virus.offer(new int[]{i,j});
                }
            }
        }

        for(int[] pos : map){
            System.out.println(Arrays.toString(pos));
        }

        for(int[] npos : virus){

            System.out.println(Arrays.toString(npos));
        }
        // 바이러스 있는곳들부터 시작
        // 하나씩 BFS를 실행
        // BFS 한단계마다 주변의 0의 갯수를 센다.
        // 총 갯수가 남아있는 벽의 수보다 작으면 벽을 세운다.
        // 벽이 남아있으면 다음 바이러스도 수행
        // 좌표와 0갯수 저장하고 벽 지운 후 다음 BFS 수행
        int wall = 3;
        while(wall != 0) {

            //바이러스가 남아있으면
            while (!virus.isEmpty()) {
                BFS();
            }
        }
    }

    static void BFS(){

        //세울 벽이 남아있고

        //벽을 체크한다.
        while(!wallQ.isEmpty()){

            int[] virusPos = virus.remove();
            int x = virusPos[1];
            int y = virusPos[0];

            //다음 위치값을 BFS 한다
            for(int i=0; i<4; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];

                int wallCnt = 0;
                //방문 안했고 벽을 세울 수 있으면
                if((newX > 0 && newX >= length) && (newY > 0 && newY >= height) && map[newY][newX] == 0 && !checked[newY][newX]){
                    wallCnt++;
                    wallQ.offer(new int[]{newY,newX});
                }

            }
        }

    }
}
