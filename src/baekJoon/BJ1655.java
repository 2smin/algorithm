package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1655 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());

        PriorityQueue<Integer> overMedian = new PriorityQueue<>();
        PriorityQueue<Integer> underMedian = new PriorityQueue<>(Comparator.reverseOrder());

        int median = 0;

        for(int i=1; i<total+1; i++) {

            int num = Integer.valueOf(bf.readLine());

            if(i==1){
                median = num;
            }else{

                //크커나 같을때 각각의 q에 넣어준다
                //순회하는 i값이 총 원소의 갯수이므로 i를 사용하여 갯수 판별
                if(num >= median){

                    overMedian.add(num);
                    if(i%2!=0){
                        underMedian.add(median);
                        median = overMedian.remove();
                    }

                }else{

                    underMedian.add(num);
                    if(i%2==0){
                        overMedian.add(median);
                        median = underMedian.remove();
                    }
                }


            }

            System.out.println(underMedian + "--" + median + "--" + overMedian);
            sb.append(median).append("\n");

        }

        System.out.println(sb);

    }
}
