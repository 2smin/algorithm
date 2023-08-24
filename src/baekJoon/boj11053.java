package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj11053 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int num;
    static int[] arr;
    static int[] dpTable;
    static int answer = 1;
    public static void main(String[] args) throws IOException {

        num = Integer.valueOf(bf.readLine());
        arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dpTable = new int[num];

        for(int i=0; i<num; i++){
            dpTable[i] = 0;
        }
        dp();
        System.out.println(answer);
    }

    public static void dp(){
        dpTable[0] = 1;
        for(int i=1; i<num; i++){
            dpTable[i] = 1;
            for(int j=0; j<i; j++){

                if(arr[i] > arr[j] && dpTable[i] <= dpTable[j]){
                    dpTable[i] = dpTable[j] + 1;
                }
            }

            answer = Math.max(answer,dpTable[i]);
        }
    }
}
