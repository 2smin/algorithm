package programmers;

import java.util.*;

public class PG60061 {
    public static void main(String[] args) {
        PG60061 pg = new PG60061();

        int n =5
                ;
        int[][] build_frame =
                {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}}
                ;
        int[][] answer = pg.solution(n,build_frame);
        System.out.println();
        Arrays.stream(answer).forEach(ints -> { Arrays.stream(ints).forEach(num -> System.out.printf(String.format("%-7s", num)));
            System.out.println();});

    }


    static int[][][] map;
    static List<int[]> answerList = new ArrayList<>();

    public int[][] solution(int n, int[][] build_frame) {

        map = new int[n+1][n+1][2];

        for(int i=0; i<build_frame.length; i++){
            int[] setting = build_frame[i];

            int x = setting[0];
            int y = setting[1];
            int build = setting[2]; //0 기둥 1 보
            int command = setting[3]; //0 삭제 1 설치
            doCommand(x,y,build,command);
        }

//        Arrays.stream(map).forEach(ints -> { Arrays.stream(ints).forEach(num -> System.out.printf(String.format("%-7s", num)));
//            System.out.println();});

        getPosition();

        int[][] answer = new int[answerList.size()][3];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public void doCommand(int x, int y, int build, int command){

        //삭제의 경우
        if(command == 0){
            if(build == 0){
                map[x][y][0] = 0;
                if(!checkDeleteCondition()){
                    map[x][y][0] = 1;
                }
            }
            if(build == 1){
                map[x][y][1] = 0;
                if(!checkDeleteCondition()){
                    map[x][y][1] = 1;
                }
            }

        }else if (command == 1){ //생성의 경우
            //일단 만들고 조건 체크
            if(build == 0) { //기둥은 1로 변경
                map[x][y][0] = 1;
                if(!checkInsertCondition(build,x,y)){
                    map[x][y][0] = 0;
                }
            }
            if(build == 1){ //보는 2로 변경
                map[x][y][1] = 1;
                if(!checkInsertCondition(build,x,y)){
                    map[x][y][1] = 0;
                }
            }
        }
    }

    public boolean checkDeleteCondition(){
        for(int i=0; i< map.length; i++){
            for(int j=0; j < map.length; j++){
                if(map[i][j][0] == 1){
                    if(!checkInsertCondition(0,i,j)){
                        return false;
                    }
                }
                if(map[i][j][1] == 1){
                    if(!checkInsertCondition(1,i,j)){
                        return false;
                    }
                }
            }
        }
        return true;
//        if(build == 0){ //기둥 삭제
//            //왼쪽 보 체크
//            if(x > 0 && y < map.length-1 && map[x-1][y+1] >= 2){
//                if(checkInsertCondition(0,x-1,y+1)){
//                    return true;
//                }
//                return false;
//            }
//
//            //오른쪽 보 체크
//            if(y < map.length-1 && map[x][y+1] >= 2){
//                if(checkInsertCondition(0,x,y+1)){
//                    return true;
//                }
//                return false;
//            }
//
//            //위쪽 기둥 체크
//            if(y < map.length-1 && map[x][y+1] == 1){
//                if(checkInsertCondition(1,x,y+1)){
//                    return true;
//                }
//                return false;
//            }
//        }else{ //보 삭제
//            //우측 보 확인
//            if(y < map.length-1 && map[x][y+1] >= 2){
//                if(checkInsertCondition(1,x,y+1)){
//                    return true;
//                }
//                return false;
//            }
//
//            //왼쪽 보 확인
//            if(y > 0 && map[x][y-1] >= 2){
//                if(checkInsertCondition(1,x,y+1)){
//                    return true;
//                }
//                return false;
//            }
//
//            //왼쪾 위 기둥 확인
//            if(map[x][y] == 3){
//                if(checkInsertCondition(0,x,y)){
//                    return true;
//                }
//                return false;
//            }
//
//            //오른쪽 위 기둥 확인
//            if( x < map.length-1 && map[x+1][y] == 1 || map[x+1][y] == 3){
//                if(checkInsertCondition(0,x+1,y)){
//                    return true;
//                }
//                return false;
//            }
//
//        }
//        return  false;
    }

    public boolean checkInsertCondition(int build, int x , int y){
        if(build == 0){ //기둥 생성 조건
            //바닥에 있는지 체크
            if(y == 0) return true;
            //왼쪽보 위에 있는지 체크
            if(x-1 >= 0 && map[x-1][y][1] == 1) return true;
            //오른쪽 보 위에 있는지 체크
            if(map[x][y][1] == 1) return true;
            //기둥 위에 있는지 체크
            if(y-1 >= 0 && map[x][y-1][0] == 1) return true;
        }else{ //보 생성 조건
            //한쪽 끝이 기둥에 있거나, 양쪽이 다른 보랑 닿아있거나

            //왼쪽끝 기둥 있는지 체크
            if(y-1 >= 0 && (map[x][y-1][0] == 1)) return true;
            //오른쪽 끝 기둥 있는지 체크
            if((x < map.length-1 && y > 0 ) && map[x+1][y-1][0] == 1) return true;
            //양쪽 보 체크
            if((x+1 >= 0  && x-1 >= 0)&& map[x-1][y][1] == 1 && map[x+1][y][1] == 1) return true;
        }

        return false;
    }

    public void getPosition(){
        for(int x=0; x<map.length; x++){
            for(int y=0; y< map.length; y++){
                if(map[x][y][0] == 1){
                    answerList.add(new int[]{x,y,0});
                }
                if(map[x][y][1] == 1){
                    answerList.add(new int[]{x,y,1});
                }
            }
        }
    }

}
