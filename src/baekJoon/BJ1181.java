package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class BJ1181 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.valueOf(bf.readLine());

        ArrayList<String> arr = new ArrayList<>();

        while(total-- > 0){
            arr.add(bf.readLine());
        }

        arr.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length()){
                    return 1;
                }else if(o1.length() < o2.length()){
                    return -1;
                }else{
                    return o1.compareTo(o2);
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.size(); i++){

            if(i != arr.size()-1 && arr.get(i).equals(arr.get(i+1))){
                    continue;
            }
            sb.append(arr.get(i)).append("\n");

        }

        System.out.println(sb);
    }

}


