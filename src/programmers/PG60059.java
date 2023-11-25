package programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class PG60059 {


    public static void main(String[] args) {
        PG60059 pg = new PG60059();
        int[][] key = {
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 0}
        };
        int[][] lock = {
                {1, 1, 0, 0, 1},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 0 ,0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 0}
        };

        System.out.println("result : " + pg.solution(key, lock));
    }
    static int[][] lockMap;

    static int[][] originKeyMap;
    static int[][] keyMap;
    static int[][] keyMapCopy;
    static int lockLength;
    static int keyLength;
    static int mapLength;

    public boolean solution(int[][] key, int[][] lock) {


        lockLength = lock.length;
        keyLength = key.length;
        mapLength = (key.length*2)+lock.length-2;
        //모든 케이스를 커버할수 있는 map 생성
        int sum = lockLength * lockLength;
        for(int[] arr : lock){
            for(int a : arr){
                sum -= a;
            }
        }

        if(sum ==0) return true;
        lockMap = new int[(key.length*2)+lock.length-2][(key.length*2)+lock.length-2];
        keyMap = new int[(key.length*2)+lock.length-2][(key.length*2)+lock.length-2];
        originKeyMap = new int[(key.length*2)+lock.length-2][(key.length*2)+lock.length-2];
        keyMapCopy = new int[(key.length*2)+lock.length-2][(key.length*2)+lock.length-2];
        //여기에 lock을 추가, 시작 index는 key-1
        for(int i=0; i<lock.length; i++){
            for(int j=0; j<lock.length; j++){
                lockMap[keyLength-1 + i][keyLength-1 + j] = lock[i][j];
            }
        }

        for(int i=0; i<key.length; i++){
            for(int j=0; j<key.length; j++){
                keyMapCopy[i][j] = key[i][j];
                keyMap[i][j] = key[i][j];
                originKeyMap[i][j] = key[i][j];
            }
        }


        Arrays.stream(lockMap).forEach(strs -> { Arrays.stream(strs).forEach(str -> System.out.print(str + "   "));
            System.out.println();});
        System.out.println();
        Arrays.stream(keyMap).forEach(strs -> { Arrays.stream(strs).forEach(str -> System.out.print(str + "   "));
            System.out.println();});
        System.out.println();

        int rotate = 3;
        while(rotate-- >= 0){
            int x = 0;
            int y = 0;
            while(x <= mapLength-keyLength){
                Arrays.stream(keyMapCopy).forEach(strs -> { Arrays.stream(strs).forEach(str -> System.out.print(str + "   "));
                    System.out.println();});
                boolean isSolved = calculate();
                if(isSolved) return true;
                if(!isSolved){
                    if(y < mapLength-keyLength){
                        moveY(x);
                        y++;
                    }else if(y == mapLength-keyLength){
                        System.out.println("===move x====");
                        moveX();
                        y = 0;
                        x++;
                    }
                }

                System.out.println("x : " + x + " , y : " + y );
            }
            System.out.println("rotate : " + rotate);
            rotate();
        }
        return false;
    }

    public void moveY(int xStart){
        for(int x =xStart; x<keyLength + xStart; x++){
            for(int y=keyMapCopy.length-1; y >= 1; y--){
                keyMapCopy[x][y] = keyMapCopy[x][y - 1];
            }
            keyMapCopy[x][0] = 0;
        }
    }

    public void moveX(){
        for(int x = keyMap.length-1; x >= 1; x--){
            keyMap[x] = keyMap[x-1];
        }
        keyMap[0] = new int[keyMap.length];
//        System.out.println("===keymap===");
//        Arrays.stream(keyMap).forEach(strs -> { Arrays.stream(strs).forEach(str -> System.out.print(str + "   "));
//            System.out.println();});

        for(int i=0; i<keyMap.length; i++){
            keyMapCopy[i] = keyMap[i].clone();
        }
//        System.out.println("===keyCopymap===");
//        Arrays.stream(keyMapCopy).forEach(strs -> { Arrays.stream(strs).forEach(str -> System.out.print(str + "   "));
//            System.out.println();});
    }

    public boolean calculate(){
        for(int i=0; i<lockLength; i++){
            for(int j=0; j<lockLength; j++){
                int count = lockMap[keyLength + i -1][keyLength + j -1] + keyMapCopy[keyLength + i -1][keyLength + j -1];
                if(count != 1) return false;
            }
        }
        return true;
    }


    static void rotate() {

        int n = keyLength;

        // reverse up and down
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = originKeyMap[i][j];
                originKeyMap[i][j] = originKeyMap[n - i - 1][j];
                originKeyMap[n - i - 1][j] = temp;

            }
        }
        System.out.println("===up down===");
        Arrays.stream(originKeyMap).forEach(strs -> { Arrays.stream(strs).forEach(str -> System.out.print(str + "   "));
            System.out.println();});

        // reverse diagonally
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = originKeyMap[i][j];
                originKeyMap[i][j] = originKeyMap[j][i];
                originKeyMap[j][i] = temp;
            }
        }

        System.out.println("===reverse diag===");
        Arrays.stream(originKeyMap).forEach(strs -> { Arrays.stream(strs).forEach(str -> System.out.print(str + "   "));
            System.out.println();});

        for(int i=0; i<originKeyMap.length; i++){
            keyMap[i] = originKeyMap[i].clone();
            keyMapCopy[i] = originKeyMap[i].clone();
        }
//        System.out.println("===originKeyMap===");
//        Arrays.stream(originKeyMap).forEach(strs -> { Arrays.stream(strs).forEach(str -> System.out.print(str + "   "));
//            System.out.println();});
//        System.out.println("rotate");
    }
    /*
    key의 좌표를 무엇으로 설정할까??? lock을 기준으로 1,1을 잡을거니깐 아니면 lock 전체를 커버할수 있도록 n을 재구성한다.
    이게 나을듯
    그리고 key의 좌표를 수정해가면서 더히기 시도

     */
}
