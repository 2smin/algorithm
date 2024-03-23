package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1043 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;

    static Map<Integer,Integer> unionMap = new HashMap<>();
    static List<int[]> groupList = new ArrayList<>();
    static Set<Integer> knowns = new HashSet<>();
    static int cnt = 0;
    public static void main(String[] args) throws IOException {

        String[] settings = bf.readLine().split(" ");

        N = Integer.valueOf(settings[0]);
        M = Integer.valueOf(settings[1]);

        String[] knownArr = bf.readLine().split(" ");
        for(int i=1; i<knownArr.length; i++){
            knowns.add(Integer.valueOf(knownArr[i]));
        }

        //초기화
        for(int i=1; i<N+1; i++){
            unionMap.put(i,i);
        }

        /*
        group을 하나씩 뒤져가면서 union을 시작한다

         */

        for(int i=0; i<M; i++){
            String[] groupSettings = bf.readLine().split(" ");
            int[] group = new int[Integer.valueOf(groupSettings[0])];
            for(int j=1; j<groupSettings.length; j++){
                group[j-1] = Integer.valueOf(groupSettings[j]);
            }
            groupList.add(group);
        }

        for(int i=0; i<groupList.size(); i++){
            int[] group = groupList.get(i);

            for(int j=0; j<group.length-1; j++){
                union(group[j],group[j+1]);
            }
        }

        for(int i=0; i<groupList.size(); i++){

            int[] group = groupList.get(i);
            boolean flag = false;
            for(int j=0; j<group.length; j++){
                if(knowns.contains(getParent(group[j]))){
                    flag = true;
                    continue;
                }
            }
            if(!flag) cnt++;
        }

//        System.out.println(unionMap.toString());
//        for(int[] group : groupList){
//            Arrays.stream(group).forEach(System.out::print);
//            System.out.println();
//        }
//        System.out.println();
        System.out.println(cnt);

    }

    private static int getParent(int num){
        int parent = unionMap.get(num);
        if(parent == num) return num;
        return getParent(parent);
    }

    private static void union(int a, int b){

        int aParent = getParent(a);
        int bParent = getParent(b);

        if(aParent != bParent){
            if(knowns.contains(aParent)){
                unionMap.put(bParent,aParent);
            }else if(knowns.contains(bParent)){
                unionMap.put(aParent,bParent);
            }else{
                unionMap.put(aParent,bParent);
            }
        }
    }


}
