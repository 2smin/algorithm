package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj11497 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int testCase ;

    public static void main(String[] args) throws IOException {

        testCase = Integer.valueOf(bf.readLine());

        while(testCase-- != 0){
            int size = Integer.valueOf(bf.readLine());
            int level = 0;
            int[] group = Arrays.stream(bf.readLine().split(" ")).mapToInt(str -> Integer.valueOf(str)).toArray();

            Arrays.sort(group);

            for(int i=0; i<size; i++){
                int next = 0;
                if(i == 0){
                   int left = Math.abs(group[0] - group[1]);
                   int right = Math.abs(group[0] - group[2]);
                   next = Math.max(left,right);
                }else if (i < size-2){
                    next = Math.abs(group[i] - group[i+2]);
                }else if (i == size-2){
                    next = Math.abs(group[i] - group[i+1]);
                }else if (i == size-1){
                    next = Math.abs(group[i] - group[i-1]);
                }
                level = Math.max(level, next);
            }
            System.out.println(level);
        }

    }
}
