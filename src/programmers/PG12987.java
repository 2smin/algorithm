package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PG12987 {

    public static void main(String[] args) {

        PG12987 pg = new PG12987();

        int[] A =
                {1,2,5,8,10}
                ;
        int[] B =
                {2,2,3,6,11}
                ;

        int answer = pg.solution(A,B);
        System.out.println("answer : " + answer);
    }

    static Queue<Integer> queue = new PriorityQueue<>();
    public int solution(int[] A, int[] B) {

        int[] sortedA = Arrays.stream(A).sorted().toArray();

        for(int i=0; i<B.length; i++){
            queue.offer(B[i]);
        }

        int count = 0;

        int i = 0;
        while(!queue.isEmpty()){
            int numB = queue.poll();
            if(numB > sortedA[i]){
                count++;
                i++;
            }
        }

        return count;
    }
}
