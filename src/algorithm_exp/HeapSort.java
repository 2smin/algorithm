package algorithm_exp;

import java.util.ArrayList;
import java.util.List;

public class HeapSort {

    static int num = 10;
    static List<Integer> arr = new ArrayList(num);

    static List<Integer> heapList = new ArrayList<>(num);
    public static void main(String[] args) {

        for(int i=0; i<num; i++){
            arr.add((int)(Math.random()*100));
        }

        System.out.println("unsorted : " + arr);

        for(int i=0; i<num; i++){
            heap(arr.get(i));
        }


        System.out.println("sorted : " + heapList);


    }

    public static void heapify(){
        int tmp = 0;
        tmp = arr.get(0);
        arr.set(0, arr.get(arr.size()-1));
        arr.set(arr.size()-1, tmp);

    }
    public static void heap(int num){

        heapList.add(num);

        int node= heapList.size()-1;
        for(int i=node; i>=0; i= i/2){
            if(heapList.get(i) > heapList.get(i/2)){
                int temp = heapList.get(i);
                heapList.set(i, heapList.get(i/2));
                heapList.set(i/2, temp);
            }else{
                break;
            }
        }

        arr = heapList;
    }
}
