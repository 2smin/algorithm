package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class boj5107 {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static Map<String,String> manitoMap = new HashMap<>();
    static Map<String,Boolean> checked = new HashMap<>();
    public static void main(String[] args) throws IOException {

        int num = Integer.valueOf(bf.readLine());

        while(num-- != 0){
            String[] names = bf.readLine().split(" ");
            manitoMap.put(names[0],names[1]);
            checked.put(names[0], false);
            checked.put(names[1],false);
        }

        Set<Map.Entry<String,String>> manitos = manitoMap.entrySet();

        //여기서 하나씩 뺴면서 돌린다
        for(Map.Entry<String,String> manito : manitos){

        }
    }

}
