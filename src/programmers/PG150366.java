package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PG150366 {

    public static void main(String[] args) {


        PG150366 sol = new PG150366();
        String[] commands = {"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"};
        String[] answer = sol.solution(commands);
        for(String ans : answer){
            System.out.printf(ans + ", ");
        }
    }

    String[] map = new String[2500];
    int[] union = new int[2500];

    public String[] solution(String[] commands) {

        ArrayList<String> answerList = new ArrayList<>();
        int answerCount = 0;
        for(int i=0; i<union.length; i++){
            union[i] = i;
        }
        for(String command : commands){

            if(command.contains("UPDATE ")){
                String[] cal = command.split(" ");
                if(cal.length==4){
                    int r = Integer.valueOf(cal[1]);
                    int c = Integer.valueOf(cal[2]);
                    String value = cal[3];
                    update(index(r,c),value);
                }else if(cal.length==3){
                    update(cal[1],cal[2]);
                }
            }else if(command.contains("UNMERGE")){
                String[] cal = command.split(" ");
                int r = Integer.valueOf(cal[1]);
                int c = Integer.valueOf(cal[2]);
                unmerge(index(r,c));
                parentSync();
            }else if(command.contains("MERGE")){
                String[] cal = command.split(" ");
                int r1 = Integer.valueOf(cal[1]);
                int c1 = Integer.valueOf(cal[2]);
                int r2 = Integer.valueOf(cal[3]);
                int c2 = Integer.valueOf(cal[4]);
                merge(index(r1,c1),index(r2,c2));
                parentSync();
            }else{
                String[] cal = command.split(" ");
                int r = Integer.valueOf(cal[1]);
                int c = Integer.valueOf(cal[2]);
                answerList.add(print(index(r,c)));
                answerCount++;
            }
        }
        String[] answer = new String[answerCount];
        answer = answerList.toArray(answer);
        return answer;
    }

    private void update(int index, String value){
        int finalIndex = getParent(index);
        map[finalIndex] = value;
    }

    private void update(String preValue, String postValue){
        for(int i=0; i<map.length; i++){
            if(preValue.equals(map[i])){
                update(i,postValue);
            }
        }
    }

    private void merge(int index1, int index2){

         index1 = getParent(index1);
         index2 = getParent(index2);
         if(index1==index2) return;

         String selectedValue = map[index1] == null ? map[index2] : map[index1];
         map[index1] = null;
         map[index2] = null;
         union[index2] = index1;
         map[index1] = selectedValue;

    }

    private int getParent(int index){
        if(union[index]==index){
            return index;
        }
        return union[index] = getParent(union[index]);
    }

    private void parentSync(){
        for(int i=0; i<union.length; i++){
            getParent(i);
        }
    }

    private void unmerge(int index){
        int root = getParent(index);
        String value = map[root];
        map[root] = "";
        for(int i=0; i<union.length; i++){
            if(getParent(i) == root){
                union[i] = i;
                map[i] = null;
            }
        }
        map[index] = value;
    }

    private String print(int index){
        int finalIndex = getParent(index);
        return map[finalIndex] == null ? "EMPTY" : map[finalIndex];
    }


    private int index(int r, int c){
        return ((r-1)*50) + (c-1);
    }

}

