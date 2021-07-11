package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ11000 {

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

        for(int i=0; i<N; i++){
            String[] inputs = bf.readLine().split(" ");
            int[] times = new int[]{Integer.valueOf(inputs[0]),Integer.valueOf(inputs[1])};
            priorQ.offer(times);
        }


        //하나씩 꺼내면서 꺼낸건 0으로 만든다
        int count = 0;
        int recycleSize = 1;
        do{
            //다시 쓸 강의 넣기
            ArrayList<int[]> recycle = new ArrayList<>();
//            System.out.println("priorQ:");
//            for(int[] arr : priorQ){
//                System.out.print(Arrays.toString(arr)+" ");
//            }

            int[] lec1 = priorQ.remove();
            int endTime = lec1[1];

            while(!priorQ.isEmpty()){

                int[] lec = priorQ.remove();
                int startTime = lec[0];

//                System.out.println("StartTime: " + startTime);
//                System.out.println("endTime: " + endTime);

                //꺼낸것의 시작 시간이 다음 사용 가능이면
                if(startTime >= endTime){
                    //꺼낸것의 종료시간이 다음 시작시간이 된다.
                    endTime = lec[1];
                    continue;
                }else{
                    recycle.add(lec);
                }

            }

//            System.out.println("recycleQ:");
//            for(int[] arr : recycleQ){
//                System.out.print(Arrays.toString(arr)+" ");
//            }

            for(int i=0; i<recycle.size(); i++){
                priorQ.offer(recycle.get(i));
            }

            count++;
            //꺼낸게 안맞으면 재활용 큐에 넣는다.
        }while(priorQ.size() != 0);

        System.out.println(count);

    }
}
