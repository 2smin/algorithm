package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj13549 {

    static int N;
    static int K;

    static String[] direction = {"back", "front", "warp"};

    static Queue<Integer> queue = new LinkedList<>();
    static int[] checked;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] settings = bf.readLine().split(" ");
        N = Integer.valueOf(settings[0]);
        K = Integer.valueOf(settings[1]);

//        int checkMax = Math.min(Math.max(N,K)*2,100001);
        checked = new int[100001];
        Arrays.fill(checked,100001);
        /*
        queue에다가 최초 위치 넣고,
         */
        checked[N] = 0;
        queue.add(N);
        while(!queue.isEmpty()){
            int pos = queue.poll();

            for(String dir : direction){

                int nextPos;
                if(dir.equals("back")){
                    if(pos-1 < 0) continue;
                    nextPos = pos-1;
                    if(checked[nextPos] > checked[pos] + 1){
                        checked[nextPos] = checked[pos] + 1;
                        queue.add(nextPos);

                    }
                }else if(dir.equals("front")){
                    if(pos+1 > 100000) continue;
                    nextPos = pos+1;
                    if(checked[nextPos] > checked[pos] + 1){
                        checked[nextPos] = checked[pos] + 1;
                        queue.add(nextPos);

                    }
                }else{
                    if(pos*2 > 100000) continue;
                    nextPos = pos*2;
                    if(checked[nextPos] > checked[pos]){
                        checked[nextPos] = checked[pos];
                        queue.add(nextPos);
                    }
                }
            }
        }

//        for(int i =0; i<checked.length; i++){
//            System.out.printf(checked[i] + " ");
//        }
//        System.out.println();
        System.out.println(checked[K]);

    }
}
