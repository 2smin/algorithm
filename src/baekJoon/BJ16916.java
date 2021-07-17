package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ16916 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String T = bf.readLine();
        String P = bf.readLine();

        int[] patternCnt = getPattern(P);

        int i = 0;
        int[] count = new int[T.length()];

            for(int j=0; j<T.length(); j++){

                if(i>=P.length() || (i > 0 && P.charAt(i) != T.charAt(j))){
                    i = patternCnt[i-1];
                }

                if(P.charAt(i) == T.charAt(j)){
                    count[j] = ++i;
                }
            }

        int max = 0;
        for(int k=0; k<count.length; k++){
            if(max < count[k]){
                max = count[k];
            }
        }

        System.out.println(Arrays.toString(patternCnt));
        System.out.println(Arrays.toString(count));

        System.out.println(max == P.length() ? 1 : 0);



    }

    static int[] getPattern(String str){

        int[] count = new int[str.length()];
        int i = 0;

        for(int j=1; j<str.length(); j++){

            if(i > 0 && str.charAt(i) != str.charAt(j)){
                i = count[i-1];
            }

            if(str.charAt(i) == str.charAt(j)){
                count[j] = ++i;
            }
        }
        return count;
    }

}
