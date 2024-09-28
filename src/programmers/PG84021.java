package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PG84021 {

    /*
    map을 생성하는데 2배짜리 크기로 생성

     */

    public static void main(String[] args) {

        int[][] board =
                {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}}
                ;
        int [][] table =
                {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}}
                ;

        PG84021 pg = new PG84021() ;
        pg.solution(board,table);
    }

    public static int[][] board;
    public static int boardSize;

    public static int[] range;
    public static int[] dx = new int[]{1,-1,0,0};
    public static int[] dy = new int[]{0,0,1,-1};
    public static int[][] addedBoard;
    public static Queue<int[]> queue = new LinkedList<>();

    public int solution(int[][] game_board, int[][] table) {

        boardSize = game_board.length;
        board = new int[boardSize*3][boardSize*3];
        range = new int[]{boardSize + 1, boardSize * 2};

        for(int i=0; i<boardSize; i++){
            for(int j=0; j<boardSize; j++){
                if(board[i][j] == 1) board[i][j] = 2;
            }
        }

        for(int i=0; i<boardSize; i++){
            for(int j=0; j<boardSize; j++){
                board[i+boardSize][j+boardSize] = game_board[i][j];
            }
        }


        for(int i=0; i<board.length; i++){
            for(int j=0;j<board.length; j++){
                System.out.printf(board[i][j] +"");
            }
            System.out.println();
        }


        /*
        총 3번 회전시킨다
        회전할때마다 table을 이동시키면서 board가 2로 채워진곳이 있는지 본다.
        2로 채워진 곳이 있으면 거기서 dfs를 수행한다. dfs 하면서 1은 나와도 되지만 2가 계속 나오면 계속 돌리고 0이 나오면 실패
        2가 계속 나오면서 끝나면 채워진것이므로 board를 3로 변경시키고 table에서 해당 위치의 애들도 dfs로 0으로 변환시킨다.
        이렇게 모두 진행해서 최종적으로 board에 3이 몇개 나왔는지 확인한다

         */

        int count = 4;
        while(count-- == 0){

            //보드 복사본 생성
            addedBoard = new int[boardSize*3][boardSize*3];
            for(int i=0; i<boardSize*3; i++){
                addedBoard[i] = board[i];
            }

            //addBoard x y 증가시키면서 보드복사본에 더한다
            for(int x=0; x<boardSize; x++){
                for(int y=0; y<boardSize; y++){

                    //보드 더하기
                    for(int i=0; i<addedBoard.length; i++){
                        for(int j=0; j< addedBoard.length; j++){
                            addedBoard[i][j] += table[i][j];
                        }
                    }

                    //2가 있는지 체크하기

                    for(int i=boardSize+1; i<boardSize*2+1; i++){
                        for(int j=boardSize+1; j<boardSize*2+1; j++){
                            //DFS 수행 (해당 위치가 2인 경우에만 시작)
                        }
                    }
                }
            }

            rotate(board);
        }

        //회전하는거 구현
        int answer = -1;
        return answer;
    }

    public void DFS(int[] pos){
        /*
        해당 위치가 1이면 continue, 0이면 break; 2면 DFS 계속 수행
         */
        queue.offer(pos);
        while(!queue.isEmpty()){

            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for(int i=0; i<dx.length; i++){
                for(int j=0; j<dy.length; j++){

                    int nextX = x + dx[i];
                    int nextY = y + dy[j];
                    int next = addedBoard[nextX][nextY];
                    if(next == 0 || next > 2) {
                        //queue 다 비우고 종료
                        while(!queue.isEmpty()){
                            queue.poll();
                        }
                        return;
                    }else if (next == 1){
                        continue;
                    }else if (next == 2) {
                        queue.offer(new int[]{nextX,nextY});
                    }
                }
            }
        }

        // 다 돌면? 체크
        for(int i=pos[0]; i<pos[0]*2+1; i++){
            for(int j=pos[1]; j<pos[1]*2+1; j++){
                //DFS 수행 (해당 위치가 2인 경우에만 시작)
            }
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // reverse up and down
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;

            }
        }

        // reverse diagonally
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
