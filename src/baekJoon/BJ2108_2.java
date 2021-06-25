package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2108_2 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        int total = Integer.valueOf(bf.readLine());

        String[] inputArr = bf.readLine().split(" ");
        int[] numArr = new int[total];
        for(int i=0; i<inputArr.length; i++){
            numArr[i] = Integer.valueOf(inputArr[i]);

        }

        int[] sortedArr = numArr.clone();
        Arrays.sort(sortedArr);

        HashMap<Integer,Integer> map = new HashMap<>();

        int k = 0;
        for(int i : sortedArr){

            if(!map.containsKey(i)){
                map.put(i,k++);
            }
        }

        for(int i : numArr){
            sb.append(map.get(i)).append(" ");
        }

        System.out.println(sb);

    }

}
