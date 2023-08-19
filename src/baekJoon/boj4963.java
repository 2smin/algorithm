package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class boj4963 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int height;
    static int width;
    static int count;

    static int dx[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int dy[] = { 0, 1, 1, 1, 0, -1, -1, -1 };

    static int[][] map;
    public static void main(String[] args) throws IOException {

        String set = "";
        while(true){
            set = bf.readLine();
            if(set.equals("0 0")) break;
            String[] settings = set.split(" ");
            width = Integer.valueOf(settings[0]);
            height = Integer.valueOf(settings[1]);
            map = new int[height][width];
            count = 0;

            for(int i=0; i<height; i++){
                int[] rows = Arrays.stream(bf.readLine().split(" "))
                        .mapToInt(str -> Integer.valueOf(str)).toArray();
                map[i] = rows;
            }
            for(int hei=0; hei<height; hei++){
                for(int wid=0; wid<width; wid++){
                    if(map[hei][wid] == 1){
                        dfs(wid,hei);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

    }

    public static void dfs(int wid, int hei){
//        System.out.println("dsf on : " + hei + ", " + wid);
        map[hei][wid] = 0;

        for(int d=0; d<8; d++){
            int xx = wid + dx[d];
            int yy = hei + dy[d];

            if(xx>width-1 || yy>height-1 || xx<0 || yy<0) continue;
            if(map[yy][xx] == 0) continue;

            dfs(xx,yy);
        }
    }

}
