package programmers;

import java.util.Arrays;

public class PG152995 {

    public static void main(String[] args) {
        PG152995 sol = new PG152995();
        System.out.println(sol.solution(new int[][]{{2,2},{1,1},{1,4},{3,2},{3,2},{2,1}}));
    }

    public int solution(int[][] scores) {
        int[] wanho = scores[0];

        Arrays.sort(scores, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        int maxScore = 0;
        int wanhoSum = wanho[0] + wanho[1];
        int rank = 1;
        for(int[] score : scores){

            if(score[1] < maxScore){
                if(score.equals(wanho)){
                    return -1;
                }
            }else{
                maxScore = Math.max(maxScore,score[1]);
                int sum = score[0] + score[1];
                if(sum > wanhoSum) rank++;
            }
        }
       return rank;
    }


}
