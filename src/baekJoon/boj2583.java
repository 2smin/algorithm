package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class boj2583 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int m;
    static int n;
    static int k;

    static int dx[] = { -1, 1, 0, 0 };
    static int dy[] = { 0, 0, 1, -1};
    static PriorityQueue<Integer> answerQueue = new PriorityQueue<>();
    static int num = 0;
    static int[][] map;
    public static void main(String[] args) throws IOException {

        String[] settings = bf.readLine().split(" ");

        m = Integer.valueOf(settings[0]);
        n = Integer.valueOf(settings[1]);
        k = Integer.valueOf(settings[2]);

        map = new int[m][n];

        for(int x=0; x<m; x++) {
            for (int y = 0; y < n; y++) {
                map[x][y] = 0;
            }
        }

        for(int i=0; i<k; i++){
            int[] pos = Arrays.stream(bf.readLine().split(" ")).mapToInt(str -> Integer.valueOf(str)).toArray();

            int xFrom = pos[0];
            int yFrom = pos[1];
            int xTo = pos[2]-1;
            int yTo = pos[3]-1;

            for(int y=0; y<m; y++){
                for(int x=0; x<n; x++){
                    if(y >= yFrom && y <= yTo && x >= xFrom && x <= xTo){
                        map[y][x] = 1;
                    }
                }
            }
        }

//        Arrays.stream(map).forEach(ints -> { Arrays.stream(ints).forEach(System.out::print);
//            System.out.println();});

        for(int y=0; y<m; y++){
            for(int x=0; x<n; x++){
                int count = 0;
                if(map[y][x] == 0){
                    count = dfs(y,x,count);
                    answerQueue.offer(count);
                    num++;
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append(num + "\n");
        while(answerQueue.size()!=0){
            int num = answerQueue.poll();
            if(answerQueue.isEmpty()){
                sb.append(num);
            }else{
                sb.append(num + " ");
            }
        }

        System.out.println(sb);
    }

    public static int dfs(int y, int x, int count){
        count++;
        map[y][x] = 1;
        for(int d=0; d<4; d++){
            int yy = y + dy[d];
            int xx = x + dx[d];

            if(yy >= m || yy < 0 || xx >= n || xx < 0) continue;
            if(map[yy][xx] == 1) continue;

            count = dfs(yy,xx, count);
        }
        return count;
    }
}
