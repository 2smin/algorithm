package programmers;

import java.util.*;

public class PG42883 {

    public static void main(String[] args) {

        String number = "1234567890123456789012345678901234567890";
        int k = 7;
        StringBuilder sb = new StringBuilder(number);
        int loop = k;

        while(loop-- > 0){

            int count = 1;

            for(int i=0; i<sb.length()-1; i++){

                int word = sb.charAt(0);
                if(sb.charAt(i) == word){count++;}
                if(sb.charAt(i) < sb.charAt(i+1)){
                    sb.deleteCharAt(i);
                    break;
                }
            }

            if(count == sb.length()){break;}
        }

        int remainIndex = k - (number.length() - sb.length());
        sb.delete(sb.length()-remainIndex,sb.length());

        System.out.println(sb.length() == 0 ? "0" : sb.toString());
    }
}
