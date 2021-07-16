package algorithm_exp;

import java.util.Arrays;

public class kmp1 {

    public static void main(String[] args) {

        findHeadAndTailMatch("babcbcbabcbabc");
    }

    public static void findHeadAndTailMatch(String str){

        //1. 포인터 2개 설정 i 를 0,  j는 1부터돌린다.
        //2. i 랑 j가 일치하면 둘다 하나씩 올린다.
        //3. 다르면 i 를 0으로 보내고, j는 그 위치에서 다시 비교 시작

        int[] count = new int[str.length()];

        int i = 0;

        System.out.println(str);

        for(int j=1; j<str.length(); j++){

            System.out.println("i: " + i + "=" + str.charAt(i) + " , j: " + j + "=" + str.charAt(j));
            //둘이 다를 경우 i는 0으로
            if(i>0 && str.charAt(i) != str.charAt(j)){
                i = count[i-1];
                System.out.println("i move to : " + i);
            }


            if(str.charAt(i) == str.charAt(j)){
                count[j] = ++i;
                System.out.println("count[" + j + "] = " + i);
            }
            System.out.println();
        }

        System.out.println(Arrays.toString(count));

    }
}
