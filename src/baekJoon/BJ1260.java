package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1260 {

    static int[][] graphe;
    static int node;
    static int start;
    static int edge;

    static Stack<Integer> stack = new Stack<>();
    static boolean[] stackC;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String[] inputArr = input.split(" ");

        node = Integer.valueOf(inputArr[0]);
        edge = Integer.valueOf(inputArr[1]);
        start = Integer.valueOf(inputArr[2]);

        graphe = new int[node+1][node+1];
        stackC = new boolean[node+1];

        int total = edge;
        while(total-- > 0){
            String egdeInput = bf.readLine();
            String[] edgeArr = egdeInput.split(" ");
            graphe[Integer.valueOf(edgeArr[0])][Integer.valueOf(edgeArr[1])]
                    = graphe[Integer.valueOf(edgeArr[1])][Integer.valueOf(edgeArr[0])]
                    = 1;
        }

        dfs(start);
        System.out.println();
        bfs(start);
    }

    public static void dfs(int start){

        stack.push(start);
        stackC[start] = true;

        int x = stack.peek();
        System.out.print(x + " ");
        for(int i=0; i<graphe[x].length; i++){

            int y = graphe[x][i];

            if(y!=0 && !stackC[i]){

                stackC[i] = true;

                dfs(i);
            }
        }

    }

    public static void bfs(int start){
        boolean[] c = new boolean[node+1];
        Queue<Integer> queue = new LinkedList();

        queue.add(start);
        c[start] = true;

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()){
            int x = queue.remove();

            sb.append(x + " ");

            for(int i=0; i<graphe[x].length; i++){
                int y = graphe[x][i];

                if(y!=0 && !c[i]){
                    queue.add(i);
                    c[i] = true;
                }
            }
        }

        System.out.println(sb);

    }

}
