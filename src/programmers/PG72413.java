package programmers;

import java.util.*;

public class PG72413 {

    public static void main(String[] args) {
        PG72413 pg = new PG72413();
        int[][] map = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        int answer = pg.solution(6,4,6,2, map);
        System.out.println("ans" +
                answer);
    }
    static int[][] map;
    static Node[] aNodeList;
    static Node[] bNodeList;
    static Node[] sNodeList;

    class Node implements Comparable{
        int position = 0;
        int fare = 100001;
        boolean visited = false;
        boolean inQueue = false;

        @Override
        public int compareTo(Object o) {
            if(o instanceof Node){
               return ((Node) o).fare - this.fare;
            }
            return 0;
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        /*
        필요한것
        index별로 다녀온 노드를 넣을 수 있는 이중 queue
        최소값을 찾기 위한 최소값을 넣을 수 있는 queue
        거리를 저장할수 있는 index
         */

        map = new int[n+1][n+1];
        aNodeList  = new Node[n+1];
        bNodeList = new Node[n+1];
        sNodeList = new Node[n+1];

        for(int[] fare : fares){
            int from = fare[0];
            int to = fare[1];
            int money = fare[2];
            map[from][to] = map[to][from] = money;
        }
//
//                Arrays.stream(map).forEach(strs -> { Arrays.stream(strs).forEach(str -> System.out.print(str + "   "));
//            System.out.println();});

        dji(sNodeList,s,n);
        dji(aNodeList,a,n);
        dji(bNodeList,b,n);

//        print(sNodeList);
//        print(aNodeList);
//        print(bNodeList);

        int answer = 20000001;
        for(int i=0; i<n+1; i++){
            int currentTotal = sNodeList[i].fare + aNodeList[i].fare + bNodeList[i].fare;
            answer = Math.min(answer,currentTotal);
        }
        return answer;
    }

    public void dji(Node[] nodeList, int from, int n){

        for(int i=0; i<n+1; i++){
            Node node = new Node();
            node.position = i;
            node.fare = 1000001;
            node.visited = false;
            node.inQueue = false;
            nodeList[i] = node;
        }
        /*
        시작 노드를 세팅하고 넣는다.
        해당 노드에서 map을 보고 접근 가능한 노드 (0이 아닌 노드) 를 거리를 찾는다
        해당 노드의 거리를 업데이트한다 직전 노드의 거리까지 더해서 해당 노드의 거리보다 작은 경우 업데이트
        그리고 priority queue에 넣는다. 이떄 isExist가 false인 경우만 넣는다.
         */

        //start node 세팅
        nodeList[from].fare = 0;
        nodeList[from].visited = true;
        nodeList[from].inQueue = true;

        Queue<Node> queue = new PriorityQueue<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Node node1 = (Node)o1;
                Node node2 = (Node)o2;
                return node1.fare - node2.fare;
            }});
        queue.offer(nodeList[from]);

        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            currentNode.visited = true;
            //map에서 currentNode와 만나는 node 다 검색
            int[] reachableNodes = map[currentNode.position];
            for(int i=0; i<reachableNodes.length; i++){
                //만나지않는 노드 패스
                if(reachableNodes[i]==0) continue;
                //이미 방문한 노드 패스
                if(nodeList[i].visited) continue;
                //이제 방문 가능한 노드만 남았다 여기서 거리 체크, 기존 요금보다 더 싼지, 더 싼요금이면 갈아끼우자
                if(nodeList[i].fare > currentNode.fare + reachableNodes[i]){
                    nodeList[i].fare = currentNode.fare + reachableNodes[i];

                    //이미 queue에 있으면 넣자
                    if(!nodeList[i].inQueue){
                        nodeList[i].inQueue = true;
                        queue.offer(nodeList[i]);
                    }
                }
            }
        }

    }


    public void print(Node[] list){
        Arrays.stream(list).forEach(node -> {
            System.out.print(node.fare +", ");
        });

        System.out.println();
    }
}
