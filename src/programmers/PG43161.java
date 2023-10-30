package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PG43161 {

    public static void main(String[] args) {

        PG43161 sol = new PG43161();
        System.out.println(sol.solution("hit"	,"cog",	new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));

    }

    static ArrayList<Integer> visited = new ArrayList<>();
    static ArrayList<String> map =new ArrayList<>();
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        /*
        1. begin 자릿수 만큼 방향이 있는걸로 친다.
        2. visitedMap은 1차원 배열로 한다.
        3. 하나만 바꿨을때 word랑 동일한 string이 있는지 찾고, 있으면 해당 index의 visted 를 +1
        4. words에 target도 같이 넣어서 검사하고, target이 나오면 종료
         */

        map.add(begin);
        visited.add(0);
        for(int i=0; i<words.length; i++){
            map.add(words[i]);
            visited.add(0);
        }

        if(!map.contains(target)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        int count = 0;
        while(!queue.isEmpty()) {
            /*
            1. 꺼낸다
            2. char 위치 돌아가면서 체크
            3. vistied 확인,
            4. target인지 확인
             */
            String str = queue.poll();
            for(int i=0; i<str.length(); i++){

                String subStr = getSubString(i,str);
                int index = map.indexOf(str);

                for(int j=1; j<map.size(); j++){

                    if(visited.get(j) != 0) continue;

                    String compare = getSubString(i,map.get(j));
                    if(subStr.equals(compare)){
                        visited.set(j, visited.get(index) + 1);
                        queue.offer(map.get(j));

                    }
                }
            }

        }

//        for(int visit : visited){
//            System.out.print(visit + " ");
//        }
//        System.out.println();
//        for(String str : map){
//            System.out.print(str + " ");
//        }
//
//        System.out.println();
        return visited.get(map.indexOf(target));
    }

    public String getSubString(int pos, String str){
        String sub = null;
        if(pos==0){
            sub = str.substring(1);
        }else if(pos==str.length()-1){
            sub = str.substring(0,str.length()-1);
        }else{
            sub = str.substring(0,pos) + str.substring(pos+1);
        }
        return sub;
    }
}
