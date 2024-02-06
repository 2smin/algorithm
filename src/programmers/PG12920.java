package programmers;

import java.util.Arrays;

public class PG12920 {

    public static void main(String[] args) {
        PG12920 pg = new PG12920();
        int n =
                6
                ;
        int[] cores =
                {1,2,3}
                ;
        System.out.println("answer : " + pg.solution(n,cores));
    }

    public int solution(int n, int[] cores) {

        /*
        이분탐색으로 n개가 나오는 시간을 구한다.

          최대시간은 n * 가장 느린 코어 처리속도
          최소는 0
          두 범위로 이분해서 시작
          정해진 시간 기준으로 각 코어별 나누기를 해서 n보다 많은경우, 아래로 이동

          이렇게 해서 최종 시간을 잡는다.
         */
        int min = 0;
        int max = n * cores[cores.length-1];
        int currentWork = 0;
        int preWork = 0;
        while(min < max){
            int pos = (max + min) / 2;

            currentWork = check(pos, cores);

            if(currentWork >= n){
                max = pos;
            }else{
                preWork = currentWork;
                min = pos + 1;
            }
        }

        int remainedWork = n - preWork;
        int answer = 0;
        for(int i=0; i<cores.length; i++){
            if(max % cores[i] == 0){
                remainedWork--;
            }
            if(remainedWork == 0){
                answer = i;
                break;
            }
        }
        return answer+1;
    }

    public int check(int pos, int[] cores){

        int currentWork = 0;
        for(int i=0; i< cores.length; i++){
            currentWork++;
            currentWork += (pos/cores[i]);
        }

        return currentWork;
    }
}
