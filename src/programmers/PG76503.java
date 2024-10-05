package programmers;

import java.util.*;

public class PG76503 {

    /*
    각 node의 언급된 수 가 1이 되면 걔가 child
    각 node마다 link된 얘들 저장해놓기
    child에서 소거하면 parent의 노드에서 child꺼도 소거

     */

    //Map으로 관리, 본인 parent를 저장

    public static void main(String[] args) {

        PG76503 pg = new PG76503();

        int[] a =
                {0,1,0}
                ;

        int[][] edges =
                {{0,1},{1,2}}
                ;
        long answer = pg.solution(a,edges);
        System.out.println("ansewr : " + answer);
    }
    static Map<Integer, ArrayList<Integer>> linkMap = new HashMap<>();
    static int[] point;
    static long answer;

    public long solution(int[] a, int[][] edges) {

        point = a;

        if(a.length < 3){
            int sum = 0;
            for(int i : a){
                sum+=i;
            }
            if(sum == 0) return Math.abs(a[0]);
            else return -1;
        }

        for(int i=0; i<edges.length; i++){
            int[] edge = edges[i];
            int from = edge[0];
            int to = edge[1];

            if(!linkMap.containsKey(from)){
                ArrayList<Integer> list = new ArrayList<>();
                linkMap.put(from,list);
            }
            linkMap.get(from).add(to);

            if(!linkMap.containsKey(to)){
                ArrayList<Integer> list = new ArrayList<>();
                linkMap.put(to,list);
            }
            linkMap.get(to).add(from);
        }

        long sum = DFS(0,0);
        if(sum != 0) return -1;
        /*
        0번부터 시작해서 DFS 수행, call이 1이 나올때가 정점
        call이 1이 나오면 거기서 돌아오면서 가중치를 가져와서 부모꺼에 더한다.

        부모 set에서 link를 제거? visited쓸거니까 제거 안해도 된다.
        30만개를 다 돌아야하나?
         */
//
//        System.out.println("ansewr : " + answer);
        return answer;
    }
    public long DFS(int current, int parent){

        if(parent != current){ //최초노드는 이거 안탐
            linkMap.get(current).remove(Integer.valueOf(parent)); //내꺼에서 부모 삭제
        }
        //내려가자
        long sum = point[current];

        if(linkMap.get(current).size() == 0){ // leaf node 인 경우
            answer += Math.abs(sum); //이동시켜야한다
            return sum;
        }

        ArrayList<Integer> list = linkMap.get(current);
        for(int i=0; i<list.size(); i++){ //child에 대해서
            int childNode = list.get(i);
            long child = DFS(childNode, current);
            sum += child; //자식꺼 더하기
        }

        //child 옮기기가 다 끝났으면 본인도 옮겨야한다
        answer += Math.abs(sum);
        return sum;
    }
}

