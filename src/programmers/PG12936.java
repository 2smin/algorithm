package programmers;

import java.util.ArrayList;

public class PG12936 {


    public static void main(String[] args) {
        PG12936 pg = new PG12936();
        int[] result = pg.solution(3, 5);
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
    static ArrayList<Integer> list;

    public int[] solution(int n, long k) {

        list = new ArrayList<>();
        long fac = 1;
        for(int i=1; i<n+1; i++){
            fac *= i;
            list.add(i);
        }

        int[] answer = new int[n];

        /*
        k가 몇번째에 속하는지 알아내자
        */
        //남은숫자를 꺼내는법
        k--;
        int i = 0;
        while(n > 0){
            fac/= n;
            answer[i] = list.remove((int)(k/fac));// 그 숫자 안에서 또 몇번째 남았는지
            k %= fac;
            i++;
            n--;
        }
        return answer;
    }


}