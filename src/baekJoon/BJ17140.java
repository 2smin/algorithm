package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17140 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            if(o1.getValue() < o2.getValue()){
                return -1;
            }else if(o2.getValue() < o1.getValue()){
                return 1;
            }else{
                return o1.getKey().compareTo(o2.getKey());
            }
        }
    };

    public static void main(String[] args) throws IOException {

        String[] position = bf.readLine().split(" ");
        int r = Integer.valueOf(position[0]);
        int c = Integer.valueOf(position[1]);
        int k = Integer.valueOf(position[2]);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        //2차원 배열 만들기
        for(int i=0; i<3; i++){ list.add(listMaker()); }
//        System.out.println(list);
        int yLength;
        int xLength;
        int count = 0;

        while(true){

            xLength = list.size();
            yLength = list.get(0).size();

            if(list.size() > r-1 && list.get(0).size() > c-1 && list.get(r-1).get(c-1) == k) {
                break;
            }
            if(xLength >= yLength){
                list = calR(list);
            }else{
                list = calC(list);
            }

            count++;

            if(count > 100){
                count = -1;
                break;
            }


        }

        System.out.println(count);

    }

    public static ArrayList<Integer> listMaker() throws IOException{

        ArrayList<Integer> subList = new ArrayList<>();
        String[] arr = bf.readLine().split(" ");
        for(int i=0; i<3; i++) {
            subList.add(Integer.valueOf(arr[i]));
        }

        return subList;
    }

    public static ArrayList<ArrayList<Integer>> calR(ArrayList<ArrayList<Integer>> list){

        int max = 0;
        for(int i=0; i<list.size(); i++){

            HashMap<Integer,Integer> map = new HashMap<>();

            for(int j=0; j<list.get(i).size(); j++){

                int num = list.get(i).get(j);

                if(num!= 0){

                    if(map.containsKey(num)){
                        map.put(num,map.get(num)+1);
                    }else{
                        map.put(num,1);
                    }
                }

            }

            List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(map.entrySet());
            Collections.sort(entryList,comparator);

            ArrayList<Integer> newList = new ArrayList<>();

            for(int k=0; k<entryList.size(); k++){
                if(entryList.size()> max){
                    max = entryList.size();
                }
                newList.add(entryList.get(k).getKey());
                newList.add(entryList.get(k).getValue());
            }

            //100개 넘어가면 짜른다 substring
            while(newList.size()>100){
                newList.remove(newList.size()-1);
            }

            list.set(i,newList);

        }

        for(int i=0; i<list.size(); i++){
            while(list.get(i).size() != max*2){
                list.get(i).add(0);
            }

        }

        return list;

    }

    public static ArrayList<ArrayList<Integer>> calC(ArrayList<ArrayList<Integer>> list){

        list = reverseMatrix(list);
        list = calR(list);
        list = reverseMatrix(list);

        return list;
    }

    public static ArrayList<ArrayList<Integer>> reverseMatrix(ArrayList<ArrayList<Integer>> list){
        ArrayList<ArrayList<Integer>> newList = new ArrayList<>();
        for(int i=0; i<list.get(0).size(); i++){
            ArrayList<Integer> subList = new ArrayList<>();
            for(int j=0; j<list.size(); j++){
                subList.add(list.get(j).get(i));
            }
            newList.add(subList);
        }
        return newList;
    }
}