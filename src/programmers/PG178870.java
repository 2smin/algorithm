package programmers;

import javax.lang.model.type.IntersectionType;
import java.util.Arrays;
import java.util.Collections;

public class PG178870 {


    public static void main(String[] args) {

        int[] arr =
                {2,2,2,2,2}
                ;
        int k =
                6
                ;
        PG178870 pg = new PG178870();
        int[] ans = pg.solution(arr,k);

        System.out.println();
        System.out.println(ans[0] + ", " + ans[1]);
    }
    /*
    sequence를 뒤집어서 투포인터로 해결
    dp에 현재 start pointer에서 합이 k랑 일치하도록 하는 갯수를 넣는다
     */

    int[] dp;
    public int[] solution(int[] sequence, int k) {

        dp =  new int[sequence.length];

        int start=0;
        int sum = 0;
        int end=0;

        int xPos = -1;
        int yPos = -1;

        int min = 10000001;

        /*
        종료 조건 = start가 끝에 도달하거나 start 혼자서 k를 넘길때

         */

        for(int i = 0; i < sequence.length; i++){
            end++;
            sum += sequence[i];
            if(sum < k) continue;

            if(sum == k){
                if(min > end - start + 1){
                    min = end - start + 1;
                    xPos = start;
                    yPos = end - 1;
                }
            }
            else{
                while(sum > k){
                    sum -= sequence[start++];
                }
                if(sum == k){
                    if(min > end - start + 1){
                        min = end - start + 1;
                        xPos = start;
                        yPos = end - 1;
                    }
                }
            }
        }
        return new int[]{xPos, yPos};
    }

}
