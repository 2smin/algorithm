package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2447 {

    static String[][] star;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.valueOf(bf.readLine());
        star = new String[num][num];

        stars(0,0,num,false);


        StringBuilder sb = new StringBuilder();

        for(int i=0; i<star.length; i++){
            for(int j=0; j<star[i].length; j++){
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void stars(int x, int y, int num, boolean blank){

        int size = num/3;
        int count = 0;

        if(blank){
            for(int i=x; i<x+num; i++){
                for(int j=y; j<y+num; j++){
                    star[i][j] = " ";
                }
            }
            return;
        }

        if(num == 1){
            star[x][y]="*";
            return;
        }

        for(int i=x; i<x+num; i+=size){
            for(int j=y; j<y+num; j+=size){
                count++;
                if(count==5){
                    stars(i,j,size,true);
                }else{
                    stars(i,j,size,false);
                }
            }
        }
    }
}
