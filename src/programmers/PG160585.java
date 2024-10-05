package programmers;

public class PG160585 {

    public static void main(String[] args) {

        String[] board =
                {"...", "...", "..."}
        ;

        PG160585 pg = new PG160585();

        int answer = pg.solution(board);
        System.out.println("ansewr : " + answer);
    }

    static int numO =0;
    static int numX =0;

    public int solution(String[] board) {

        boolean winO = false;
        boolean winX = false;
        checkNum(board);
        //승리체크 가로
        for(int i=0; i<3; i++){
            int curO = 0;
            int curX = 0;
            for(int j=0; j<3; j++){
                char stone = board[i].charAt(j);
                if(stone == 'O') curO++;
                if(stone == 'X') curX++;
            }
            if(curO == 3) winO = true;
            if(curX == 3) winX = true;
        }
        if(winO && winX) return 0;

        winX = false;
        winO = false;
        //승리체크 세로
        for(int i=0; i<3; i++){
            int curO = 0;
            int curX = 0;
            for(int j=0; j<3; j++){
                char stone = board[j].charAt(i);
                if(stone == 'O') curO++;
                if(stone == 'X') curX++;
            }
            if(curO == 3) winO = true;
            if(curX == 3) winX = true;
        }
        if(winO && winX) return 0;


        //대각선체크
        char first1 = board[0].charAt(0);
        char first3 = board[0].charAt(2);
        char middle = board[1].charAt(1);
        char third1 = board[2].charAt(0);
        char third3 = board[2].charAt(2);

        //x가 이기는것만 가능
        int win1 = checkSame(first1,middle,third3);
        int win2 = checkSame(first3,middle,third1);
        if(win1 == 2){
            if(win2 == 2) return 0;
        }


        if(numO-1 == numX || numO == numX) return 1;
        return 0;
    }

    public int checkSame(char a, char b, char c){
        if(a == b && b == c && a == c){
            if(a == 'O') return 1;
            if(a == 'X') return 2;
        }
        return -1;
    }
    public void checkNum(String[] board){
        for(int i=0; i<3; i++){

            for(int j=0; j<3; j++){
                char stone = board[i].charAt(j);
                if(stone == 'O') numO++;
                if(stone == 'X') numX++;
            }
        }
    }
}
