package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class BJ1431 {

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
                if(o1.length() > o2.length()){
                    return 1;
                }else if(o1.length() < o2.length()){
                    return -1;
                }else {
                    int compareSum = sumOfNum(o1) - sumOfNum(o2);

                    if (compareSum == 0) { return o1.compareTo(o2); }

                    return compareSum;
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

    public static int sumOfNum(String word){
        int num = 0;
        for(int i=0; i<word.length(); i++){

            char str = word.charAt(i);

            if(str >= 48 && str <= 57){
                num += str - 48;
            }
        }

        return num;
    }
}
