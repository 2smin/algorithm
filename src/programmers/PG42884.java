package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class PG42884 {


    public static void main(String[] args) {

        int[][] arr =
                {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}
                ;
        PG42884 pg = new PG42884();
        pg.solution(arr);
    }
    public int solution(int[][] routes) {

        Arrays.sort(routes,
                new Comparator<int[]>(){
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[1] - o2[1];
                    }
                });

//        for(int[] arr : routes){
//            System.out.printf("[" + arr[0] + "," + arr[1] + "]");
//        }
        //맨 앞의 2번째 원소부터 줄을 긋는다.

        int camera = routes[0][1];
        int pos = 1;
        int totalCaped = 1;
        int totalCams = 0;
        while(totalCaped < routes.length){
            totalCams++;
            //현재 카메라에 걸리는 얘들 계산
            int currentCaped = 0;
            for(int i=pos; i<routes.length; i++){

                int[] car = routes[i];
                if(car[0] <= camera && camera <= car[1]){
                    currentCaped++;
                    continue;
                }else{
                    //카메라에 안잡히면, 카메라를 다음 차의 2번인덱스로 수정
                    //pos를 i로 변경
                    camera = routes[i][1];
                    pos = i;

                    break;
                }
            }
            totalCaped += currentCaped;
        }

        return totalCams;
    }
}
