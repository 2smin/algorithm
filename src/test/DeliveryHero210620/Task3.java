package test.DeliveryHero210620;

import java.util.*;

public class Task3 {

    public static void main(String[] args) {

        int[] A = {0,5,4,4,5,12};

        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> finQue = new LinkedList<>();
        int startIndex = 0;
        int lastIndex = 0;

        int count = 0;
        int lastCount = 0;

        for(int i=0; i<A.length; i++){

            set.add(A[i]);


            //하나씩 넣어서 map의 size가 2를 넘어면 다시 시작,
            if(set.size() > 2){

                //이전것보다 길 때
                if(lastCount<count){
                    lastCount = count;
                    finQue = queue;
                }

                set.add(A[i]);
                count = 0;

            }//안넘어가면 Queue에 하나씩 넣고 count를 올린다

            queue.add(A[i]);
            count++;


            finQue.toArray();
        }

        System.out.println(count);
        System.out.println(finQue);
    }
}
