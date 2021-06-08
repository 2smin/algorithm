package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ9020 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.valueOf(bf.readLine());

        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> numList = numArr(10000);

        for(int t=0; t<total; t++){

            int num = Integer.valueOf(bf.readLine());
            int pivot = 0;

            for(int i=0; i<numList.size(); i++){
                if(numList.get(i) > num/2){
                    pivot = i-1;
                    break;
                }
            }

            int movei = 0;
            int movej = 0;

            while(true){

                int i = numList.get(pivot + movei);
                int j = numList.get(pivot + movej);

                if(i+j == num){
                    sb.append(i + " " + j).append("\n");
                    break;
                }else if(i+j < num){
                    movej++;
                }else if(i+j > num){
                    movei--;
                }
            }
        }

        System.out.println(sb);
    }

    public static ArrayList<Integer> numArr(int num){

        int[] arr = new int[num+1];

        for(int j=2; j<=num; j++){ arr[j] = j;}

        for(int j= 2; j<=num; j++){

            if(arr[j]==0){ continue;}

            for(int k= j+j; k<num+1; k+=j){ arr[k] = 0;}
        }

        ArrayList<Integer> numArr = new ArrayList<>();

        for(int j=0; j<arr.length; j++){
            if(arr[j] != 0){ numArr.add(arr[j]);}
        }
        return numArr;
    }
}
