package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ1697 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int K;

    static Queue<Integer> queue = new LinkedList<>();

    static int[] map = new int[100001];

    public static void main(String[] args) throws IOException {

        String[] arr = bf.readLine().split(" ");

        N = Integer.valueOf(arr[0]);
        K = Integer.valueOf(arr[1]);

        int count = BFS();
        System.out.println(count);
    }

    static int BFS(){

        queue.offer(N);
        int output = 0;

        while(!queue.isEmpty()){

            int x = queue.poll();
            int count = map[x];

            //동생위치 도달시 count 반환
            if(x == K){
                output = count;
                break;
            }

            //움직임 배열
            int[] move = new int[3];

            move[0] = x-1;
            move[1] = x+1;
            move[2] = x*2;


            //범위를 벗어나지 않고 한번 왔던데가 아니면 queue에 삽입
            for(int pos : move){
                if(pos >= 0 && pos<=100000 && map[pos] == 0){
                    queue.add(pos);
                    map[pos] = count+1; //카운트 1 올려서 map 갱신
                }
            }
        }

        return output;
    }
}
