package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PG42586 {

    public static void main(String[] args){

        int[] prog = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] days = new int[prog.length];

        for(int i=0; i<prog.length; i++){

            days[i] = (int)Math.ceil((double)(100-prog[i]) / speeds[i]);

        }

        for(int i=0; i<days.length-1; i++){
            if(days[i] > days[i+1]){
                days[i+1] = days[i];
            }
        }

        ArrayList<Integer> output = new ArrayList<>();

        int count = 1;
        for(int i=0; i<days.length-1; i++){

            if(days[i] == days[i+1]){
                count++;
            }else{
                output.add(count);
                count = 1;
            }

        }

        output.add(count);

        System.out.println(output);


    }
}

