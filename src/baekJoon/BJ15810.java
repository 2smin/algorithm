package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ15810 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] arr = bf.readLine().split(" ");

        int N = Integer.valueOf(arr[0]);
        int M = Integer.valueOf(arr[1]);

        String[] times = bf.readLine().split(" ");
        long[] timeArr = new long[N];
//        Arrays.sort(timeArr);

        long max = 0;
        for(int i=0; i<times.length; i++){
            int time = Integer.valueOf(times[i]);
            if(max <= time){ max = time;}
            timeArr[i] = time;
        }

        long start = 1;
        long end = max*M;
        long count = 0;
        long fin = 0;

        while(start <= end){

            long middle = (start + end) / 2;

            count = 0;

            for(int i=0; i<timeArr.length; i++){
                count += middle / timeArr[i];
            }

            if(count < M){
                start = middle+1;
            }else{
                fin = middle;
                end = middle-1;
            }
        }

        System.out.println(fin);
    }

}
