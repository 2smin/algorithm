package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1041 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        double N = Integer.valueOf(bf.readLine());

        double oneSide = (N-2)*(N-2)*5 + (N-2)*4;
        double twoSide = (N-1)*4 + (N-2)*4;
        double threeSide = 4;

        String[] strs = bf.readLine().split(" ");

        int[] nums = new int[strs.length];

        for(int i=0; i<nums.length; i++){
            nums[i] = Integer.valueOf(strs[i]);
        }

        int count = 0;
        int sum = 0;
        int[] selected = new int[3];

        if(N!=1){

            while(count < 3){

                int min = 51;
                int index = 0;

                //현재 배열에서 최솟값 찾기
                for(int i=0; i<6; i++){

                    if(nums[i] < min){
                        min = nums[i];
                        index = i;
                    }

                }

                nums[index] = nums[5-index] = 51;
                selected[count] = min;
                count++;
            }

            double sumOfOne = (double)selected[0] * oneSide;
            double sumOfTwo = (double)(selected[0] + selected[1]) * twoSide;
            double sumOfThree = (double) (selected[0] + selected[1] + selected[2]) * threeSide;

            System.out.println(Math.round(sumOfOne+sumOfTwo+sumOfThree));

        }else{
            Arrays.sort(nums);
            for(int i=0; i<nums.length-1; i++){ sum += nums[i]; }
            System.out.println(sum);
        }

    }
}
