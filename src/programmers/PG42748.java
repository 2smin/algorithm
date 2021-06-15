package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class PG42748 {

    public static void main(String[] args) {

        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};

        ArrayList<Integer> output = new ArrayList<>();
        for(int[] com : commands){

            if(array.length>1){

                int[] spliced = Arrays.copyOfRange(array,com[0]-1,com[1]);
                Arrays.sort(spliced);
                output.add(spliced[com[2]-1]);
            }else{
                output.add(array[0]);
            }
            int level = 0;

            if(level == 1){
                System.out.println("level1");
            }

        }

        System.out.println(output);
    }
}
