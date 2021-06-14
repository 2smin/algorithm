package programmers;

import java.util.ArrayList;

public class PG42626 {
    //직접 heapify 구현 -> 일부 테스트케이스 실패
    public static void main(String[] args) {

        int[] scovile = {1,1,2};
        int K = 3;

        ArrayList<Integer> sHeap = new ArrayList<>();

        for(int num : scovile){sHeap.add(num);}


        //최초 힙정렬 수행
        sHeap = doHeap(sHeap);
        System.out.println(sHeap);

        int count = 0;

        while(sHeap.get(0) < K){

            //스코빌을 섞는다
            int tmp = 1000000;
            int index = 0;
            for(int i=1; i<sHeap.size(); i++){
                if(sHeap.get(i) < tmp){
                    tmp = sHeap.get(i);
                    index = i;
                }
            }

            System.out.println("min: " + sHeap.get(0));
            System.out.println("next min : " + sHeap.get(index));

            sHeap.set(0, sHeap.get(0) + (tmp*2));
            sHeap.remove(index);
            count++;


            sHeap = doHeap(sHeap);
            System.out.println(sHeap);

            if(sHeap.size()<2 && sHeap.get(0) < K){
                System.out.println(-1);
                break;
            }
        }

        System.out.println(sHeap);
        System.out.println(count);

    }

    public static ArrayList<Integer> doHeap(ArrayList<Integer> sHeap){

        for(int i=1; i<sHeap.size(); i++){

            int c = i;

            do{
                int root = (c-1)/2;

                if(sHeap.get(c) < sHeap.get(root)){
                    int tmp = sHeap.get(c);
                    sHeap.set(c, sHeap.get(root));
                    sHeap.set(root, tmp);
                }

                c = root;
            }while(c!=0);
        }

        return sHeap;
    }
}
