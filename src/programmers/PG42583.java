package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PG42583 {

    public static void main(String[] args) {

        int[] truckArr = {7,4,5,6};

        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> truck = new LinkedList<>();

        int weight = 10;
        int length = 2;

        for(int i=0; i<length; i++){ bridge.add(0); }
        for(int num : truckArr){ truck.add(num); }

        int totalWeight = 0;
        int time = 0;

        while(!bridge.isEmpty()){

            totalWeight-=bridge.peek();
            bridge.poll();

            if(truck.isEmpty()){
                time += length;
                break;
            }else{
                if(totalWeight+truck.peek() <= weight){
                    bridge.offer(truck.peek());
                    totalWeight+= truck.peek();
                    truck.poll();
                }else{
                    bridge.offer(0);
                }
            }

            time++;
        }

        System.out.println(time);
    }

}
