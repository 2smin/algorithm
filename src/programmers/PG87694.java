package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PG87694 {

    public static void main(String[] args) {

        PG87694 pg = new PG87694();
        System.out.println(pg.solution(new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}},1,3,7,8));
    }

    static int[][] map = new int[51*2][51*2];
    static int[][] visit = new int[51*2][51*2];
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        for(int[] rec : rectangle){
            int x1 = rec[0]*2;
            int x2 = rec[2]*2;
            int y1 = rec[1]*2;
            int y2 = rec[3]*2;

            //내부 제거
            for(int i=x1; i<=x2; i++){
                for(int j=y1; j<=y2; j++){
                    if((i==x1 || i==x2) || (j==y1 || j==y2)){
                        if(map[i][j] == 2){
                            map[i][j] = 2;
                        }else{
                            map[i][j] = 1;
                        }
                    }else{
                       map[i][j] = 2;
                    }
                }
            }
        }

        /*
        시작지부터 목적지나올때까지 dfs
        방문할때마다 visit을 1로
        visit인 nodes는 방문 안함
        queue에 넣고 돌림

         */

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{characterX*2,characterY*2});
        int[] next = new int[]{0,0};

        while(!queue.isEmpty()){
            next = queue.poll();

            int x = next[0];
            int y = next[1];

            for(int i=0; i<4; i++){
                int ddx = dx[i] + x;
                int ddy = dy[i] + y;

                if(ddx < 0 || ddx >= map.length || ddy < 0 || ddy >= map.length) continue;
                if(visit[ddx][ddy] != 0)continue;
                if(map[ddx][ddy] != 1)continue;

                map[ddx][ddy] = map[x][y] + 1;
                queue.offer(new int[]{ddx,ddy});

            }

        }
//                for(int[] arr : map){
//            for(int num : arr){
//                System.out.print(num);
//            }
//            System.out.println();
//        }

        return map[itemX*2][itemY*2]/2;
    }

    public static void bfs(){

    }
}
