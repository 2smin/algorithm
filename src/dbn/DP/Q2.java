package dbn.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q2 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int[] arr = new int[300001];

    public static void main(String[] args) throws IOException {

        int num = Integer.valueOf(bf.readLine());

        System.out.println(BFS(num));

        System.out.println(Arrays.toString(arr26));

    }

    public static int BFS(int num){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        int output = 0;

        while(!queue.isEmpty()){

            int removed = queue.remove();

            if(removed == num){
                output = arr[removed];
                break;}

            if(arr[removed+1] == 0){
                queue.offer(removed+1);
                arr[removed+1] =  arr[removed]+1;
            }

            if(arr[removed*2] == 0){
                queue.offer(removed*2);
                arr[removed*2] =  arr[removed]+1;
            }

            if(arr[removed*3] == 0){
                queue.offer(removed*3);
                arr[removed*3] =  arr[removed]+1;
            }

            if(arr[removed*5] == 0){
                queue.offer(removed*5);
                arr[removed*5] =  arr[removed]+1;
            }

        }

        return output;
    }
}
