package programmers;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PG42626_2 {
    //priorityQueue 사용
    public static void main(String[] args) {
        int[] scovile = {0, 0, 3, 9, 10, 12};
        int K = 1;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int num : scovile){queue.offer(num);}

        int count = 0;
        while(queue.peek() < K){

            if(queue.size() < 2){
                count = -1;
                break;
            }

            int min = queue.poll();
            int min2 = queue.poll();

            queue.offer(min + (min2*2));
            count++;

        }

        System.out.println(count);
    }

}
