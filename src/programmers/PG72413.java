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
    static Node[] nodeList;

    class Node implements Comparable{
        int num = 0;
        int fare = 100001;
        boolean visited = false;
        boolean inQueue = false;
        List<Integer> checkpoint = new ArrayList<>();

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

        for(int[] fare : fares){
            int from = fare[0];
            int to = fare[1];
            int money = fare[2];
            map[from][to] = map[to][from] = money;
        }
//
                Arrays.stream(map).forEach(strs -> { Arrays.stream(strs).forEach(str -> System.out.print(str + "   "));
            System.out.println();});

        nodeList = new Node[n+1];
        for(int i=0; i<n+1; i++){
            Node node = new Node();
            node.num = i;
            node.fare = 10001;
            nodeList[i] = node;
        }

        Queue<Node> queue = new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Node node1 = (Node)o1;
                Node node2 = (Node)o2;
                return node1.fare - node2.fare;
            }
        });

        nodeList[s].num = s;
        nodeList[s].fare = 0;
        nodeList[s].visited = true;
        nodeList[s].inQueue = true;

        queue.offer(nodeList[s]);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            node.visited = true;

            System.out.println("node :" + node.num);
            System.out.println("fare :" + node.fare);

            int[] reachable = map[node.num];
            for(int i=1; i<reachable.length; i++){
                if(reachable[i] == 0) continue;
                if(nodeList[i].visited) continue;

                if(nodeList[i].fare > reachable[i] + node.fare){
                    System.out.println("    nextNode : " + i);
                    System.out.println("    reachable : " + reachable[i]);
                    nodeList[i].fare = node.fare + reachable[i];
                    System.out.println("    nextFare : " + nodeList[i].fare);
                    nodeList[i].checkpoint = new ArrayList<>(node.checkpoint);
                    nodeList[i].checkpoint.add(node.num);
                    if(!nodeList[i].inQueue){
                        nodeList[i].inQueue = true;
                        queue.offer(nodeList[i]);
                    }
                }
            }
        }

        Arrays.stream(map).forEach(strs -> { Arrays.stream(strs).forEach(str -> System.out.print(str + "   "));
            System.out.println();});

        for(Node node : nodeList){
            node.checkpoint.add(node.num);
            System.out.println("Num :" + node.num + " , fare : " + node.fare);
            node.checkpoint.stream().forEach(System.out::print);
            System.out.println();
        }

        int aFare = nodeList[a].fare;
        int bFare = nodeList[b].fare;
        int aSize = nodeList[a].checkpoint.size();
        int bSize = nodeList[b].checkpoint.size();

        int sameNode = 100001;
        for(int i=0; i<Math.min(aSize,bSize); i++){
            if(nodeList[a].checkpoint.get(i) != nodeList[b].checkpoint.get(i)){
                break;
            }else{
                sameNode = nodeList[a].checkpoint.get(i);
            }
        }

        int answer = 0;
        if(sameNode!=10001){
            answer = aFare + bFare - nodeList[sameNode].fare;
        }else{
            answer = aFare + bFare;
        }
        return answer;
    }
}
