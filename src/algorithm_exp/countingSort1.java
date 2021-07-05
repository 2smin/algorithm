package algorithm_exp;

import java.util.Arrays;

public class countingSort1 {

    public static void main(String[] args){

        int[] count = new int[10];

        int[] arr = {5,5,2,5,2,2,5,1,1,1,4,4,10,1,5,2};

        for(int i=0; i<arr.length; i++){
            count[arr[i]-1]++;
        }

        for(int i=0; i<count.length; i++){
            if(count[i] != 0){
                for(int j=0; j<count[i]; j++){
                    System.out.print(i+1);
                }
            }
        }
    }
}
