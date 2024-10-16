package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Test {

    static int[][] potential;
    static int temp = 101;
    static int min;

    public static void main(String[] args) {

        Test t = new Test();

        t.solution(new int[]{0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220, 230},new int[]{7, 3, 9}, new int[]{9, 10, 1});
    }

    public int solution(int[] customers, int[] modelCapacities, int[] modelCosts) {

        int answer = 0;
        potential = new int[modelCapacities.length][2];
        for(int i=0; i<modelCapacities.length; i++){
            potential[i][0] = modelCapacities[i];
            potential[i][1] = modelCosts[i];
            if(temp > potential[i][1]){
                temp = potential[i][1];
                min = i;
            }
        }

        for(int i=0; i<customers.length; i++){
        /*
        해당 사람 기준으로 커버 가능한 각 비용 계산
        */
            int cust = customers[i];
            int sum = 0;
            while(cust > 0){

                int select = 0; //로봇번호
                int count = 0; //로봇 횟수
                int pot = 10000;

                for(int j=0; j<potential.length; j++){
                    //여러개 중 최대로 커버 가능한거 고른다
                    int m = cust/potential[j][0];
                    int total = potential[j][1] * m;
                    if(pot > total && total != 0){
                        select = j;
                        count = m;
                        pot = total;
                    }
                }

                if(pot == 10000){
                    //싼걸로 처리
                    cust = 0;
                    sum += potential[min][1];
                    break;
                }

                System.out.println("i, cust, pot : "+ i + ", " + cust + ", " + pot);
                cust -= potential[select][0] * count;
                sum += potential[select][1] * count;

            }
            answer += sum;
        }

        return answer;
    }
}