package programmers;

import java.util.*;

public class PG132266 {

    public static void main(String[] args) {
        PG132266 sol = new PG132266();

        int[] answer = sol.solution(5, new int[][]{{1,2},{1,4},{2,2},{2,5},{4,5}}, new int[]{1,3,5}, 5);
        for(int i : answer){
            System.out.print(i + " ");
        }
    }

    Map<Integer, ArrayList<Integer>> map;
    boolean[] visited;
    int[] lengthMap;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        int[] answer = new int[sources.length];

        map = new HashMap<>();
        visited = new boolean[n+1];
        lengthMap = new int[n+1];

        for(int[] road : roads){
            int from = road[0];
            int start = road[1];

            ArrayList<Integer> listA = map.getOrDefault(from,new ArrayList<Integer>());
            listA.add(start);
            map.put(from,listA);

            ArrayList<Integer> listB = map.getOrDefault(start,new ArrayList<Integer>());
            listB.add(from);
            map.put(start,listB);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(destination);
        visited[destination] = true;
        while(!queue.isEmpty()){
            int visit = queue.poll();
            ArrayList<Integer> reachableNodes = map.get(visit);
            for(int nodes : reachableNodes){
                if(!visited[nodes]){
                    visited[nodes] = true;
                    lengthMap[nodes] = lengthMap[visit] + 1;
                    queue.offer(nodes);
                }
            }
        }

        for(int i=0; i< lengthMap.length; i++){
            if(lengthMap[i] == 0 && i != destination){
                lengthMap[i] = -1;
            }
        }
        for(int i=0; i< sources.length; i++){
            answer[i] = lengthMap[sources[i]];
        }
        return answer;
    }
}
