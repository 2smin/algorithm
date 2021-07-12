package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1038_2 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int count = -1;
    static int N;
    static String str = "";

    public static void main(String[] args) throws IOException {

        N = Integer.valueOf(bf.readLine());
        String answer = "";

        if(N<=1022){

loop1:      for(int i=1; i<=10; i++){
                for(int j=i-1; j<=9; j++){
                    dfs(i, j);
                    if(count==N){
                        str += j+"";
                        break loop1;
                    }
                }
            }

            //String 뒤집어서 출력
            for(int i=str.length()-1; i>=0; i--){ answer+=str.charAt(i); }
        }else{
            //찾는 값 없을 때
            answer = "-1";
        }

        System.out.println(answer);

    }

    static boolean dfs(int position, int num){

        //1의자리 도달 시 count 증가
        if(position==1){ count++; }

        //원하는 값을 찾았을 시 종료
        if(count == N){ return true; }

        if(position>1){
            for(int i=position-2; i<num; i++){

                //다음번 자리 재귀호출
                if(dfs(position-1, i)){
                    str += i+"";
                    return true;
                }
            }
        }

        return false;
    }
}
