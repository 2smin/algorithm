package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1080 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int row;
    static int column;
    static int[][] matrixA;
    static int[][] matrixB;
    static int count;

    private static int[][] createMatrix() throws IOException{
        int[][] matrix = new int[row][column];
        for(int i=0; i<row; i++){

            String[] members = bf.readLine().split("");
            for(int j=0; j<column; j++){
                matrix[i][j] = Integer.valueOf(members[j]);
            }
        }
        return matrix;
    }

    public static void main(String[] args) throws IOException {

        String[] settings = bf.readLine().split(" ");

        row = Integer.valueOf(settings[0]);
        column = Integer.valueOf(settings[1]);

        matrixA = createMatrix();
        matrixB = createMatrix();

//        if(row < 3 || column < 3) {
//            System.out.println(-1);
//            return;
//        }

        for(int i=0; i<row-2; i++){
            for(int j=0; j<column-2; j++){
                if(matrixA[i][j] != matrixB[i][j]){
                    convert(i,j);
                }
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                if(matrixA[i][j] != matrixB[i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(count);
    }

    private static void convert(int row, int column){

        for(int i = row; i<row+3; i++){
            for(int j= column; j<column+3; j++){
               if(matrixA[i][j] == 1){
                   matrixA[i][j] = 0;
               }else{
                   matrixA[i][j] = 1;
               }
            }
        }

        count++;
    }

}
