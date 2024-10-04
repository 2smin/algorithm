package programmers;

import java.util.*;

public class PG340211 {

    public static void main(String[] args) {

        PG340211 pg = new PG340211();

        int[][] points =
                {{3, 2}, {6, 4}, {4, 7}, {1, 4}}
                ;
        int[][] routes =
                {{4, 2}, {1, 3}, {4, 2}, {4, 3}}
                ;

        int answer = pg.solution(points,routes);

        System.out.println("answer : " + answer);
    }
    static int[][] visit;
    static int[][] current;
    static Map<Integer,Stack<int[]>> destMap = new HashMap<>();
    static int answer;
    static int remained;
    static Set<String> totalCur = new HashSet<>();
    public int solution(int[][] points, int[][] routes) {

        visit = new int[101][101];

        current = new int[routes.length][2];
        remained = routes.length;

        //start end 나누기
        //end가 여러개인 경우도 있으니까 map+array로 하자
        for(int i=0; i<routes.length; i++){
            int[] robot = routes[i];


            if(!destMap.containsKey(i)){
                destMap.put(i,new Stack<>());
            }

            for(int j=robot.length-1; j>=0; j--){
                if(j == 0){
                    int startNum = robot[j];
                    current[i] = points[startNum-1];
                }else{
                    int endNum = robot[j];
                    destMap.get(i).add(points[endNum-1]);
                }
            }
        }

        //최초 체크
        for(int[] cur : current){
            visit[cur[0]][cur[1]]++;
            totalCur.add(cur[0]+"/"+cur[1]);
        }
        checkDuplicate();
        visit = new int[101][101];
        totalCur.clear();

        while(remained > 0){ //더 없을떄까지

            for(int i = 0; i< current.length; i++){ //계속 돌린다.

                int[] cur = current[i];
                if(destMap.get(i).isEmpty()) continue;
                int[] des = destMap.get(i).pop();

                if(cur[0] == des[0] && cur[1] == des[1]){
                    if(destMap.get(i).isEmpty()){
                        remained--;
                        continue;
                    }
                    des = destMap.get(i).pop();
                }else{

                }

                int curX = cur[0];
                int curY = cur[1];
                if(curX == -1 && curY == -1) continue;

                int destX = des[0];
                int destY = des[1];

                int[] newCur = new int[2];
                if(curX != destX && curY != destY){
                    newCur[0] = getNextPos(curX,destX);
                    newCur[1] = curY;
                }else if (curX == destX && curY != destY){
                    newCur[0] = curX;
                    newCur[1] = getNextPos(curY,destY);
                }else if (curX != destX && curY == destY){
                    newCur[0] = getNextPos(curX,destX);
                    newCur[1] = curY;
                }

                //이동 완료 했으니 visited에 변경
                visit[newCur[0]][newCur[1]]++;
                totalCur.add(newCur[0]+"/"+newCur[1]);

                //목적지 도달한건 빼야한다
                destMap.get(i).push(des);
                current[i] = newCur;
            }
            //충돌 체크 근데 다 돌지 말고 contains로 하자
            checkDuplicate();
            //한바퀴 돌고 visited를 갱신한다
            visit = new int[101][101];
            totalCur.clear();
        }
        return answer;
    }


    public int getNextPos(int cur, int des){
        if(cur < des) return cur+1;
        else return cur-1;
    }

    public void checkDuplicate(){
        for(String i : totalCur){
            int x = Integer.valueOf(i.split("/")[0]);
            int y = Integer.valueOf(i.split("/")[1]);
            if(visit[x][y] > 1) answer++;
        }
    }
}
