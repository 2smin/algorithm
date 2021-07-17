package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1701 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String str = bf.readLine();

        int max = 0;
        int[] count = new int[str.length()];

        for(int k = 0; k<str.length(); k++){

            int depth = k;
            int i = k;
            if(str.length() - i < max){ break;}

            for(int j=i; j<str.length(); j++){

                if(i > 0 && str.charAt(i) != str.charAt(j)){
                    i = count[i-1];
                }

                if(str.charAt(i) == str.charAt(j)){
                    count[j] = ++i;
                }
            }

            System.out.println(Arrays.toString(count));
            for(int t = depth; t<count.length; t++){
                if(max < count[t]){
                    max = count[t] ;
                }
            }

        }
        System.out.println(max);
    }
}
