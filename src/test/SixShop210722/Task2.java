package test.SixShop210722;

import java.util.*;

public class Task2 {

    public static void main(String[] args) {

        int[] grade = {3,2,1,2,3,4,5};

        //학생번호랑 점수를 같이 저장
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> fin = new HashMap<>();
        for(int i=0; i<grade.length; i++){
            map.put(i,grade[i]);
            fin.put(i,0);
        }

        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());

        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() > o2.getValue() ? -1 : 1;
            }
        });

        int count = 0;

        for(int i=0; i<entryList.size(); i++){
            count++;
            if(i==0){
                fin.put(entryList.get(i).getValue(),count);
            }else {
                if (entryList.get(i).getValue().equals(entryList.get(i - 1))) { //이전값이랑 같을때
                    fin.put(i, fin.get(i-1)); //이전값 그대로 넣기
                }else{ //값 다르면
                    fin.put(i, count);
                }
            }
        }

        System.out.println(entryList);
        System.out.println(fin);


    }
}


