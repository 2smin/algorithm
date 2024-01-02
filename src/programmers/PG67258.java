package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PG67258 {

    public static void main(String[] args) {
        PG67258 pg = new PG67258();

        String[] gems =
                {"ZZZ", "YYY", "NNNN", "YYY", "BBB"}
                ;

        pg.solution(gems);

        System.out.println("minStart : " + (pg.minStart+1));
        System.out.println("minEnd: " + (pg.minEnd+1));;
    }

    String[] gems;
    Set<String> gemSet = new HashSet<>();
    Map<String, Integer> remainedGem = new HashMap<>();

    int startPoint = -1;
    int endPoint = -1;

    int min = 100001;
    int minStart = 0;
    int minEnd = 100001;

    public int[] solution(String[] gems) {
        this.gems = gems;
        createCollections();
        moveEndpoint();
        int[] answer = new int[2];
        answer[0] = minStart+1;
        answer[1] = minEnd+1;
        return answer;
    }

    public void moveEndpoint(){
        if(endPoint == gems.length-1) return;
        while(!gemSet.isEmpty() && ++endPoint < gems.length){
            String currentGem = gems[endPoint];
            remainedGem.put(currentGem,remainedGem.get(currentGem) + 1);
            gemSet.remove(currentGem);
        }
        if(gemSet.isEmpty()) moveStartPoint();
    }

    public void moveStartPoint(){
        if(startPoint == gems.length-1) return;
        String currentGem = null;
        int currentGemRemained = 1000000;
        while(currentGemRemained != 0){
            currentGem = gems[++startPoint];
            currentGemRemained = remainedGem.get(currentGem) - 1;
            remainedGem.put(currentGem,currentGemRemained);

            if(min > endPoint - startPoint){
                min = endPoint - startPoint;
                minStart = startPoint;
                minEnd = endPoint;
            }
            if(currentGemRemained == 0){
                gemSet.add(currentGem);
            }
        }
        moveEndpoint();
    }

    public void createCollections(){
        for(String gem : gems){
            gemSet.add(gem);
            if(!remainedGem.containsKey(gem)){
                remainedGem.put(gem,0);
            }
        }
    }

    /*
    1. endpoint는 모든 원소가 다 포함될때까지 이동
    2. startpoint는 원소가 하나라도 빌때까지 이동

    endpoint가 이동이 끝난후, startpoint가 멈출때까지 기록한다.
    기록은 point 값의 뺼셈이 더 낮을 걸로 한다. min을 구해야 하니까.

    Set을 으로 Endpoint에서 빼낸다
    StartPoint는 Entry에서 num을 빼면서 0이 생기면 endpoint 옮기기로 전환
     */
}
