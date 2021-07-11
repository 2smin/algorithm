package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1541 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String input = bf.readLine();

        input = input.replace("-" , " -");
        input = input.replace("+", " +");

        if(input.charAt(0) == ' '){
            input = input.substring(1);
        }

        String[] arr = input.split(" ");
        int[] expressions = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            expressions[i] = Integer.valueOf(arr[i]);
        }

        int sum = 0;

        for(int i=0; i<expressions.length-1; i++){

            if(expressions[i] < 0 && expressions[i+1] > 0){

                expressions[i+1] = 0 - expressions[i+1];
            }
        }

        for(int i : expressions){
            sum+= i;
        }

        System.out.println(sum);

    }
}
