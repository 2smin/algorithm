package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1004 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int total = Integer.valueOf(bf.readLine());

        while(total-- > 0){
            String[] arr = bf.readLine().split(" ");

            int[] from = {Integer.valueOf(arr[0]),Integer.valueOf(arr[1])};
            int[] to = {Integer.valueOf(arr[2]),Integer.valueOf(arr[3])};

            int planetNum = Integer.valueOf(bf.readLine());
            int[][] positions = planetPositions(planetNum);

//            for(int i=0; i<positions.length; i++){
//                System.out.println(Arrays.toString(positions[i]));
//            }


            int count = CircleInCheck(positions, from, to);
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    public static int[][] planetPositions(int planetNum) throws IOException{

        int[][] positions = new int[planetNum][3];

        for(int i=0; i<planetNum; i++){

            int[] position = new int[3];
            String[] arr = bf.readLine().split(" ");

            for(int j=0; j<position.length; j++){
                position[j] = Integer.valueOf(arr[j]);
            }

            positions[i] = position;
        }

        return positions;
    }

    public static int CircleInCheck(int[][] positions, int[] from, int[] to){

        int count = 0;

        for(int i=0; i< positions.length; i++){

            int checkFrom = Math.pow(from[0]-positions[i][0],2) + Math.pow(from[1]-positions[i][1],2) < Math.pow(positions[i][2],2) ? -1 : 1;
            int checkTo = Math.pow(to[0]-positions[i][0],2) + Math.pow(to[1]-positions[i][1],2) < Math.pow(positions[i][2],2)  ? -1 : 1;

            if(checkFrom*checkTo < 0){ count++; }
        }

        return count;
    }
}
