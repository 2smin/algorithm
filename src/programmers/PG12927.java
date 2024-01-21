package programmers;

import java.util.Arrays;
import java.util.Collections;

public class PG12927 {

    public static void main(String[] args) {
        PG12927 pg = new PG12927();

        int n =
                4
                ;
        int[] works =
                {4,3,3}
                ;

        System.out.println("answer: " + pg.solution(n,works));
    }

    static Integer[] workArr;

    public long solution(int n, int[] works) {
        workArr = Arrays.stream(works).boxed().toArray(Integer[]::new);
        Arrays.sort(workArr, Collections.reverseOrder());

        int currentMax = workArr[0];
        int nextMax = 0;
        int pos = 0;
        while(n > 0){

            for(int i=pos; i<workArr.length; i++){
                if(workArr[i] != currentMax){
                    pos = i;
                    nextMax = workArr[pos];
                    break;
                }
                if(i == workArr.length-1 && workArr[i] == currentMax){
                    pos = i+1;
                    nextMax = currentMax;
                }
            }

            //최대 몇까지 뺄수 있는지
            //남은 n에서 한개당 뺼수있는 갯수
            int count = n/(pos);
            //모두 공평하게 못뺴면
            if(count == 0){
                //최대한 하나씩 뺴기
                for(int i=0; i<n; i++){
                    if(workArr[i] - 1 <= 0){
                        workArr[i] = 0;
                    }else{
                        workArr[i] -= 1;
                    }
                }
                break;
            }else{ //공평하게 가능하면
                //만약 다 뺼수 있으면
                int available = 0;
                //모두 다 같은 숫자가 되면 통일시킨다
                if(currentMax == nextMax){
                    available = currentMax;
                }else{
                    available = currentMax - nextMax;
                }
                int negative = 0; //이만큼 뺸다
                if(count > available){ // nextMax까지 문제 없는경우
                    negative = available; //그만큼 다 뺀다
                }else{ // nextMax까지 못뺴는 경우
                    negative = count; //가능한 만큼만 뺀다
                }

                //뺀다
                for(int i=0; i<pos; i++){
                    if(workArr[i] - negative <= 0){
                        workArr[i] = 0;
                    }else{
                        workArr[i] = workArr[i] - negative;
                    }
                }
                //남은거 계산
                n -= negative*pos;
                currentMax = nextMax;
            }

        }

//        Arrays.stream(workArr).forEach(ints -> {
//            System.out.printf(ints + " ");});

        long answer = 0;
        for(int num : workArr){
            answer += num*num;
        }
        return answer;
    }
}
