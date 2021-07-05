package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1003 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[][] count;

    static int[] zero = new int[]{1,0};
    static int[] one = new int[]{0,1};

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());

        while(total-- > 0){

            int num = Integer.valueOf(bf.readLine());

            count = new int[num+1][2];

            int[] fin = fibonacci(num);

            sb.append(fin[0] + " " + fin[1]).append("\n");
        }

        System.out.println(sb);
    }

    public static int[] fibonacci(int num){
        if(num == 1){return one; }
        if(num == 0){return zero; }

        //해당 수가 이미 구해져있으면 그대로 리턴
        if(count[num][0]+count[num][1] != 0){
            return count[num];
        }

        int[] child1 = fibonacci(num-1);
        int[] child2 = fibonacci(num-2);

        count[num] = new int[]{child1[0]+child2[0],child1[1]+child2[1]};
        return count[num];
    }
}
