package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PG159993 {

    public static void main(String[] args) {

        PG159993 pg = new PG159993();

        String[] maps =
                {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}
                ;
        int answer = pg.solution(maps);
        System.out.println("ansewr : " + answer);
    }
    static int[][] visited;
    static int[][] maze;

    static int[] start;
    static int[] button;
    static int[] end;

    static Queue<int[]> queue = new LinkedList<>();

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public int solution(String[] maps) {

        visited = new int[maps.length][maps[0].length()];
        maze = new int[maps.length][maps[0].length()];

        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                char word = maps[i].charAt(j);
                if(word == 'S'){
                    maze[i][j] = 1;
                    start = new int[]{i,j,0};
                } else if(word == 'L'){
                    maze[i][j] = 1;
                    button = new int[]{i,j,0};
                } else if(word == 'E'){
                    maze[i][j] = 1;
                    end = new int[]{i,j};
                } else if(word == 'O'){
                    maze[i][j] = 1;
                } else if (word == 'X'){
                    maze[i][j] = 0;
                }
            }
        }

        /*
        start 부터 button 까지 BFS 진행행
         */
        int answer = 0;
        BFS(start,button);
        int toButton = visited[button[0]][button[1]];
        if(toButton == 0) return -1;
        answer+=toButton;

        for(int i=0; i< visited.length; i++){
            System.out.println();
            for(int j=0; j< visited[0].length; j++){
                System.out.printf(visited[i][j] + " ");
            }
        }

        visited = new int[maze.length][maze[0].length];
        queue.clear();
        BFS(button,end);
        int toEnd = visited[end[0]][end[1]];
        if(toEnd == 0) return -1;
        answer+=visited[end[0]][end[1]];

        for(int i=0; i< visited.length; i++){
            System.out.println();
            for(int j=0; j< visited[0].length; j++){
                System.out.printf(visited[i][j] + " ");
            }
        }


        return answer;
    }

    public void BFS(int[] position, int[] end){

        queue.offer(position);


        while(!queue.isEmpty()){

            int[] next = queue.poll();

            for(int i=0; i<4; i++){
                int xx = next[0] + dx[i];
                int yy = next[1] + dy[i];
                int depth = next[2] + 1;

                if(xx < 0 || yy < 0 || xx >= maze.length || yy >= maze[0].length) continue;
                if(maze[xx][yy] != 1) continue;
                if(visited[xx][yy] != 0) continue;
                visited[xx][yy] = depth;

                if(xx == end[0] && yy == end[1]){
                    return;
                }

                queue.offer(new int[]{xx,yy,depth});
            }
        }

    }

}
