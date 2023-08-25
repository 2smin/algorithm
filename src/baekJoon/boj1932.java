package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class boj1932 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int num;
    static ArrayList<int[]> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        num = Integer.valueOf(bf.readLine());

        for(int i=0; i<num; i++){
            tree.add(  Arrays.stream(bf.readLine().split(" ")).mapToInt((str -> Integer.valueOf(str))).toArray());
        }

//        for(int i=0; i<num; i++){
//            Arrays.stream(tree.get(i)).forEach(str -> System.out.print(str + " "));
//            System.out.println();
//        }

        for(int i=1; i<num; i++){
            int[] arr = tree.get(i);
            int[] top = tree.get(i-1);

            for(int j=0; j<arr.length; j++){
                int right = j > top.length-1 ? 0 : top[j];
                int left =  j > 0 ? top[j-1] : 0;
                arr[j] = Math.max(right,left) + arr[j];
            }
        }
//
//        for(int i=0; i<num; i++){
//            Arrays.stream(tree.get(i)).forEach(str -> System.out.print(str + " "));
//            System.out.println();
//        }

        System.out.println(Arrays.stream(tree.get(tree.size() - 1)).max().getAsInt());
    }
}
