package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj12904 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static String S;
    static String T;

    public static void main(String[] args) throws IOException {

        S = bf.readLine();
        T = bf.readLine();

        boolean result = false;
        check();
    }

    private static void check(){

        if(T.charAt(T.length()-1) == 'A'){
            T = T.substring(0,T.length()-1);
        }else if(T.charAt(T.length()-1) == 'B'){
            T = T.substring(0,T.length()-1);
            T = new StringBuilder().append((CharSequence) T).reverse().toString();
        }

        if(T.equals(S)){
            System.out.println(1);
        }else if (T.length() > S.length()){
            check();
        }else {
            System.out.println(0);
        }
    }


}
