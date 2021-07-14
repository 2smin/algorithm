package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2512 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.valueOf(bf.readLine());
        String[] arr = bf.readLine().split(" ");

        long[] request = new long[N];
        long max = 0;
        long sum = 0;

        for(int i=0; i<N; i++){
            request[i] = Integer.valueOf(arr[i]);
            max = Math.max(max,request[i]);
            sum += request[i];
        }

        long M = Integer.valueOf(bf.readLine());

        long start = 1;
        long end = max;
        long limit = 0;

        if(sum <= M){
            limit = max;
        }else{
            long middle = 0;
            long aprvlimit = 0;

            while(start <= end){


                middle = (start+end)/2;

//                System.out.println("start: " + start);
//                System.out.println("middle: " + middle);
//                System.out.println("end: "  + end);
                long total = 0;
                for(int i=0; i<request.length; i++){
                    total += request[i] >= middle ? middle : request[i];
                }
//                System.out.println("total: " + total);
//                System.out.println();

                if(total <= M){
                    aprvlimit = middle;
                    start = middle + 1;
                }else{
                    end = middle -1;
                }
            }

            limit = aprvlimit;

        }

        System.out.println(limit);
    }
}
