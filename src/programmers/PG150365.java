package programmers;

import java.util.ArrayList;

public class PG150365 {

    public static void main(String[] args) {

        PG150365 sol = new PG150365();
        System.out.println(sol.solution(4,4,2,1,2,4,7));
    }


    private static int goalCount;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {

        goalCount = k;

        StringBuilder sb = new StringBuilder();
        int xx = 0;
        int yy = 0;
        do{
            //x가 n보다 아직 작다면 아래로
            if(x < n){
                x+=1;
                sb.append("d");
            }else if(y > 1){
                y-=1;
                sb.append("l");
            }else if(y < m){
                y+=1;
                sb.append("r");
            }else if(x > 1){
                x-=1;
                sb.append("u");
            }

            xx = Math.abs(x-r);
            yy = Math.abs(y-c);
            goalCount--;
            System.out.println(goalCount + ", " + "x:" + x +", y:" + y + ", abs : " + Integer.valueOf(xx+yy));
        }while ( xx+yy < goalCount);


        System.out.println(sb.toString());
        System.out.println(goalCount + ", " + "x:" + x +", y:" + y);

        if(goalCount > 0 && x < r){
            int xStart = x;
            for(int i=xStart; i<r; i++){
                sb.append("d");
                x++;
                if(--goalCount==0) break;
            }
        }
        if(goalCount > 0 && y > c){
            int yStart = y;
            for(int i=yStart; i>c; i--){
                sb.append("l");
                y--;
                if(--goalCount==0) break;
            }
        }
        if(goalCount > 0 && y < c){
            int yStart = y;
            for(int i=yStart; i<c; i++){
                sb.append("r");
                y++;
                if(--goalCount==0) break;
            }
        }
        if(goalCount > 0 && x > r){
            int xStart = x;
            for(int i=xStart; i>r; i--){
                sb.append("u");
                x--;
                if(--goalCount==0) break;
            }
        }

        String answer;
        if(x != r || y != c){
            answer = "impossible";
        }else{
            answer = sb.toString();
        }

        return answer;
    }



}
