package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class boj15686 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int chickenNum;

    static int[][] chickenDistanceMap;
    static ArrayList<int[]> houses = new ArrayList<>();
    static ArrayList<int[]> chickens = new ArrayList<>();
    static boolean[] checked;
    static int K;
    static int globalMin = 50 * 50;
    public static void main(String[] args) throws IOException {

        String[] settings = bf.readLine().split(" ");
        N = Integer.valueOf(settings[0]);
        M = Integer.valueOf(settings[1]);


        for(int i=0; i<N; i++){
            int[] rows = Arrays.stream(bf.readLine().split(" ")).mapToInt((str -> Integer.valueOf(str))).toArray();
            for(int j=0; j<N; j++){

                if(rows[j] == 1) houses.add(new int[]{i,j});
                if(rows[j] == 2){
                    chickens.add(new int[]{i,j});
                    chickenNum++;
                }
            }
        }

        K = chickenNum-M;

        chickenDistanceMap = new int[houses.size()][chickens.size()];
        for(int i=0; i<houses.size(); i++){
            int[] house = houses.get(i);
            for(int j=0; j<chickens.size(); j++){
                int[] chicken = chickens.get(j);

                int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                chickenDistanceMap[i][j] = distance;
            }
        }

//        for(int[] dist : chickenDistanceMap){
//            for(int dis : dist){
//                System.out.printf(dis + " ");
//            }
//            System.out.println();
//        }
        //거리 미리 계산해놓기


        /*
        1. M개만 남겼을 떄 , 치킨집에서 M개 뺀 애들을 K라고 한다
        K 개 선택하는 조합을 만든다
        각 조합마다 좌표가 있을거고, 해당 좌표에 대해 각 치킨집마다 미리 거리를 구해놓는다
        해당 좌표집이 사라질때 각 집마다 치킨거리 최소값을 더한다
        모든 집에 대해서 완료되면 최소값을 다 더한다
        */

        checked = new boolean[chickenNum];
        //조합 만들기
        check(checked,0,K);
        System.out.println(globalMin);

    }

    //chiken집 index를 찾아야 한다. K개 고르기
    private static void check(boolean[] checked, int start, int r){
        if(r == 0){
            getDistance(checked);
            return;
        }

        for(int i=start; i<chickenNum; i++){
            checked[i] = true;
            check(checked, i+1, r-1);
            checked[i] = false;
        }
    }

    private static void getDistance(boolean[] checked){
        int[][] localChickenMap = new int[chickenDistanceMap.length][chickenDistanceMap[0].length];
        for(int i=0; i<chickenDistanceMap.length; i++){
            int[] chickens = chickenDistanceMap[i].clone();
            localChickenMap[i] = chickens;
        }
        for(int i=0; i<checked.length; i++){
            if(checked[i] == true){
                for(int j=0; j<localChickenMap.length; j++){
                    localChickenMap[j][i] = 0;
                }
            }
        }

        int localMin = 0;
        for(int i=0; i<localChickenMap.length; i++){
            int houseMin = 50;
            for(int j=0; j<localChickenMap[0].length; j++){
                if(localChickenMap[i][j] == 0) continue;
                houseMin = Math.min(houseMin,localChickenMap[i][j]);
            }
//            System.out.println("houseMin :" + houseMin);
            localMin+= houseMin;
        }
//        System.out.println("localMin :" + localMin);
        globalMin = Math.min(globalMin,localMin);
    }



}
