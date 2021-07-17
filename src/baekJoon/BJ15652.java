package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ15652 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int M;

    static boolean[] visited;
    static int[] nums;

    public static void main(String[] args) throws IOException {

        String[] arr = bf.readLine().split(" ");
        N = Integer.valueOf(arr[0]);
        M = Integer.valueOf(arr[1]);

        visited = new boolean[N+1];
        nums = new int[M];

        backTracking(0,0);

        System.out.println(sb);

    }

    public static void backTracking(int n, int depth){

        if(depth == M){
            for(int num : nums){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=n; i<N; i++){

//            if(!visited[i]){
//                visited[i] = true;
                nums[depth] = i+1;
                backTracking(i,depth+1);
//                visited[i] = false;
//            }
        }

    }
}
