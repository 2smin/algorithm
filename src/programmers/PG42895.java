package programmers;

import java.util.*;

public class PG42895 {

    public static void main(String[] args) {
        PG42895 sol = new PG42895();
        System.out.println(sol.solution(6,5));
    }

    static ArrayList<Set<Integer>> dp = new ArrayList<>();

    public int solution(int N, int number) {

        String tmp = "";

        for(int i=0; i<=8; i++){
            dp.add(new HashSet<Integer>());
            if(i>0){
                tmp += N;
                dp.get(i).add(Integer.valueOf(tmp));
            }
        }
        for(int i=2; i<=8; i++){

            //사칙연산 수행
            //조합부터 찾는다
            Set<Integer> newNode = new HashSet<>();
            for(int j=1; j<i; j++){
                int right = j;
                int left = i-j;

                for(int m : dp.get(right)){
                    for(int n : dp.get(left)){
                        dp.get(i).add(m+n);
                        dp.get(i).add(m-n);
                        dp.get(i).add(m*n);
                        if(n!=0)dp.get(i).add(m/n);
                    }
                }
            }
        }

        for(int i=0; i<dp.size(); i++){
            Set<Integer> sets = dp.get(i);
            if(sets.contains(number)){
                return i;
            }
        }

        return -1;
    }
}
