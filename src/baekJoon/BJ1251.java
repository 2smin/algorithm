package baekJoon;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1251 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        Set<String> set = new TreeSet<>();
        //input을 총 세부분으로 자르는 로직
        int len = input.length();

        for(int i=1; i<len-1; i++){
            for(int j=i+1; j<len; j++){
                String sb1 = new StringBuilder(input.substring(0, i)).reverse().toString();
                String sb2 = new StringBuilder(input.substring(i,j)).reverse().toString();
                String sb3 = new StringBuilder(input.substring(j,len)).reverse().toString();
                set.add(sb1+sb2+sb3);
            }
        }
        if (!set.isEmpty()) {
            String firstWord = set.iterator().next();
            System.out.println(firstWord);
        }

    }
}
