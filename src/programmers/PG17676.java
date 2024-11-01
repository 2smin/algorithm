package programmers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class PG17676 {

    public static void main(String[] args) {

String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};

        PG17676 pg17676 = new PG17676();
        System.out.println(pg17676.solution(lines));
    }
    class Node {
        int start;
        int end;
    }

    static Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.end - o2.end;
        }
    });

    static Queue<Node> stQueue = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.start - o2.start;
        }
    });

    static int start = Integer.MAX_VALUE;
    static int end = Integer.MIN_VALUE;

    static int max = 0;
    public int solution(String[] lines) {
        if(lines.length == 1) return 1;

        for(int i=0; i<lines.length; i++){
            String l = lines[i];
            String logTime = l.split(" ")[1];
            String pcsTimeWithS = l.split(" ")[2];
            String pcsTime = pcsTimeWithS.substring(0,pcsTimeWithS.length()-1);

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
            LocalTime time = LocalTime.parse(logTime,fmt);

            int endMillis = (int)ChronoUnit.MILLIS.between(LocalTime.MIDNIGHT,time) + 3000;
            int spentMillis = (int)(Double.valueOf(pcsTime) * 1000);
            int startMillis = endMillis - spentMillis + 1;

            // System.out.println("from  : " + startMillis + ", end : " + millis);

            start = Math.min(start, startMillis);
            end = Math.max(end,endMillis);
            // System.out.println("start, end : " + start + ", " + end);

            Node node = new Node();
            node.start = start;
            node.end = end;
            stQueue.offer(node);
        }

        //start가 0 부터 1000까지 먼저 넣는다
        while(!stQueue.isEmpty() && stQueue.peek().start < 1000){
            queue.offer(stQueue.poll());
        }

        max = Math.max(max,queue.size());

        for(int i=1000; i<=end; i++){

            int tail = i-1000;
            int head = i;

            while(!stQueue.isEmpty() && stQueue.peek().start <= head){
                Node node = stQueue.poll();
                queue.offer(node);
            }

            while(!queue.isEmpty() && queue.peek().end <= tail){
                queue.poll();
            }

            max = Math.max(max,queue.size());
        }

        return max;
    }
}