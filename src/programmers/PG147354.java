package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class PG147354 {

    public static void main(String[] args) {

        PG147354 pg = new PG147354();

        int[][] data =
                {{2,4,6},{1,5,10},{4,2,9},{3,8,3},{5,2,3},{5,5,9}}
                ;

        int ans = pg.solution(data,2,2,6);
        System.out.println("ans :  " + ans);

    }

    static int column = 0;
    static int begin = 0;
    static int end = 0;

    static int[] bit;
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        column = col-1;
        begin = row_begin-1;
        end = row_end;
        bit = new int[data.length];
        Arrays.sort(data, (o1, o2) -> {

            if(o1[column] < o2[column]){
                return -1;
            }else if (o1[column] == o2[column]){
                return o1[0] > o2[0] ? -1 : 1;
            }else{
                return 1;
            }
        });

        for(int i=begin; i<end; i++){
            int sum = 0;
            for(int j=0; j<data[0].length; j++){
                int remained = data[i][j] % (i+1);
                sum+=remained;
            }
            answer = answer ^ sum;
        }


//        for(int i=0; i<data.length; i++){
//            System.out.println();
//            for(int j=0; j<data[0].length; j++){
//                System.out.printf(data[i][j] + " ");
//            }
//        }
//
//        System.out.println();

        return answer;
    }
}
