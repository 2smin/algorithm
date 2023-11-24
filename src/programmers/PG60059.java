package programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class PG60059 {


    public static void main(String[] args) {
        PG60059 pg = new PG60059();
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        pg.solution(key, lock);
    }
    static int[][] lockMap;
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
        lockMap = new int[(key.length*2)+lock.length-2][(key.length*2)+lock.length-2];
        keyMap = new int[(key.length*2)+lock.length-2][(key.length*2)+lock.length-2];
        keyMapCopy = new int[(key.length*2)+lock.length-2][(key.length*2)+lock.length-2];
        //여기에 lock을 추가, 시작 index는 key-1
        for(int i=0; i<lock.length; i++){
            for(int j=0; j<lock.length; j++){
                lockMap[lock.length-1 + i][lock.length-1 + j] = lock[i][j];
            }
        }

        for(int i=0; i<key.length; i++){
            for(int j=0; j<key.length; j++){
                keyMapCopy[i][j] = keyMap[i][j] = key[i][j];
            }
        }


        Arrays.stream(lockMap).forEach(strs -> { Arrays.stream(strs).forEach(str -> System.out.print(str + "   "));
            System.out.println();});
        System.out.println();
        Arrays.stream(keyMap).forEach(strs -> { Arrays.stream(strs).forEach(str -> System.out.print(str + "   "));
            System.out.println();});
        System.out.println();

        /*
        좌표를 하나씩 더해가면서 계산 ㄱ ㄱ
        더해가는 범위는 key + lock -1 까지
        이게 넘엉가면 y를 하나 내리고 다시 시작, y도 key + lock -1 까지
        push pop이 자유로우면서 index도 계산할 수 있는 자료구조는??

         */

        /*
        key에 대한 map도 따로 만들자 -1로 다 채우자
        그리고 key는 계속 이동을 시켜주는데, 일일히 옮기지 말고 뒤의 -1이 다 사라지면 원상복구 후 라인을 바꾸자
        이렇게 바꾼 애들로 자물쇠와 키를 더해주자
         */


        int x = 0;
        int y = 0;

        while(x != mapLength-keyLength){
            boolean isSolved = calculate();
            if(isSolved) return true;
            if(!isSolved){
                if(y < mapLength-keyLength){
                    moveY(x);
                    y++;
                }else if(y == mapLength-keyLength){
                    moveX();
                    y = 0;
                    x++;
                }
            }

            Arrays.stream(keyMapCopy).forEach(strs -> { Arrays.stream(strs).forEach(str -> System.out.print(str + "   "));
                System.out.println();});
            System.out.println("x : " + x + " , y : " + y );
        }

        return false;
    }

    public void moveY(int xStart){
        for(int x =xStart; x<keyLength; x++){
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
        keyMapCopy = keyMap;
    }

    public boolean calculate(){
        for(int i=0; i<lockLength; i++){
            for(int j=0; j<lockLength; j++){
                int count = lockMap[keyLength + i][keyLength + j] + keyMapCopy[keyLength + i][keyLength + j];
                if(count != 1) return false;
            }
        }
        return true;
    }

    /*
    key의 좌표를 무엇으로 설정할까??? lock을 기준으로 1,1을 잡을거니깐 아니면 lock 전체를 커버할수 있도록 n을 재구성한다.
    이게 나을듯
    그리고 key의 좌표를 수정해가면서 더히기 시도

     */
}
