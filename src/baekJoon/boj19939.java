package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj19939 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int ball;
    static int currentBall;
    static int team;
    static List<Integer> teamArr;
    static int answer = -1;

    /*
    unsolved!!!!
     */
    public static void main(String[] args) throws IOException {

        String[] settings = String.valueOf(bf.readLine()).split(" ");

        ball = Integer.valueOf(settings[0]);

        team = Integer.valueOf(settings[1]);
        teamArr = new ArrayList<>();

        for(int i=ball; i>0; i--){
            Stack<Integer> ballList = new Stack<>();
            search(ballList,i,i,ball,team);
        }

        System.out.println(answer);
    }

    public static void search(Stack<Integer> stack, int max, int from, int ball, int team){

        System.out.println( "[Next] ballList : " + stack.toString());
        System.out.println("ball : " + ball + ", team : " + team );
            if(ball <=0 || team <= 0 || from <= 0) return;
            int currentball = ball;
            int currentTeam = team;

            for(int i=from; i>=1; i--){

                currentTeam--;
                if(currentball < i) break;
                currentball-=i;
                stack.push(i);
                System.out.println("max : " + max + ", from : " + i + ", currentBall : " + currentball + ", currentTeam :" + currentTeam);

                if(currentTeam == 0 && currentball ==0){
                    System.out.println("done : " + max + "," + i);
                    answer = Math.min(answer,(max-i));
                    return;
                }

                if(currentball >0 && currentTeam > 0){
                    System.out.println("to next");
                    System.out.println();
                    search((Stack<Integer>) stack.clone(),max,from-1, currentball,currentTeam);
                    currentball = ball;
                    currentTeam = team;
                    stack.pop();
                }else{
                    return;
                }

            }
    }


}
