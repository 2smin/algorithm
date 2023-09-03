package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class boj2565 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int [][] lines;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        N = Integer.valueOf(bf.readLine());
        lines = new int[N][2];
        for(int i=0; i<N; i++){
            int[] line = Arrays.stream(bf.readLine().split(" ")).mapToInt((str -> Integer.valueOf(str))).toArray();
            lines[i] = line;
        }

        Arrays.sort(lines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2[0]) {
                    return 1;
                }
                return -1;
            }
        });
//            Arrays.stream(lines).forEach(ints -> System.out.print("["+ ints[0] + "," + ints[1]+"] "));
//        System.out.println();
        arr = new int[N];
        dp  = new int[N];
        for(int i=0; i<N; i++){
            int[] ints = lines[i];
            arr[i] = ints[1];
            dp[i] = 1;
        }
        dp();
//        Arrays.stream(dp).forEach(ints -> System.out.print(ints));

        System.out.println(N - Arrays.stream(dp).max().getAsInt());

    }

    public static void dp(){
        dp[0] = 1;
        for(int i=1; i<N; i++){
            for(int j=i-1; j>=0; j--) {
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
    }
}
