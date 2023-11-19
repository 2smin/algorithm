package programmers;

import java.util.*;

public class PG77486 {

    public static void main(String[] args) {
        PG77486 pg = new PG77486();

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] refere = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        int[] answer = pg.solution(enroll,refere,seller,amount);
        for(int ans : answer){
            System.out.printf(ans + ", ");
        }
    }
    Map<String, Info> unionMap = new HashMap<>();
    int[] answerArr;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        answerArr = new int[enroll.length];
        for(int i=0; i<enroll.length; i++){
            Info info = new Info();

            info.referer = referral[i];

            unionMap.put(enroll[i], info);
        }

        for(int i=0; i<seller.length; i++){
            unionMap.get(seller[i]).sellList.add(amount[i] * 100);
        }

        sell(enroll);
        return answerArr;
    }

    public void sell(String[] enroll){
        for(int i=enroll.length-1; i>=0; i--) {
            Info info = unionMap.get(enroll[i]);
            if(info.sellList.size() > 0) {
                for(int sell : info.sellList){
                    int toMe = calculate(sell);
                    int toReferer = sell - toMe;
                    String referer = info.referer;

                    unionMap.get(enroll[i]).profit += toMe;
                    if(!referer.equals("-") && toReferer!= 0){
                        unionMap.get(referer).sellList.add(toReferer);
                    }

                }
            }
            answerArr[i] = info.profit;
        }

    }

    public int calculate(int input){
        Double amount = (double) input;
        if(Math.floor(amount*0.1) < 1){
            return input;
        }else{
            return (int)(amount - Math.floor(amount*0.1));
        }
    }

}

class Info {
    String referer;
    int profit = 0;
    ArrayList<Integer> sellList = new ArrayList<>();

    @Override
    public String toString() {
        return "Info{" +
                "referer='" + referer + '\'' +
                ", profit=" + profit +
                '}';
    }

}

/*
 속도 빠르게 하기!
 1. referer 로 등록이 안된 애들이 제일 아래에 있다
 걔들 부터 시작해서 findReferer를 할 떄 다음 위에가 나온다
 그떄 referer에게 주는 금액 계산과 동시에 걔들이 판매한 돈 계산을 같이 한다.

 조건은 아래 노드가 싹 다 계산되어있어야 한다.
 그럼 노드간 레벨을 어떻게 나눌까>??


 union을 하면서 depth 만큼 레벨을 둔다.
이건 enroll의 순서가 depth를 꼬이지는 않게 하니까 enroll 역순으로 하면 될듯

필요한 자료구조
sell은 일단 다 합쳐놓고
sell이 없어도 referer로 받은걸 줘야하니까 싹 다 순회해야함

이름으로 찾고 바로 referer로 찾아야한다 근데 index도 유지해야한다.
그럼 map에서 꺼내서 하는 순서는 enroll 순서로 하되 실제로 꺼내오는건 map에서 하자
 */
