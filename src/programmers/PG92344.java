package programmers;

import java.util.Arrays;

public class PG92344 {

    public static void main(String[] args) {
        PG92344 sol = new PG92344();
        System.out.println(sol.solution(
                new int[][]{{1,2,3},{4,5,6},{7,8,9}},
        new int[][]{{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}}
        ));
    }


    public int solution(int[][] board, int[][] skill) {

        int[][] map = new int[board.length+1][board[0].length+1];
        for(int i=0; i<map.length; i++){
            Arrays.fill(map[i],0);
        }
        int answer = 0;

        for(int[] command : skill){

            int type = command[0];

            int degree = command[5];
            switch (type){
                case 1:
                    degree = degree*-1;
                    break;
            }

            int x1 = command[1];
            int y1 = command[2];
            int x2 = command[3];
            int y2 = command[4];

            map[x1][y1] =
                    map[x1][y1] + degree;

            map[x1][y2+1] =
                    y2 != map[0].length ? map[x1][y2+1] - degree : map[x1][y2+1];

            map[x2+1][y1] =
                    x2 != map.length ? map[x2+1][y1] - degree : map[x2+1][y1];

            map[x2+1][y2+1] =
                    y2 != map[0].length ? map[x2+1][y2+1] + degree : map[x2+1][y2+1];

        }

        for(int i=0; i<map.length; i++){
            for(int j=1; j<map[0].length; j++){
                map[i][j] = map[i][j] + map[i][j-1];
            }
        }

        for(int i=0; i<map[0].length; i++){
            for(int j=1; j<map.length; j++){
                map[j][i] = map[j][i] + map[j-1][i];
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                int result = board[i][j] + map[i][j];
                if(result > 0) answer++;
            }
        }
        return answer;
    }


}
