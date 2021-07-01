package dbn.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q4 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {-1,-1,-1};
    static int[] dy = {0,1,-1};

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());

        while(total-- > 0){

            String[] mapSize = bf.readLine().split(" ");
            String[] cases = bf.readLine().split(" ");

            int height = Integer.valueOf(mapSize[0]);
            int width = Integer.valueOf(mapSize[1]);
            int[][] map = new int[height][width];
            int k=0;

            //맵 설정해주기
            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){
                    map[i][j] = Integer.valueOf(cases[k]);
                    k++;
                }
            }

            for(int[] arr : map){
                System.out.println(Arrays.toString(arr));
            }

            //옆으로 이동하면서 위아래를 체크한다
            for(int i=1; i<width; i++){
                for(int j=0; j<height; j++){

                    //바로 뒤에서 오는경우는 항상 있으므로 공통으로 설정
                    int[] flat = {j,i-1};

                    //현재 금광 위치의 금 갯수
                    int current = map[j][i];

                    //금광이 위에 붙어있거나 아래에 있는경우, 중간에 있는 경우를 나누어서 제일 큰 값을 현재위치값과 더해서 갱신한다.
                    if(0<j && j<height-1){
                        map[j][i] = Math.max(Math.max(map[flat[0]][flat[1]],map[j-1][i-1]),map[j+1][i-1]) + current;
                    }else if(j==0){
                        map[j][i] = Math.max(map[flat[0]][flat[1]],map[j+1][i-1]) + current;
                    }else if(j==height-1){
                        map[j][i] = Math.max(map[flat[0]][flat[1]],map[j-1][i-1]) + current;
                    }
                }
            }

            System.out.println();
            for(int[] arr : map){
                System.out.println(Arrays.toString(arr));
            }


        }

    }
}
