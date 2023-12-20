package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PG60062 {

    public static void main(String[] args) {
        PG60062 pg = new PG60062();
        int[] weak =
                {1, 3, 4, 9, 10}
        ;
        int[] dist =
                {3, 5, 7}
        ;
        pg.solution(12, weak, dist);
    }
    public static int[] weak;
    public static int[] dist;
    public static int min = 111;
    public static int n;

    public int solution(int n, int[] weak, int[] dist) {
        this.weak = weak;
        this.dist = dist;
        this.n = n;
        /*
        모든 weak 만들기
         */

        boolean[] visited = new boolean[dist.length];
        int[] distCase = new int[dist.length];
        combination(distCase,visited,0);
        return min == 111 ? -1 : min;
    }

    public void getNextWeakArr(){
        int tmp = weak[0];
        for(int i = 0; i< weak.length-1; i++){
            weak[i] = weak[i+1];
        }
        weak[weak.length-1] = tmp + n;
    }


    public void combination(int[] distCase, boolean[] visited, int idx) {
        if(idx == dist.length) {
            doCheck(distCase);
            return;
        }

        for(int i=0; i<dist.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                distCase[idx] = dist[i];
                combination(distCase, visited, idx+1);
                visited[i] = false;
            }
        }
    }

    public void doCheck(int[] distCase){
        int currentNum = 0;

        //weak 초기화
        for(int i=0; i<weak.length; i++){

            currentNum = 0;
            int pos = 0;

            //친구 순회하기
            for(int j=0; j<distCase.length; j++){
                currentNum = j+1;
                int friend = distCase[j];
                int wall = weak[pos];

                //친구 벽 돌리기
                int reachable = friend + wall;
                while(reachable >= weak[pos]){
                    pos++;
                    if(pos == weak.length){
                        break;
                    }
                }
                if(pos == weak.length){
                    break;
                }

            }
            if(pos == weak.length){
                min = Math.min(min, currentNum);
            }
            getNextWeakArr();
        }
    }


}