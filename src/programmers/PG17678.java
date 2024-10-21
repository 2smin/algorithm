package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PG17678 {

    public static void main(String[] args) {

        PG17678 pg17678 = new PG17678();
        int n = 2;
        int t = 10;
        int m = 2;
        String[] timetable = {"09:10", "09:10", "09:10"};
        System.out.println(pg17678.solution(n, t, m, timetable));
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
    }
    static Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    });

    static int[] cached = new int[1441];

    public String solution(int n, int t, int m, String[] timetable) {

        for(String tab : timetable){
            int hour = Integer.valueOf(tab.split(":")[0]);
            int min = Integer.valueOf(tab.split(":")[1]);

            int time = hour*60 + min;
            cached[time]++;
        }

        for(int i=0; i<1441; i++){
            if(cached[i] != 0) queue.offer(new int[]{i,cached[i]});
        }


        int shuttle = 1;
        int max = 0;
        for(int i=540; i<1441; i+=t){
            if(shuttle > n || queue.isEmpty()) break;
            //종료 조건 : shuttle이 n일때 혹은 queue가 더 없을때
            max = i;
            int remain = m;
            //remain 자리 채울수 있을떄까지 poll(), 해당시간 다 못타면 변경만
            while(remain > 0){ //자리 남을때
                if(queue.isEmpty()) break;
                if(queue.peek()[0] > i) break;
                if(queue.peek()[1] < remain){
                    int[] crews = queue.poll();
                    remain -= crews[1];
                    //딱 시간맞춰타면 된다
                }else if(queue.peek()[1] == remain){
                    int[] crews = queue.poll();
                    remain -= crews[1];
                    max = crews[0]-1;
                }else if(queue.peek()[1] > remain){
                    queue.peek()[1] -= remain;
                    remain = 0;
                    max = queue.peek()[0] - 1;
                }
            }
            shuttle++;
        }

        String finH = (max/60 + "").length() > 1 ? max/60 + "" : "0" + max/60;
        String finM = (max%60 + "").length() > 1 ? max%60 + "" : "0" + max%60;
        String answer = finH + ":" + finM;
        return answer;
    }
}