package programmers;

import java.util.Arrays;

public class PG_72413_2 {

    public static void main(String[] args) {

        PG_72413_2 pg = new PG_72413_2();
        int n = 6;
        int s = 4;
        int a = 5;
        int b = 6;
        int[][] fares = new int[][]{{2,6,6},{6,3,7},{4,6,7},{6,5,11},{2,5,12},{5,3,20},{2,4,8},{4,3,9}};
        System.out.println(pg.solution(n, s, a, b, fares));
    }
    static int[][] djk;
    static int[][] fareMap;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        //일단 n 개만큼 table을 만든다 -> 이중리스트로 하자
        //각 n 마다 목적지 더한값 + 출발지에서 n까지 가는값 더하기 -> 이게 제일 작은값

        fareMap = new int[n+1][n+1];
        for(int i=0; i<fareMap.length; i++){
            Arrays.fill(fareMap[i],-1);
        }
        for(int[] fare : fares){
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];

            fareMap[from][to] = cost;
            fareMap[to][from] = cost;
            //본인으로 가는건 무시, 못가는건 0;
        }
        djk = new int[n+1][n+1];

        for(int i=1; i<n+1; i++){
            boolean[] visited = new boolean[n+1];

            int cnt = 1;
            //종료조건 = cnt가 n과 같을때까지
            int node = i;
            while(cnt != n){
                visited[node] = true;
                //현재 start에서 갈 수 있는 모든곳 찾아서 갱신
                int min = Integer.MAX_VALUE;
                for(int j=1; j<fareMap.length; j++){
                    if(fareMap[node][j] == -1) continue; //못가는곳은 패스
                    if(node == j) continue; //본인 패스
                    if(!visited[j]){ //방문 안한곳중에서
                        if(djk[i][j] == 0) //처음인 경우 일단 간다
                            djk[i][j] = (djk[i][node] + fareMap[node][j]);
                        else //기존 방문한경우 대소 비교해서 갱신
                            djk[i][j] = (djk[i][j] > (djk[i][node] + fareMap[node][j])) ? djk[i][node] + fareMap[node][j] : djk[i][j];

                    }
                }

                for(int m=0; m<djk[i].length; m++){
                    if(i == m) continue;
                    if(djk[i][m] == 0)continue;
                    if(!visited[m] && min > djk[i][m]){
                        min = djk[i][m];
                        node = m;
                    }
                }
                cnt++;
            }

        }

        int min = Integer.MAX_VALUE;
        for(int i=1; i<djk.length; i++){
            if((i != a && djk[i][a] == 0 )||(i != b && djk[i][b] == 0)) continue;
            int dual = djk[i][a] + djk[i][b];
            dual += djk[s][i];

            int solo = djk[s][a] + djk[s][b];
            int localMin = Math.min(dual, solo);
            min = Math.min(min, localMin);
        }
        for(int i=0; i<djk.length; i++){
            for(int j=0; j<djk[0].length; j++){
                System.out.printf(djk[i][j] + "  ");
            }
            System.out.println();
        }
        int answer = min;
        return answer;
    }
}