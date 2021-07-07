package test.NaverWebtoon210704;

import java.util.ArrayList;
import java.util.Arrays;

public class Task2_2 {

    public static void main(String[] args) {

        solution("abcxyqwertyxyabc");

    }

    public static void solution(String s) {

        ArrayList<String> list = new ArrayList<>();

        //앞 시작
        int startFront = 0;
        int i = s.length()-1;
        //뒤 종료
        int endBehind = s.length();



        while(i>=s.length()/2){

            char find = s.charAt(i);

            System.out.println("find: " + find);

            //뒤에서부터 찾기
            for(int j=0; j<s.length()-1; j++){

                //찾았다면
                if(s.charAt(j) == find){

                    int strLength = (j+1) - startFront;

                    System.out.println("length : " + strLength);
                    System.out.println("front: " +s.substring(startFront,j+1));
                    System.out.println("end: " +s.substring(i-strLength+1,i+1));

                    if(s.substring(startFront,j+1).equals(s.substring(i-strLength+1,i+1))){

                        //리스트에 넣기
                        list.add(s.substring(startFront,j+1));

                        startFront = j+1; // 앞 시작 갱신
                        System.out.println("startFront: " + startFront);
                        i = i-strLength;

                        System.out.println("i: " + i);
                        endBehind = i;

//                        System.out.println("endBehind: " +endBehind);
                    }
                }
            }

            System.out.println(list);

        }

        System.out.println(list);

    }
}
