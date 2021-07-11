package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ11000_2 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static Comparator<int[]> comparator = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[2] > o2[2]){
                return 1;
            }else if (o1[2] < o1[2]){
                return -1;
            }else{
                return o1[0] > o2[0] ? 1 : -1;
            }
        }
    };

    public static void main(String[] args) throws IOException {

        int N = Integer.valueOf(bf.readLine());

        PriorityQueue<int[]> priorQ = new PriorityQueue<>(comparator);

        for(int i=0; i<N; i++){
            String[] inputs = bf.readLine().split(" ");
            int[] times = new int[]{Integer.valueOf(inputs[0]),Integer.valueOf(inputs[1]),1};
            priorQ.offer(times);
        }


        //하나씩 꺼내면서 꺼낸건 0으로 만든다
        int count = 1;
        int recycleSize = 1;

            //다시 쓸 강의 넣기
//            System.out.println("priorQ:");
//            for(int[] arr : priorQ){
//                System.out.print(Arrays.toString(arr)+" ");
//            }

        int endTime = 0;
        while(!priorQ.isEmpty()){

            int[] lec = priorQ.remove();
            int startTime = lec[0];

            System.out.println();
            System.out.println(Arrays.toString(lec));
            System.out.print("in q:");
            for(int[] arr : priorQ){
                System.out.print(Arrays.toString(arr)+" ");
            }
            System.out.println();

            //count 넘어간게 나오면 0으로 초기화
            if(lec[2] != count){
                endTime = 0;
                count++;
            }

            if(startTime >= endTime){
                //꺼낸것의 종료시간이 다음 시작시간이 된다.
                endTime = lec[1];
            }else{
                lec[2] = lec[2]+1;
                priorQ.offer(lec);
            }

            if(priorQ.isEmpty()){
                System.out.println(lec[2]);
            }

        }

//            System.out.println("recycleQ:");
//            for(int[] arr : recycleQ){
//                System.out.print(Arrays.toString(arr)+" ");
//            }


//        System.out.println(count);

    }
}
