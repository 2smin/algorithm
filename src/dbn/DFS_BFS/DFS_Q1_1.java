package dbn.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class DFS_Q1_1 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[][] map;
    static boolean[][] checked;
    static Stack<int[]> stack = new Stack<int[]>();

    static int height;
    static int width;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {


        String[] size = bf.readLine().split(" ");

        height = Integer.valueOf(size[0]);
        width = Integer.valueOf(size[1]);

        map = new int[height][width];
        checked = new boolean[height][width];

        for(int i=0; i<height; i++){
            String[] arr = bf.readLine().split("");
            for(int j=0; j<arr.length; j++){
                map[i][j] = Integer.valueOf(arr[j]);
            }
        }
        int count = 0;

        for(int i=0; i<checked.length; i++) {

            for (int j = 0; j < checked[i].length; j++) {

                if(!checked[i][j] && map[i][j] == 0){
                    stack.add(new int[]{i,j});
                    count++;
                }
            }

        }

        DFS();

    }



    public static void DFS(){

        int count = 0;

        for(int i=0; i<checked.length; i++){

            for(int j=0; j<checked[i].length; j++){

                if(!checked[i][j] && map[i][j] == 0){
                    stack.add(new int[]{i,j});
                    count++;
                }
                while(!stack.isEmpty()){

                    int[] removed = stack.pop();
                    int x = removed[0];
                    int y = removed[1];

                    //이미방문한애면 다음으로 넘어가기
//                    if(checked[x][y]){ continue; }

                    checked[x][y] = true;

                    for(int k=0; k<4; k++){

                        int finX = x + dx[k];
                        int finY = y + dy[k];

                        if((0<=finX && finX<height) && (0<=finY && finY<width) && map[finX][finY] == 0 && !checked[finX][finY]){
                            stack.add(new int[]{finX,finY});
                        }

                    }

                }

            }
        }

        for(boolean[] arr : checked){
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("count: " + count);
        
    }
}
