package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11729 {
    static int answer = 0;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(bf.readLine());

        move(num,1,2,3);

        System.out.println(answer);
        System.out.println(sb);
    }

    public static void move(int num, int from, int by, int to){
        ++answer;
        if(num==1){
            sb.append(from + " " + to).append("\n");
        }else{
            move(num-1,from,to,by);
            sb.append(from + " " + to).append("\n");
            move(num-1,by,from,to);
        }
    }

}
