package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class PG60062_2 {

    public static void main(String[] args) {

            PG60062_2 pg = new PG60062_2();

            int n = 12;
            int[] weak = new int[]{1, 5, 6, 10};
            int[] dist = new int[]{1,2,3,4};

            int ans = pg.solution(n, weak, dist);
            System.out.println(ans);

    }
    static int[] dists;
    static ArrayList<Integer> weaks = new ArrayList<>();

    static int min = Integer.MAX_VALUE;
    static int num;
    public int solution(int n, int[] weak, int[] dist) {

        dists = dist;
        num = weak.length;
        weaks =  new ArrayList<Integer>(weak.length);
        for(int i : weak){
            weaks.add(i);
        }

        for(int i=0; i<n*2; i++){

            int[] walls = new int[n*2];
            for(int wk : weaks){
                walls[wk] = -1;
                walls[wk+n] = -1;
            }

            if(weaks.contains(i)){
                dfs(i,walls,dist,0);
            }
        }
        int answer = min;
        if(answer == Integer.MAX_VALUE){
            return -1;
        }
        return answer;
    }

    public void dfs(int wallNum, int[] walls, int[] friends, int cnt){

        //들어온 wall 부터 시작한다
        //친구 하나 정해서 길이만큼 커버시킨다.
        for(int i=0; i<friends.length; i++){
            int newCnt = cnt;
            if(friends[i] == -1) continue;


            //다음 친구가 정해졌으니 친구 커버리지 만큼 체크
            int coverage = wallNum+friends[i];
            //해당 coverage에 weak가 포함되어있으면 갯수만큼 cnt 추가
            for(int j=wallNum; j<=coverage; j++){
                if(j < walls.length && walls[j] == -1){
                    newCnt++;
                }
            }

            //사용한 친구 리스트
            int[] nextFriend = friends.clone();
            nextFriend[i] = -1;

            if(coverage >= walls.length || newCnt >= num){
                int curMin = (int)Arrays.stream(nextFriend).filter(x -> x == -1).count();
                min = Math.min(min,curMin);
                return; //커버 초과하면 끝
            }

            int nextWall = -1;
            //다음 wall 찾기
            for(int k=coverage+1; k<walls.length; k++){
                if(walls[k] == -1){
                    nextWall = k;
                    break;
                }
            }

            if(nextWall == -1){
                int curMin = (int)Arrays.stream(friends).filter(x -> x == -1).count();
                min = Math.min(min,curMin);
                return; //벽이 더 없으면 끝
            }

            dfs(nextWall, walls, nextFriend, newCnt);

        }


    }

}
