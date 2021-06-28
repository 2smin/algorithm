package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BJ1931 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());

        ArrayList<Integer[]> list = new ArrayList<>();

        while (total-- > 0) {
            String[] arr = bf.readLine().split(" ");

            list.add(new Integer[]{Integer.valueOf(arr[0]), Integer.valueOf(arr[1])});
        }

        list.sort(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {

                if(o1[1] > o2[1]){
                    return 1;
                }else if(o1[1] < o2[1]){
                    return -1;
                }else{
                    return o1[0] > o2[0] ? 1 : -1;
                }
            }
        });

        int end = 0;
        int start = 0;
        int count = 0;

        for(int i=0; i<list.size(); i++){

            start = list.get(i)[0];

            if(start < end){
                continue;
            }else{
                end = list.get(i)[1];
                count++;
            }
        }

        System.out.println(count);

    }

}
