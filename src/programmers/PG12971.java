package programmers;

import java.util.Arrays;

public class PG12971 {

    public static void main(String[] args) {

        PG12971 pg = new PG12971();

        int[] sticker =
                {1, 3, 2, 5, 4}
                ;
       int answer = pg.solution(sticker);
        System.out.println("answer :" + answer);
    }

    static int[] dp1;
    static int[] dp2;

    public int solution(int sticker[]) {
        int answer = 0;

        if(sticker.length <= 3){
            return Arrays.stream(sticker).max().getAsInt();
        }

        dp1 = new int[sticker.length];
        dp2 = new int[sticker.length];

        dp1[0] = sticker[0];
        dp1[1] = 0;
        dp1[2] = sticker[2] + dp1[0];
        for(int i=3; i<sticker.length-1; i++){
            dp1[i] = Math.max(dp1[i-2],dp1[i-3])  + sticker[i];
        }

        dp2[0] = 0;
        dp2[1] = sticker[1];
        dp2[2] = dp2[0] + sticker[2];

        for(int i=3; i<sticker.length; i++){
            dp2[i] = Math.max(dp2[i-2], dp2[i-3]) + sticker[i];
        }

        for(int i : dp1){
            System.out.printf(i + " ");
        }
        System.out.println();

        for(int i : dp2){
            System.out.printf(i + " ");
        }

        int dp1Max = Arrays.stream(dp1).max().getAsInt();
        int dp2Max = Arrays.stream(dp2).max().getAsInt();
        answer = Math.max(dp1Max,dp2Max);
        return answer;
    }
}
