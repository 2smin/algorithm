package dbn.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q3 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());
        int[] arr = new int[total];
        String[] inputs = bf.readLine().split(" ");

        for(int i=0; i<total; i++){
            arr[i] = Integer.valueOf(inputs[i]);
        }

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int groupCount = 0;
        int count = 1;

        for(int i=0; i<arr.length; i++){

            if(arr[i] == count){
                groupCount++;
                count=1;
            }else{
                count++;
            }
        }

        System.out.println("Group: " + groupCount);
    }
}
