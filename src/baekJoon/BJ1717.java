package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1717 {

    static int[] arr;
    static int total;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");

        total = Integer.valueOf(input[1]);
        arr = new int[Integer.valueOf(input[0])+1];

        for(int i=0; i<arr.length; i++){ arr[i] = i; }

        while(total-- > 0){
            String[] cals = bf.readLine().split(" ");

            if(cals[0].equals("0")){
                unionParent(Integer.valueOf(cals[1]),Integer.valueOf(cals[2]));
            }else{
                checkUnion(Integer.valueOf(cals[1]),Integer.valueOf(cals[2]));
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(sb);

    }

    //연결된 노드를 찾는다
    static int getParent(int a){

        if(arr[a] == a){ return a;}
        return arr[a] = getParent(arr[a]);
    }

    //합집합 연결을 만든다. 연결시 작은 인자로 설정
    static void unionParent(int a, int b){

        a = getParent(arr[a]);
        b = getParent(arr[b]);

        if(a<b){
            arr[b] = a;
        }else{
            arr[a] = b;
        }
    }

    static void checkUnion(int a, int b){

        a = getParent(arr[a]);
        b = getParent(arr[b]);

        if(a == b){ sb.append("YES").append("\n");}
        else{ sb.append("NO").append("\n");}
    }
}
