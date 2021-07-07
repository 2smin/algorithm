package test.NaverWebtoon210704;

import java.util.ArrayList;
import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution("bcdqweqwebcd")));

    }

    public static String[] solution(String s) {

        ArrayList<String> list = new ArrayList<>();

        //뒤쪽 시작 인덱스
        int behindIndex = 0;

        //앞 시작 인덱스
        int frontIndex = 0;
        int frontEnd = 0;

        //뒷 마지막 인덱스
        int behindEnd = s.length();


        for(int i=s.length()-1; i>=0; i--){
            //뒤에서 찾았으면
            if(s.charAt(frontIndex) == s.charAt(i)){
                behindIndex = i; //뒷 시작 저장

                frontEnd = frontIndex + (behindEnd-behindIndex); //앞 종료 저장

                String str = s.substring(frontIndex,frontEnd);
                list.add(str); // 앞에 자르기

                frontIndex = frontEnd; // 앞 시작 갱신

                behindEnd = i; // 뒷 종료 갱신
            }


        }

        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;

    }
}
