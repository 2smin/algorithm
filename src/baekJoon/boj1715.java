package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj1715 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int cards;
    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        cards = Integer.valueOf(bf.readLine());

        for(int i=0; i<cards; i++){
            queue.offer(Integer.valueOf(bf.readLine()));
        }

        int count = 0;

        while(queue.size() != 1){
            int num1 = queue.poll();
            int num2 = queue.poll();
            int merge = num1 + num2;
            count += merge;
            queue.offer(merge);
        }

        System.out.println(count);
    }

}
