package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ1300_2 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.valueOf(bf.readLine());

        double k = Double.valueOf(bf.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                list.add(i*j);
            }
        }

        Collections.sort(list);

        System.out.println(list);

    }

}
