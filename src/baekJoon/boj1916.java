package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1916 {

    static int N;
    static int M;

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int[][] map;
    static int[] dijkstra;
    static boolean[] checked;
    static int begin;
    static int end;
    public static void main(String[] args) throws IOException {

        N = Integer.valueOf(bf.readLine());
        M = Integer.valueOf(bf.readLine());

        map = new int[N+1][N+1];
        for(int[] col : map){
            Arrays.fill(col,-1);
        }
        dijkstra = new int[N+1];
        checked = new boolean[N+1];
        Arrays.fill(dijkstra,1000000000);

        for(int i=0 ;i<M; i++){
            int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(str -> Integer.valueOf(str)).toArray();
            int from = arr[0];
            int to = arr[1];
            int cost = arr[2];
            if(map[from][to] == -1){
                map[from][to] = cost;
            }else if(map[from][to] != -1 && cost < map[from][to]){
                map[from][to] = cost;
            }
        }

        int[] setting = Arrays.stream(bf.readLine().split(" ")).mapToInt(str -> Integer.valueOf(str)).toArray();
        begin = setting[0];
        end = setting[1];

//        for(int[] col : map){
//            for(int n : col){
//                System.out.printf(n + " ");
//            }
//            System.out.println();
//        }
        /*
        언제까지? 다 돌떄까지, cnt 를 주고 이게 N이 될 떄까지 (1부터시작하니까)
         */

        int pointer = begin;
        dijkstra[0] = dijkstra[pointer] = 0;

        int cnt = 0;
        while(cnt != N){
            checked[pointer] = true;
            //pointer에서 갈 수 있는 도시를 고른 후 dij를 업데이트 한다 단, cost가 현재 dij보다 작은 경우만
            for(int i=1; i<map.length; i++){
                if(map[pointer][i] == -1) continue;
                int fee = map[pointer][i] + dijkstra[pointer];
                if(fee < dijkstra[i]){
//                    System.out.println("change i :" + i + ", fee : " + fee);
                    dijkstra[i] = fee;
                }
            }

            //방문하지 않은 노드 중 가장 작은 놈을 찾아서 걔를 pointer로 지정
            int min = 1000000000;
            for(int i=1; i<checked.length; i++){
                if(checked[i]) continue;
                if(dijkstra[i] < min){
                    min = dijkstra[i];
                    pointer = i;
                }
            }

//            for(int i : dijkstra){
//                System.out.printf(i + ", ");
//            }
//            System.out.println();
            cnt++;
//            System.out.println("pointer : " + pointer + ", cnt : " + cnt);
        }

        System.out.println(dijkstra[end]);
    }
}
