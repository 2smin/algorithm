package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class boj9251 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static String str1;
    static String str2;
    static int[][] dpTable;

    public static void main(String[] args) throws IOException {

        str1 = bf.readLine();
        str2 = bf.readLine();

        dpTable = new int[str1.length()][str2.length()];

        for(int i=0; i<str1.length(); i++){
            if(str1.substring(0,i+1).contains(String.valueOf(str2.charAt(0)))){
                dpTable[i][0] = 1;
            }
        }
        for(int i=0; i<str2.length(); i++){
            if(str2.substring(0,i+1).contains(String.valueOf(str1.charAt(0)))){
                dpTable[0][i] = 1;
            }
        }


        for(int i=1; i<str1.length(); i++){
            for(int j=1; j<str2.length(); j++){
                String st1 = String.valueOf(str1.charAt(i));
                String st2 = String.valueOf(str2.charAt(j));
//                System.out.println("i,j =" + i + "," +j);
//                System.out.println("st = " + st1 + ", " + st2);

                if(st1.equals(st2)){
//                    System.out.println("equal... before : " + dpTable[i-1][j-1]);
                    dpTable[i][j] = dpTable[i-1][j-1] + 1;
//                    System.out.println("dp : " + dpTable[i][j] );
                }else{
                    dpTable[i][j] = Math.max(dpTable[i-1][j],dpTable[i][j-1]);
                }
//                System.out.println();
            }
        }

//        Arrays.stream(dpTable).forEach(ints -> {
//            Arrays.stream(ints).forEach(arr -> System.out.print(arr));
//            System.out.println();
//        });

//
        System.out.println(dpTable[str1.length()-1][str2.length()-1]);

    }

}
