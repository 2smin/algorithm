package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2606 {

    public static int total;
    public static int connect;
    public static int[][] network;
    public static boolean[][] checked;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        total = Integer.valueOf(bf.readLine());
        connect = Integer.valueOf(bf.readLine());

        network = new int[total+1][total+1];
        checked = new boolean[total+1][total+1];

        for(int i=0; i<connect; i++) {
            String[] input = bf.readLine().split(" ");

            for(int j=0; j<2; j++){
                network[Integer.valueOf(input[0])][Integer.valueOf(input[1])]
                        = network[Integer.valueOf(input[1])][Integer.valueOf(input[0])]
                        = 1;}

        }

        ArrayList<Integer> numArr = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<total+1; i++){

            if(network[1][i] != 0){

                for(int j=0; j<total+1; j++){
                    checked[j][i] = true;
                }

                queue.add(i);
                numArr.add(i);
            }
        }

        while(!queue.isEmpty()){

            int com = queue.remove();

            for(int i=2; i<total+1; i++){
                if(network[com][i] != 0 && !checked[com][i]){
                    queue.add(i);
                    numArr.add(i);

                    for(int j=0; j<total+1; j++){
                        checked[j][i] = true;
                    }
                }
            }
        }

        System.out.println(numArr.size());
    }
}
