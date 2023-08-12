package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class boj9237 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int treeNum;
    static Integer[] treeArr;
    public static void main(String[] args) throws IOException {

        treeNum = Integer.valueOf(bf.readLine());
        treeArr = new Integer[treeNum];

        String[] trees = String.valueOf(bf.readLine()).split(" ");

        for(int i=0; i<treeArr.length; i++){
            treeArr[i] = Integer.valueOf(trees[i]);
        }

        Arrays.sort(treeArr, Collections.reverseOrder());

        int days = 0;
        int expire = 0;

        for(int i=0; i<treeArr.length; i++){

            days++;
            int currentTree = treeArr[i];

            int currentEx = days + currentTree;

            if(expire < currentEx){
                expire = currentEx;
            }

        }

        System.out.println(expire + 1);



    }
}
