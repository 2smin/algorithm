package test.NaverWebtoon210704;

public class Task3 {
    public static void main(String[] args) {

        int count = solution("aaaaabbbbbbab","f");

        System.out.println(count);
    }

    public static int solution(String s, String t) {

        int count = 0;

        while(s.indexOf(t) != -1){
            int start = s.indexOf(t);
            s = s.substring(0,start) + s.substring(start+t.length());
            count++;
        }

        return count;
    }
}
