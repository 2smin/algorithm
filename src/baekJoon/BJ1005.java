package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//2차원 배열 사용한 그래프로 풀어보자..
public class BJ1005 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int[] timeArr;

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());

        while (total-- > 0) {

            String[] input = bf.readLine().split(" ");

            int numOfBuild = Integer.valueOf(input[0]);
            int numOfPrior = Integer.valueOf(input[1]);

            //건설시간 배열
            String[] time = bf.readLine().split(" ");
            timeArr = new int[numOfBuild + 1];
            for (int i = 0; i < time.length; i++) {
                timeArr[i + 1] = Integer.valueOf(time[i]);
            }

            //건설우선순위 map
            int[][] contructMap = new int[numOfBuild + 1][numOfBuild + 1];

            for (int i = 0; i < numOfPrior; i++) {
                String[] prior = bf.readLine().split(" ");
                contructMap[Integer.valueOf(prior[1])][Integer.valueOf(prior[0])] = 1;
            }

            for (int[] arr : contructMap) {
                System.out.println(Arrays.toString(arr));
            }

            int count = Integer.valueOf(bf.readLine());

            //건설여부 list
            boolean[] contructed = new boolean[numOfBuild + 1];

            //1. 1번부터 건설하면서 시간 체크한다.
            //2. 다음 건설 가능한 건물들에 이전 걸린시간을 더한다.
            //3. contructed에 true가 완료갯수와 일치시 시간배열의 최댓값을 출력

        }
    }
}
