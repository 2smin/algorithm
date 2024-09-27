package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj11724 {

    private static int N;
    private static int M;

    private static int[] arr;
    private static int[][] map;
    private static Queue<Integer> queue = new LinkedList<>();
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] settings = bf.readLine().split(" ");
        N = Integer.valueOf(settings[0]);
        M = Integer.valueOf(settings[1]);

        arr = new int[N+1];
        map = new int[N+1][N+1];

        for(int i=0; i<M; i++){
            String[] line = bf.readLine().split(" ");
            int from = Integer.valueOf(line[0]);
            int to = Integer.valueOf(line[1]);

            map[from][to] = map[to][from] = 1;
        }

        for(int i=1; i<N+1; i++){
            if(i == 1){
                DFS(i,i);
            }else{
                if(arr[i] == 0) DFS(i,i);
            }
        }

        Set<Integer> answer = new HashSet<>();

        int single = 0;
        for(int i=1; i<arr.length; i++){
            if(arr[i] == 0) single++;
            else answer.add(arr[i]);
        }

        System.out.println(answer.size() + single);

    }

    public static void DFS(int current, int count){

        for(int next=1; next<N+1; next++){
            if(map[current][next] == 1){ //연결된 경우에
                arr[current] = count;
                if(arr[next] != 0) continue; //딴데랑 연결되거나 이미 연결되었으면 패스
                DFS(next, count);
            }
        }
    }
}
