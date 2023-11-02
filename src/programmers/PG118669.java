package programmers;

import java.util.*;

public class PG118669 {
    public class Node {
        public int edge;
        public int distance;

        public Node(int edge, int distance) {
            this.edge = edge;
            this.distance = distance;
        }
    }

    private static List<List<Node>> graph;
    public boolean isPeak(int node, int[] summits){
        for(int summit : summits){
            if(node == summit) return true;
        }
        return false;
    }

    public boolean isGate(int node, int[] gates){
        for(int gate : gates){
            if(node == gate) return true;
        }
        return false;
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        graph = new ArrayList<>();
        for(int i=0; i< n+1; i++) graph.add(new ArrayList<>());
       /*
       일단 이중리스트를 만들어서 넣자!
        */

        for(int[] node : paths){
            int from = node[0];
            int to = node[1];
            int distance = node[2];

            if(isGate(from, gates) || isPeak(to,summits)) {
                graph.get(from).add(new Node(to, distance));
            }else if (isGate(to,summits) || isPeak(from, gates)){
                graph.get(to).add(new Node(from, distance));
            }else{
                graph.get(from).add(new Node(to,distance));
                graph.get(to).add(new Node(from,distance));
            }
        }
        return dijkstra(n,gates,summits);
    }

    private int[] dijkstra(int n, int[] gates, int summit[]){

        Queue<Node> queue = new LinkedList<>();
        int[] intensity = new int[n+1];
        Arrays.fill(intensity,Integer.MAX_VALUE);
        for(int gate : gates){
            queue.add(new Node(gate,0));
            intensity[gate] = 0;
        }

        while(!queue.isEmpty()){
            Node po = queue.poll();

            if(intensity[po.edge] < po.distance) continue;

            for(int i=0; i<graph.get(po.edge).size(); i++){
                Node nextPo = graph.get(po.edge).get(i);

                int dist = Math.max(intensity[po.edge],nextPo.distance);
                if(intensity[nextPo.edge] > dist){
                    intensity[nextPo.edge] = dist;
                    queue.add(new Node(nextPo.edge, dist));
                }
            }
        }

        Arrays.sort(summit);
        int maxDis = Integer.MAX_VALUE;
        int peakNum = Integer.MAX_VALUE;

        for(int peak : summit){
            if(intensity[peak] < maxDis){
                maxDis = intensity[peak];
                peakNum = peak;
            }
        }

        return new int[]{peakNum,maxDis};
    }


}
