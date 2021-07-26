package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2212 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.valueOf(bf.readLine());
        int K = Integer.valueOf(bf.readLine());

        String[] arr = bf.readLine().split(" ");
        int[] positions = new int[arr.length];

        int[] distance = new int[arr.length-1];

        for(int i=0; i<positions.length; i++){
            positions[i] = Integer.valueOf(arr[i]);
        }

        Arrays.sort(positions);
//        System.out.println(Arrays.toString(positions));
        for(int i=0; i<distance.length; i++){
            distance[i] = positions[i+1] - positions[i];
        }

//        System.out.println(Arrays.toString(distance));

        int num = K-1;
        while(num-- > 0){

            int max = 0;

            int index = 0;
            for(int i=0; i<distance.length; i++){

                if(max<distance[i]){
                    max = distance[i];
                    index = i;
                }
            }

            if(max == 0){ break; }

            distance[index] = 0;
        }

        int sum = 0;
        for(int count : distance){
            sum += count;
        }

        System.out.println(sum);

    }
}
