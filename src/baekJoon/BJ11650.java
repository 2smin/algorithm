package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ11650 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());

        int[][] arr = new int[total][2];

        for(int i=0; i<total; i++){
            int[] position = new int[2];
            String[] input = bf.readLine().split(" ");

            position[0] = Integer.valueOf(input[0]);
            position[1] = Integer.valueOf(input[1]);

            arr[i] = position;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[0] > o2[0]){
                    return 1;
                }else if(o1[0] == o2[0]){
                    return o1[1] > o2[1] ? 1 : -1;
                }else{
                    return -1;
                }
            }
        });

        for(int[] array : arr){
            sb.append(array[0] + " " + array[1]).append("\n");
        }

        System.out.println(sb);
    }
}
