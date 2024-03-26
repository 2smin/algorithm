package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj2251 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int[] sizes = new int[3];
    static int Csize;

    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][][] checked = new boolean[201][201][201];

    static int[] directionX = {0,1,2};
    static int[] directionY = {0,1,2};
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        sizes = Arrays.stream(bf.readLine().split(" ")).mapToInt(str -> Integer.valueOf(str)).toArray();
        Csize = sizes[2];

        dfs(0,0,Csize);
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for(int a : answer){
            sb.append(a).append(" ");
        }

        System.out.println(sb.toString());

    }

    private static void dfs(int a, int b, int c){

        if(a == 0){
            if(!answer.contains(c)){
                answer.add(c);
            }
        }

        for(int x : directionX){
            for(int y : directionY){
                if(x==y) continue;
                int[] bottle = new int[]{a,b,c};

                int availAmount = sizes[y] - bottle[y];
                if(availAmount >= bottle[x]){
                    bottle[y] += bottle[x];
                    bottle[x] = 0;
                }else{
                    bottle[y] += availAmount;
                    bottle[x] -= availAmount;
                }

                int aa = bottle[0];
                int bb = bottle[1];
                int cc = bottle[2];

                if(checked[aa][bb][cc]){
//                    System.out.println("skip || a:" + aa + ", b:" + bb + ", c:" + cc );
                    continue;
                }else{
                    checked[aa][bb][cc] = true;
//                    System.out.println("a:" + aa + ", b:" + bb + ", c:" + cc );
                    dfs(aa,bb,cc);
                }
            }
        }
    }
}
