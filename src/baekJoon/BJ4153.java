package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ4153 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){

            String[] input = bf.readLine().split(" ");

            int[] inputNum = new int[3];
            for(int i=0; i<input.length; i++){inputNum[i] = Integer.valueOf(input[i]);}

            if(inputNum[0] == 0 && inputNum[1] ==0 && inputNum[2] == 0){ break; }

            Arrays.sort(inputNum);

            int[] nums = new int[3];
            for(int i=0; i<3; i++){nums[i] = (int)Math.pow(Double.valueOf(inputNum[i]),2); }

            if(nums[0] + nums[1] != nums[2]){
                sb.append("wrong").append("\n");
            }else{
                sb.append("right").append("\n");
            }

        }

        System.out.println(sb);
    }
}
