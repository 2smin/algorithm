package dbn.Implemetation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q4 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        String input = bf.readLine();

        PriorityQueue<Character> list = new PriorityQueue<>();

        int sum = 0;

        for(int i=0; i<input.length(); i++){

            if(input.charAt(i) <= 57){
                sum += input.charAt(i) - 48;
            }else{
                list.add(input.charAt(i));
            }
        }

        String outout = "";

        while(!list.isEmpty()){
            outout+= list.remove();
        }

        System.out.println(outout+sum);

    }
}
