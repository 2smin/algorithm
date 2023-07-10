package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BJ1235 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(bf.readLine());

        List<String> list = new ArrayList<>();

        int len = 0;
        while(--num >=0){
            String str = bf.readLine().toString();
            len = str.length();
            list.add(str);
        }

        Set<String> checkDup = new HashSet<>();

        for(int i=len-1; i>=0; i--){
            for(String str : list){
                checkDup.add(str.substring(i));
            }
            if(checkDup.size() == list.size()){
                System.out.println(len-i);
                break;
            }else{
                checkDup.clear();
            }
        }

    }
}
