package programmers;

import java.util.*;

public class PG181188 {

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[][] input = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
        System.out.println(sol.solution(input));
    }

    static class Solution{

        public int solution(int[][] targets){

            Arrays.sort(targets, (o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            });

           int start = -1;
           int count = 0;

           for(int i=0; i<targets.length; i++){
               int[] rocket = targets[i];

               if(rocket[0] >= start){
                   count++;
                   start = rocket[1];
               }
           }

           return count;
        }
    }
}
