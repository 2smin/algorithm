package programmers;

import java.util.*;

public class PG131129 {

    public static void main(String[] args) {
        PG131129 pg131129 = new PG131129();
        int[] ans = pg131129.solution(173);
        System.out.println(Arrays.toString(ans));
    }

    static List<Integer> dt = new ArrayList<>();

    int countMin = Integer.MAX_VALUE;
    int sbMax = 0;

    public int[] solution(int target) {

        dt.add(50);
        for(int i=1; i<=20; i++){
            if(!dt.contains(i*2))dt.add(i*2);
            if(!dt.contains(i*3))dt.add(i*3);
            if(!dt.contains(i))dt.add(i);
        }
        Collections.sort(dt, (o1, o2) -> o2 - o1);

        getDt(target, 0, 0, 0, new ArrayList<>());
        int[] answer = {countMin, sbMax};
        return answer;
    }

    public void getDt(int target, int count, int sb, int range, ArrayList<int[]> list){

        if(count > countMin) return;
        //target에서 해당 숫자로 나누어 떨어지는 최대 수를 구한다
        for(int i=range; i<dt.size(); i++){
            int num = dt.get(i);
            if(num > target) continue;

            for(int j=target/num; j>=1; j--){

                int n = num * j;
                int m = target - n;

                int newCount = count + j;
                if(newCount > countMin) return;
                int newSb = sb;

                if(num == 50 || num <= 20){ //single bool 인 경우 추가
                    newSb += j;
                }

                int[] newDt = {num,j};
                ArrayList<int[]> newList = (ArrayList<int[]>)list.clone();

                newList.add(newDt);

                if(m > 0){ //아직 수가 남았으면
                    getDt(m, newCount, newSb, i+1, newList);
                }else if(m == 0){ // 종료
                    if(countMin > newCount){
                        countMin = newCount;
                        sbMax = newSb;
                    }else if(countMin == newCount && sbMax < newSb){
                        sbMax = newSb;
                    }
                }else{
                    break;
                }
            }

        }
    }
}
