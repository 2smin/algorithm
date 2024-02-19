package programmers;

import java.util.*;
public class PG49189 {

    // 인접리스트로 시간 단축하기
    class Solution {

        class Node implements Comparable<Node>{
            int index;
            int dist;

            public Node(int index, int dist){
                this.index = index;
                this.dist = dist;
            }

            @Override
            public int compareTo(Node n) {
                if(this.dist < n.dist){
                    return -1;
                }
                return 1;
            }
        }


        List<ArrayList<Integer>> graph = new ArrayList<>();
        int[] minimal;
        boolean[] visited;
        int max = 0;
        int maxCnt;
        Queue<Node> queue = new PriorityQueue<Node>();

        public int solution(int n, int[][] edge) {

            for(int i=0; i<n+1; i++){
                graph.add(new ArrayList<>());
            }
            for(int[] point : edge){
                int x = point[0];
                int y = point[1];

                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            minimal = new int[n+1];
            Arrays.fill(minimal, 50001);
            minimal[1] = minimal[0] = 0;
            visited = new boolean[n+1];

            queue.offer(new Node(1,0));
            while(!queue.isEmpty()){

                Node node = queue.poll();
                if(visited[node.index]) continue;

                ArrayList<Integer> indexGraph = graph.get(node.index);
                for(int i : indexGraph){
                    int currentDist = node.dist + 1;

                    if(minimal[i] > currentDist){
                        minimal[i] = currentDist;
                        queue.offer(new Node(i,currentDist));
                    }
                }

                visited[node.index] = true;
            }

            for(int i : minimal){
                if(max < i){
                    max = i;
                    maxCnt = 1;
                }else if(max == i){
                    maxCnt++;
                }
            }

            int answer = maxCnt;
            return answer;
        }
    }
}
