package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1325 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static int M;

    public static boolean[] visited;
    public static int[] hackCount;
    public static List<Integer>[] nodeArr;

    public static void main(String[] args) throws IOException {
        //역방향 dfs로 해서 풀어야 한다. 특정 노드가 다른 노드에게 몇번이나 신뢰받는지를 ++해주면 그게 특정 노드가 총 해킹 할 수 있는 숫자
        String[] input = bf.readLine().split(" ");

        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        visited = new boolean[N+1];
        hackCount = new int[N+1];
        nodeArr = new List[N+1];

        for (int i = 1; i <= N; i++) {
            nodeArr[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            String[] in = bf.readLine().split(" ");

            int A = Integer.valueOf(in[0]);
            int B = Integer.valueOf(in[1]);



            List<Integer> list = nodeArr[A];
            list.add(B);
            nodeArr[A] = list;


        }


        for(int i=1; i<=N; i++){
            visited = new boolean[N+1];
            visited[i] = true;
            hackCount[i]++;
            DFS(i);
        }

        int maxHackCount = 0;
        for (int i = 1; i <= N; i++) {
            maxHackCount = Math.max(maxHackCount, hackCount[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (hackCount[i] == maxHackCount) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);

    }

    public static void DFS(int i){

        List<Integer> trustList = nodeArr[i];
        for(int trustNode : trustList){
            if(!visited[trustNode]){
                visited[trustNode] = true;
                hackCount[trustNode]++;
                DFS(trustNode);
            }
        }

    }



}


