package programmers;

import java.util.*;

public class PG250136 {


    public static void main(String[] args) {

        PG250136 pg = new PG250136();

        int[][] map =
                {{0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}, {0,0,0,0,0,0}}
                ;
        int answer = pg.solution(map);
        System.out.println("answer :" +answer);
    }
    int[] dx = {1,-1,0,0};
    int [] dy = {0,0,1,-1};
    int[][] visited;

    int[][] map;
    int xLimit;
    int yLimit;
    int[] total;
    Queue<int[]> queue = new LinkedList<>();

    public class Oil {
        public Set<Integer> access = new HashSet<>();
        public int size;
    }

    public List<Oil> oilList = new ArrayList<>();

    public int solution(int[][] land) {
        int answer = 0;
        xLimit = land.length;
        yLimit = land[0].length;
        map = land;
        visited = new int[xLimit][yLimit];
        total = new int[yLimit];

        for(int i = 0; i< yLimit; i++){
            for(int j=0; j<xLimit; j++){
                if(map[j][i] == 1 && visited[j][i] != 1){
                    visited[j][i] = 1;
                    Oil oil = new Oil();
                    oil.access.add(i);
                    oilList.add(oil);
                    BFS(j,i,oil);
                }
            }
        }

        //oilList에서 각 oil에서 set 기반으로 더해준다
        for(Oil oil :  oilList){
            for(int access : oil.access){
                total[access] += oil.size;
            }
        }

        for(int i : total){
            System.out.printf(i + " ");
        }

        answer = Arrays.stream(total).max().getAsInt();
//        for(int i=0; i<xLimit; i++){
//            System.out.println();
//            for(int j=0; j<yLimit; j++){
//                System.out.printf(map[i][j] +" ");
//            }
//        }
//
//        System.out.println();
//        for(int i=0; i<xLimit; i++){
//            System.out.println();
//            for(int j=0; j<yLimit; j++){
//                System.out.printf(visited[i][j] +" ");
//            }
//        }
        return answer;
    }

    public void BFS(int x, int y, Oil oil){

        oil.size++;

        for(int i=0; i<4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];

            if(xx>=xLimit || yy>=yLimit || xx < 0 || yy < 0) continue;
            if(map[xx][yy] == 0) continue;
            if(visited[xx][yy] == 1) continue;
            visited[xx][yy] = 1;
            oil.access.add(yy);
            queue.offer(new int[]{xx,yy});
        }

        int[] next = queue.poll();
        if(next == null)return;
        BFS(next[0],next[1], oil);
    }

}
