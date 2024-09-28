package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj18352 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int N, M, K, X;
    static int[] djk;
    static int[] visited;
    static Set<Integer> inserted = new HashSet<>();

    static Map<Integer, Node18> listMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        String[] settings = bf.readLine().split(" ");
        N = Integer.valueOf(settings[0]);
        M = Integer.valueOf(settings[1]);
        K = Integer.valueOf(settings[2]);
        X = Integer.valueOf(settings[3]);

        djk = new int[N+1];
        Arrays.fill(djk,10000001);
        visited = new int[N+1];

        for(int i=0; i<M; i++){
            String[] path = bf.readLine().split(" ");
            int A = Integer.valueOf(path[0]);
            int B = Integer.valueOf(path[1]);

            if(listMap.containsKey(A)){
                Node18 nodeA = listMap.get(A);
                nodeA.child.add(B);
            }else{
                Node18 nodeA = new Node18();
                nodeA.num = A;
                nodeA.child.add(B);
                listMap.put(A,nodeA);
            }

            if(!listMap.containsKey(B)){
                Node18 nodeB = new Node18();
                nodeB.num = B;
                listMap.put(B,nodeB);
            }
        }

        /*
        인접리스트로 하면? arrayList로 한 다음에 거기서 하나하나 하자
        map에다가 arrayList를 넣자
         */

        int from = X;
        djk[from] = 0;
        Queue<Node18> queue = new PriorityQueue<>();
        queue.offer(listMap.get(from));
        while(!queue.isEmpty()){

            Node18 currentNode = queue.poll();
            visited[currentNode.num] = 1;

            if(currentNode.child.size() == 0) { //방문 가능한 노드가 없으면
                continue;
            }
            for(int i : currentNode.child){ //방문 가능한 노드들에 대해서
                djk[i] = Math.min(djk[currentNode.num]+1, djk[i]); //최단거리 갱신
                //queue에 넣는다 근데 한번 넣은건 또 넣으면 안됌
                if(visited[i] != 1){
                    queue.offer(listMap.get(i));
                }
            }
            //다음 방문하지 않은 곳에서 가장 가까운곳
        }

//        for(int s : djk){
//            System.out.printf(s + " ");
//        }
//        System.out.println();

        Set<Integer> answer = new HashSet<>();
        for(int i=1; i<djk.length; i++){
            if(djk[i] == K) answer.add(i);
        }

        if(answer.isEmpty()){
            System.out.println(-1);
        }else{
            answer.stream().sorted().forEach(System.out::println);
        }


    }
}

class Node18 implements Comparable<Node18>{
    public int num;
    public List<Integer> child = new ArrayList<>();

    @Override
    public int compareTo(Node18 o) {
        return boj18352.djk[num] - boj18352.djk[o.num];
    }
}
