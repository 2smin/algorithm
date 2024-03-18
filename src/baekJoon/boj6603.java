package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj6603 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int k;
    public static void main(String[] args) throws IOException {

        String str = "";
        while(true){

            str = bf.readLine();
            if(str.equals("0")) return;
            k = Integer.valueOf(str.split(" ")[0]);
            source = new int[k];
            checked = new boolean[k];
            String[] strOri = str.split(" ");
            for(int i=1; i<k+1; i++){
                source[i-1] = Integer.valueOf(strOri[i]);
//                System.out.printf(source[i-1] + " ");
            }
//            System.out.println("========");
            find(0, 0);
            System.out.println();
        }

    }

    static int[] source;
    static boolean[] checked;

    /*
    dp 테이블을 둘까? 이걸 가지고 계속 이동한다
    table을 가지고 copy해가면서 계속 내려간다 그러다가 k개 선택이 완료되면 print
     */
    private static void find(int from, int start){
        if(from==6){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<k; i++){
                if(checked[i]){
                    sb.append(source[i]).append(" ");
                }
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }else{
            for(int i=start; i<k; i++){
                checked[i] = true;
                find(from+1,i+1);
                checked[i] = false;
            }
        }
    }


}
