package test.SixShop210722;

import java.util.Arrays;
import java.util.Comparator;

public class Task1 {

    public static void main(String[] args) {

        System.out.println(solution("xyZA","ABCxy"));

    }

    public static String solution(String s1, String s2) {
        String arr[] = new String[2];

        arr[0] = getReverseConnect(s1,s2);
        arr[1] = getReverseConnect(s2,s1);
        String contains = "";

        if(s1.contains(s2)){
            contains =  s1;
        }else if(s1.contains(s2)){
            contains =  s2;
        }

        if(contains!=""){
            return contains;
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()){
                    return 1;
                }else if(o1.length() < o2.length()){
                    return -1;
                }else{
                    return o1.compareTo(o2);
                }
            }
        });

        System.out.println(Arrays.toString(arr));
        return arr[0];

    }

    public static String getReverseConnect(String s1, String s2){

        int s1Len = s1.length();
        int s2Len = s2.length();

        int min = Math.min(s1Len,s2Len);

        for(int i=0; i<s1.length(); i++){

            String spliced = s1.substring(i);

            if(spliced.length()>= s2.length()){

                if(s1.contains(s2)){
                    return s1;
                }
            }else{

            }
        }

    }

}


