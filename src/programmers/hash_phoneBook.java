package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class hash_phoneBook {

    public static void main(String[] args){


        String[] arr = new String[]{"12","123","343","5343","3437"};
        boolean answer = true;

        TreeMap<String,Character> map = new TreeMap<>();

        for(int i = 0; i<arr.length; i++){

            map.put(arr[i],arr[i].charAt(0));
        }

        System.out.println(map.values());



    }

}
