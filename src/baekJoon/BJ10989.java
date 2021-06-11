package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10989 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.valueOf(bf.readLine());

        int[] arr = new int[total];

        for(int i=0; i<total; i++){
            arr[i] = Integer.valueOf(bf.readLine());
        }

        char[] numArr = new char[10000];

        for(int i=0; i<arr.length; i++){
            numArr[arr[i]-1]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numArr.length; i++){
            if(numArr[i] != 0){
                for(int j=0; j<numArr[i]; j++){
                    sb.append(i+1).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
