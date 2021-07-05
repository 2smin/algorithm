package dbn.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q5 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());

        String[] arr = bf.readLine().split(" ");
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<total; i++){
           list.add(Integer.valueOf(arr[i]));
        }

        Collections.reverse(list);

        int[] count = new int[total];
        count[0] = 1;
        System.out.println(list);
        for(int i=0; i<total; i++){
            for(int j=0; j<i; j++){
                if(list.get(j) < list.get(i)){
                    count[i] = Math.max(count[i],count[j]+1);
                }
            }
        }

        int maxValue = 0;
        for(int i=0; i<total; i++){
            maxValue = Math.max(maxValue,count[i]);
        }

        System.out.println(Arrays.toString(count));
        System.out.println(total-maxValue);

    }
}
