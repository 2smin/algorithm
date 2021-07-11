package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ1300 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.valueOf(bf.readLine());

        double k = Double.valueOf(bf.readLine());

        int lineStart = 0;
        double pivot = 0;

        for(int i=0; i<k+1; i++){
            if(i*i <= k && k <= Math.pow(i+1,2)){
                lineStart = i;
                break;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=lineStart; i<N+1; i++){
            for(int j=lineStart; j<N+1; j++){
                list.add(i*j);
            }
        }

        System.out.println(list);
//
//        System.out.println("pivot: " + pivot);
//
//        double count = Math.round((pivot - k)/2.0);
//        System.out.println(count);

//        System.out.println((int)(pivot - (line*count)));


//        System.out.println((val+1)*(remain+1));
    }

}
