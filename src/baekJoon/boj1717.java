package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1717 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int[] parentInfo;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {


        String[] settings = bf.readLine().split(" ");
        N = Integer.valueOf(settings[0]);
        M = Integer.valueOf(settings[1]);
        parentInfo = new int[N+1];

        for(int i=0; i<parentInfo.length+1; i++){
            parentInfo[i] = i;
        }
//        for(int k=0; k<parentInfo.length; k++){
//            System.out.print("[" + k +  ": " + parentInfo[k] +"]");
//        }
//        System.out.println();

        for(int i=0; i<M; i++){
            int[] cal = Arrays.stream(bf.readLine().split(" ")).mapToInt(str -> Integer.valueOf(str)).toArray();

            if(cal[0] == 0){
                union(cal[1],cal[2]);
//                for(int k=0; k<parentInfo.length; k++){
//                    System.out.print("[" + k +  ": " + parentInfo[k] +"]");
//                }
//                System.out.println();
            }else{
                isUnion(cal[1],cal[2]);
            }
        }

        System.out.println(sb);
    }

    private static void union(int a, int b){
        /*
        root 까지 찾아간후 index랑 값이 일치하면 얘를 a로 바꿔준다.
         */

        int aParent = findParent(a);
        int bParent = findParent(b);

        //작은애가 부모가 된다.
        if(aParent > bParent){
            parentInfo[aParent] = bParent;
        }else{
            parentInfo[bParent] = aParent;
        }

    }

    private static int findParent(int num){

        if(parentInfo[num] == num) return num;
        return findParent(parentInfo[num]); //최상위 root로 싹 다 갈기
    }

    private static void isUnion(int a, int b){
        int aParent = findParent(a);
        int bParent = findParent(b);
        if(aParent == bParent){
            sb.append("YES").append("\n");
        }else{
            sb.append("NO").append("\n");
        }

    }

}
