package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj5107 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static Map<String,String> manitoMap = new LinkedHashMap<>();
    static Map<String,Boolean> globalVisited = new HashMap<>();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        int ansNum = 1;
        int num = Integer.valueOf(bf.readLine());
        while(num != 0){

            int numCnt = num;
            while(numCnt-- != 0){
                String[] names = bf.readLine().split(" ");
                manitoMap.put(names[0],names[1]);

                globalVisited.put(names[0], false);
                globalVisited.put(names[1],false);
            }

            Set<Map.Entry<String,String>> ents = manitoMap.entrySet();


            Iterator<Map.Entry<String,String>> it = ents.iterator();
            while(it.hasNext()){
                Map.Entry<String,String> ent =  it.next();
                String from = ent.getKey();
                String to = ent.getValue();
                loop(from,to,from);
            }

            System.out.println(ansNum + " " + cnt);
            ansNum++;
            num = Integer.valueOf(bf.readLine());

            manitoMap.clear();
            globalVisited.clear();
            cnt = 0;
        }
    }

    public static void loop(String from, String to, String origin){
        if(!globalVisited.containsKey(to) || globalVisited.get(to) == true){
//            System.out.println("loop cannot be structed");
            return;
        }
//        System.out.println("from : " + from + " , to : " + to);
        globalVisited.put(from,true);

        String nextTo = manitoMap.get(to);
        if(origin.equals(nextTo)){
//            System.out.println("origin == nextTo : " + origin);
            cnt++;
            return;
        }else{
//            System.out.println("next : " + nextTo);
        }
        loop(to,nextTo,origin);
    }

}

class MNode {
    String from;
    String to;
}
