package programmers;

import java.util.Arrays;

public class PG43105 {

    public static void main(String[] args) {
        PG43105 pg = new PG43105();

        int[][] triangle =
                {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        System.out.println("answer : " + pg.solution(triangle));
    }


    static int length;
    static int[][] tri;
    public int solution(int[][] triangle) {

        /*
        level 만큼 내려가면서 하자 현재 레벨 저장해야함
         */

        length = triangle.length;
        tri = triangle;

        for(int i=1; i<tri.length; i++){
            check(i);
        }
//
//        Arrays.stream(tri).forEach(ints -> { Arrays.stream(ints).forEach(num -> System.out.printf(String.format("%-7s", num)));
//            System.out.println();});

        int answer = 0;
        for(int i=0; i<tri[length-1].length; i++){
            answer = Math.max(answer,tri[length-1][i]);
        }
        return answer;
    }

    private void check(int curLevel){

        /*
        tri의 level에서 순회하면서 윗 레벨 양옆 비교하고 자기자신 바꾼다
        이걸 level의 현재 사이즈만큼
         */

        int[] curLevelList = tri[curLevel];

        for(int i=0; i<curLevelList.length; i++){
            int preLeft = 0;
            int preRight = 0;
            if(i!=0){
                preLeft = tri[curLevel-1][i-1];
            }
            if(i!=curLevelList.length-1){
                preRight = tri[curLevel-1][i];
            }

            int current = curLevelList[i];
            curLevelList[i] = Math.max(current + preRight, current + preLeft);
        }
    }
}
