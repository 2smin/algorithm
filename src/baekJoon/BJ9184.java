package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BJ9184 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static TreeMap<String,Integer> map = new TreeMap<String,Integer>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        while(true){

            String[] arr = bf.readLine().split(" ");

            int a = Integer.valueOf(arr[0]);
            int b = Integer.valueOf(arr[1]);
            int c = Integer.valueOf(arr[2]);

            if(a == -1 && b == -1 && c== -1) break;

            int num = doCalculate(a,b,c);
            sb.append("w(" + a + ", " + b + ", " + c + ") = " + num).append("\n");
        }

        System.out.println(sb);

    }

    static int doCalculate(int a, int b, int c){

        String str = a+"_"+b+"_"+c;

        if(!map.containsKey(str)){
            if(a <= 0 || b <= 0 || c <= 0){
                map.put(str,1);
            }else if(a > 20 || b > 20 || c > 20){
                map.put(str,doCalculate(20,20,20));
            }else if(a < b && b <c){
                map.put(str,doCalculate(a,b,c-1) + doCalculate(a,b-1,c-1) - doCalculate(a,b-1,c));
            }else{
                map.put(str,
                        doCalculate(a-1,b,c) +
                        doCalculate(a-1,b-1,c) +
                        doCalculate(a-1,b,c-1) -
                        doCalculate(a-1,b-1,c-1)
                );
            }
        }
        return map.get(str);

    }


}
