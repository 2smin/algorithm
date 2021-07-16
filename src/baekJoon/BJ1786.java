package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1786 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        String T = bf.readLine();
        String P = bf.readLine();

        int[] pattern = patternFinder(P);

        int count[] = new int[T.length()];

        //pattern 배열용 인덱스
        int i = 0;

        //T 문자열을 KMP 시행
        for (int j = 0; j < T.length(); j++) {

            //i가 패턴 길이를 벗어나거나, 비교하는 문자열이 다를 때
            if (i == pattern.length || (i > 0 && T.charAt(j) != P.charAt(i))) {
                i = pattern[i - 1];
            }

            //문자열이 같을 시
            if (T.charAt(j) == P.charAt(i)) {
                count[j] = ++i;
            }

        }

        //나온 갯수를 count 하고 위치를 StringBuilder에 저장
        int total = 0;
        for(int k=0; k<count.length; k++){
            if(count[k] == P.length()){
                total++;
                sb.append(k-P.length()+2).append(" ");
            }
        }

        System.out.println(total);
        System.out.println(sb);
    }

    //패턴 문자열을 KMP 수행.
    public static int[] patternFinder(String P) {

        int[] count = new int[P.length()];
        int i = 0;
        for (int j = 1; j < P.length(); j++) {

            if (i > 0 && P.charAt(i) != P.charAt(j)) {
                i = count[i - 1];
            }

            if (P.charAt(i) == P.charAt(j)) {
                count[j] = ++i;
            }
        }

        return count;
    }
}
