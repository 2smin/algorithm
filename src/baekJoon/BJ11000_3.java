package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ11000_3 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static Comparator<int[]> comparator = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {

            return o1[0] > o2[0] ? 1 : -1;

        }
    };

    public static void main(String[] args) throws IOException {

        int N = Integer.valueOf(bf.readLine());

        PriorityQueue<int[]> priorQ = new PriorityQueue<>(comparator);
        PriorityQueue<Integer> endTime = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            String[] inputs = bf.readLine().split(" ");
            int[] times = new int[]{Integer.valueOf(inputs[0]),Integer.valueOf(inputs[1]),1};
            priorQ.offer(times);
        }

        while(!priorQ.isEmpty()){

            int[] lecture = priorQ.poll();

            int start = lecture[0];
            int end = lecture[1];

            if(endTime.size() != 0 && start >= endTime.peek()){
                endTime.poll();
            }

            endTime.offer(end);

        }

        System.out.println(endTime.size());

    }
}
