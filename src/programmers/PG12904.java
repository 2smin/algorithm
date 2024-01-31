package programmers;

public class PG12904 {
    public static void main(String[] args) {
        PG12904 pg = new PG12904();

        System.out.println(pg.solution("aaaaaa"));
    }

    static int pointer = 1;
    static String word;
    static int max = 1;

    public int solution(String s) {

        word = s;

        while(pointer<word.length()-1){

            System.out.println("pointer :" + pointer);
            if(word.charAt(pointer) == word.charAt(pointer+1)){
                int count = doCheck(pointer,pointer+1);
                max = Math.max(max,count);
            }
            if(word.charAt(pointer-1) == word.charAt(pointer+1)){
                int count = 1 + doCheck(pointer-1,pointer+1);
                max = Math.max(max,count);
            }
            pointer++;
        }

        return max;
    }

    public int doCheck(int left, int right){
        int count = 0;
        while(left >= 0 && right < (word.length())){
            if(word.charAt(left) == word.charAt(right)){
                System.out.println("left : " + left + ", right : " +  right);
                count+=2;
                left--;
                right++;
            }else{
                break;
            }
        }
        System.out.println("count :" + count);
        return count;
    }
}
