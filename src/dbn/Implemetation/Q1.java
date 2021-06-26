package dbn.Implemetation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;

    static int[] move = {1,-1};
    public static void main(String[] args) throws IOException {

        int size = Integer.valueOf(bf.readLine());

        map = new int[size+1][size+1];

        String[] direction = bf.readLine().split(" ");

        int[] position = {1,1};

        for(String dir : direction){

            if(dir.equals("R") && position[1]<size+1){
                position[1] += move[0];

            }else if(dir.equals("L") && position[1]>1){
                position[1] += move[1];

            }else if(dir.equals("U") && position[0]>1){
                position[0] += move[1];

            }else if(dir.equals("D") && position[0]<size+1){
                position[0] += move[0];
            }
        }

        System.out.println(Arrays.toString(position));
    }
}
