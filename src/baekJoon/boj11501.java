package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11501 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    private static int T;
    private static int N;
    private static long[] day;
    private static long sum;
    private static long[] answer;
    public static void main(String[] args) throws IOException {


        /*
        전체 중에서 가장 가격이 높은날 구한다
        그 전까지 다 산다
        높은날 다음부터 다시 반복

         */

        T = Integer.valueOf(bf.readLine());
        answer = new long[T];

        for(int i=0; i<T; i++){

            N = Integer.valueOf(bf.readLine());
            day = new long[N];
            sum = 0;
            String[] arr = bf.readLine().split(" ");
            for(int j=0; j<arr.length; j++){
                day[j] = Integer.valueOf(arr[j]);
            }

            int start = 0;
            while(start < N){
                start = calculate(start);
            }

            answer[i] = sum;
        }

        for(long ans : answer){
            System.out.println(ans);
        }
    }

    public static int calculate(int start){
        long max = 0;
        int maxDate = 0;
        for(int i=start; i<day.length; i++){
            if(max <= day[i]){
                max = day[i];
                maxDate = i;
            }
        }

        for(int i=start; i<maxDate; i++){
            sum += max-day[i];
        }

        return maxDate+1;
    }
}
