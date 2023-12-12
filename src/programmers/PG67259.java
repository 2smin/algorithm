package programmers;

import java.util.Arrays;

public class PG67259 {

    /*
    필요한것.
     1. 전체 map
     2. 방문했는지 check 하는 map[
     3. 최소비용 저장할 map 이건 그냥 전체 map이랑 같이 쓰자

     flow
     1. dfp 로 진행하면서 1은 벽이니까 패스
     2. 방문 여부는 상관 없이 최소값으로 갈 수 있으면 갱신하자 그럼 방문 map 불필요
     3. 직선 곡선 판단 여부? 현재 위치의 이전 노드랑 다음 노드가 x, y 다 다르면 곡선이다.
     4. 재귀하면서 가져가야할것, 현재 위치의 금액, 이전 노드의 x, y 좌표
     */

    public static void main(String[] args) {

        PG67259 pg = new PG67259();

        int[][] board =
                {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}}
        ;

        System.out.println(pg.solution(board));
        System.out.println(min);
    }

    static int[] dx = {0,1,-1,0};
    static int[] dy = {1,0,0,-1};

    static int[][] map;
    static int min = 999999999;
    public int solution(int[][] board) {
        map = board;
        int[][]visitied = new int[board.length][board.length];

        dfs(0,0,0,0,0, true, visitied);

        Arrays.stream(map).forEach(ints -> { Arrays.stream(ints).forEach(num -> System.out.printf(String.format("%-7s", num)));
            System.out.println();});
        int answer = map[board.length-1][board.length-1];
        return answer;
    }

    public void dfs(int x, int y, int money, int preX, int preY, boolean startNode, int[][] visited){
        System.out.println();
        for(int i=0; i<4; i++){

            int ddx = x + dx[i];
            int ddy = y + dy[i];

            System.out.println("i: " + i);
            System.out.println("preX : " + preX + " preY : " + preY);
            System.out.println("x : " + x + " y : " + y);
            System.out.println("nexX : " + ddx + " nexY : " + ddy);

            //map 범위 넘어가면 취소
            if(ddx < 0 || ddx >= map.length || ddy < 0 || ddy >=map.length) {
                System.out.println("out of range");
                System.out.println();
                continue;
            }

            if(visited[ddx][ddy] == 1){
                System.out.println("visited");
                System.out.println();
                continue;
            }
//
//            if(preX == ddx && preY == ddy){
//                System.out.println("preX == ddx && preY == ddy");
//                System.out.println();
//                continue;
//            }

            //현재금액보다 가격이 낮은지 체크?

            //곡선
            if(map[x][y] != 0 && map[x][y] < money){
                System.out.println("map[x][y] :" + map[x][y]);
                System.out.println("money :" + money);
                System.out.println();
                continue;
            }
            if(map[ddx][ddy] == 1){
                System.out.println("block");
                System.out.println();
                continue;
            }

            //현재 노드 계산

            if(x==map.length-1 && y==map.length-1){
                System.out.println("end");
                map[x][y] = money + 100;
                min = Math.min(min, money);
                continue;
            }

            if(!startNode){
                if(preX != ddx && preY != ddy){
                    money += 500;
                }
            }

            if(map[x][y] != 0 && map[x][y] < money){
                System.out.println("map[x][y] :" + map[x][y]);
                System.out.println("money :" + money);
                System.out.println();
                continue;
            }else if (map[x][y] != 0 && map[x][y] > money + 100){
                money += 100;
                map[x][y] = money;
            }else{
                money += 100;
                map[x][y] = money;
            }

            //이전 노드 계산


            visited[x][y] = 1;


            dfs(ddx,ddy,money, x,y,false,deepCopy(visited));
        }
    }

    public int[][] deepCopy(int[][] original2) {
        if(original2 == null) return null;
        int[][] result = new int[original2.length][original2[0].length];

        for(int i=0; i<original2.length; i++){
            System.arraycopy(original2[i], 0, result[i], 0, original2[0].length);
        }

        return result;
    }

}
