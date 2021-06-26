package dbn.Implemetation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q3 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int[][] step = {{-2,-1}, {-2,1}, {2,-1}, {2,1}, {-1,-2}, {-1,2}, {1,-2}, {1,2}};

    public static void main(String[] args) throws IOException {

        String input = bf.readLine();
        int[] position = {input.charAt(0) - 96, input.charAt(1) - 48};
        int count = 0;

        for(int[] move : step){
            int[] finPosition = {position[0] + move[0], position[1] + move[1]};

           if((finPosition[0] > 0 && finPosition[0] < 9) && (finPosition[1] > 0 && finPosition[1] < 9)){
               count++;
           }
        }

        System.out.println(count);
    }
}
