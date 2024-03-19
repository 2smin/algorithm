package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1182 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int S;
    static int[] numArr;
    static boolean[] checked;
    static int answer;
    public static void main(String[] args) throws IOException {

        String[] settings = bf.readLine().split(" ");
        N = Integer.valueOf(settings[0]);
        S = Integer.valueOf(settings[1]);

        String[] arr = bf.readLine().split(" ");

        numArr = Arrays.stream(arr).mapToInt(str -> Integer.valueOf(str)).toArray();
        checked = new boolean[N];
        //sum을 들고 다닌다
        //boolean 배열을 쓴다

        for(int i=0; i<N; i++){
            find(i,0);
        }
        System.out.println(answer);
    }

    public static void find(int index, int sum){

//        sum += numArr[index];
//        System.out.println("index: " + index + " / sum: " + sum);

        if(sum == S) answer++;
        //좀 쉽게 해당 index 위에만 하자
        for(int i=index+1; i<N; i++){
            checked[i] = true;
            find(i, sum);
            checked[i] = false;
        }
    }


}
